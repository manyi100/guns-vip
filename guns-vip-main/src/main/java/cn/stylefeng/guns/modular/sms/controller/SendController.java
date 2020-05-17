package cn.stylefeng.guns.modular.sms.controller;

import cn.hutool.core.date.DateUtil;
import cn.stylefeng.guns.base.pojo.page.LayuiPageInfo;
import cn.stylefeng.guns.base.shiro.ShiroUser;
import cn.stylefeng.guns.modular.demos.controller.ExcelController;
import cn.stylefeng.guns.modular.sms.entity.Contacts;
import cn.stylefeng.guns.modular.sms.entity.Send;
import cn.stylefeng.guns.modular.sms.entity.TGwSpConfig;
import cn.stylefeng.guns.modular.sms.model.params.SendParam;
import cn.stylefeng.guns.modular.sms.service.ContactsService;
import cn.stylefeng.guns.modular.sms.service.DaystatService;
import cn.stylefeng.guns.modular.sms.service.SendService;
import cn.stylefeng.guns.modular.sms.service.TGwSpConfigService;
import cn.stylefeng.guns.modular.sms.service.impl.SendServiceImpl;
import cn.stylefeng.guns.sys.core.shiro.ShiroKit;
import cn.stylefeng.guns.sys.modular.system.entity.User;
import cn.stylefeng.guns.sys.modular.system.service.UserService;
import cn.stylefeng.roses.core.base.controller.BaseController;
import cn.stylefeng.roses.core.reqres.response.ResponseData;
import cn.stylefeng.roses.core.reqres.response.SuccessResponseData;
import cn.stylefeng.roses.kernel.model.exception.ServiceException;
import cn.stylefeng.roses.kernel.model.exception.enums.CoreExceptionEnum;
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zx.sms.common.util.MsgId;
import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.apache.rocketmq.common.message.Message;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;


/**
 * 发送表控制器
 *
 * @author yqy
 * @Date 2019-10-31 10:42:41
 */
@EnableAsync
@Controller
@RequestMapping("/send")
public class SendController extends BaseController {

    private String PREFIX = "/sms/send";

    @Autowired
    private SendService sendService;
    @Autowired
    private UserService userService;
    @Autowired
    private DaystatService daystatService;
    @Autowired
    private ContactsService contactsService;
    @Autowired
    private TGwSpConfigService tGwSpConfigService;
    private static LinkedBlockingQueue<Send> uploadData=new LinkedBlockingQueue<>();

    @Autowired
    ExcelController excelController;

    @Autowired
    SendServiceImpl sendServiceImpl;
    /**
     * 跳转到主页面
     *
     * @author yqy
     * @Date 2019-10-31
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "/send.html";
    }

    /**
     * 新增页面
     *
     * @author yqy
     * @Date 2019-10-31
     */
    @RequestMapping("/add")
    public String add() {
        return PREFIX + "/send_add.html";
    }

    @RequestMapping(value = "/add2")
    public String add2() {
        return PREFIX + "/send_add2.html";
    }

    /**
     * 编辑页面
     *
     * @author yqy
     * @Date 2019-10-31
     */
    @RequestMapping("/edit")
    public String edit() {
        return PREFIX + "/send_edit.html";
    }

    /**
     * 新增接口
     *
     * @author yqy
     * @Date 2019-10-31
     */
    @RequestMapping("/addItem")
    @ResponseBody
    public ResponseData addItem(@RequestParam String groupid, SendParam sendParam) {

        String account=ShiroKit.getUser().getAccount();
        String phonesStr=sendParam.getDestterminalId();
        String content=sendParam.getContent().trim();
        String entid="";
        String line=System.getProperty("line.separator");
        String[] phones=new String[0];
        if(StringUtils.isNotEmpty(phonesStr))
            phones=phonesStr.split(line);
        String spnum="";
        if(ShiroKit.isAdmin())
        {
            spnum="106928113330";
            account="3330";
        }else
        {
            QueryWrapper<TGwSpConfig> queryWrapper=new QueryWrapper<>();
            queryWrapper.eq("spnumbody",account);
            TGwSpConfig spconfig = tGwSpConfigService.getOne(queryWrapper);
            spnum= spconfig.getSpnum();
        }

        //少量发送
        Send signsend=null;
        if(StringUtils.isNotEmpty(phonesStr)&&StringUtils.isNotEmpty(content)) {
            for (String phone:phones) {
                signsend = new Send();
                signsend.setDestterminalId(phone.trim());
                signsend.setContent(content);
                uploadData.add(signsend);
            }
        }
        //通讯录发送
        if(StringUtils.isNotEmpty(groupid))
        {
            entid= String.valueOf(ShiroKit.getUser().getDeptId());
            QueryWrapper<Contacts> queryWrapper=new QueryWrapper<>();
            queryWrapper.eq("groupid",groupid);
            queryWrapper.eq("entid",entid);
            List<Contacts> contactslist = contactsService.list(queryWrapper);
            for (Contacts contacts : contactslist) {
                Send send=new Send();
                send.setDestterminalId(contacts.getMobile().trim());
                send.setContent(content);
                uploadData.add(send);
            }
            contactslist.clear();
        }
        //上传文件发送
        HttpServletRequest httpServletRequest = getHttpServletRequest();
        ArrayList<Send> batchData = (ArrayList) excelController.getUploadSendData(httpServletRequest);
        if(batchData!=null)
        {
            Send send = batchData.get(0);
            if(StringUtils.isEmpty(send.getContent()))
            {
                for (Send batchDatum : batchData) {
                    batchDatum.setContent(content);
                    uploadData.add(batchDatum);
                }
                batchData.clear();
            }
            uploadData.addAll(batchData);
            batchData.clear();
            httpServletRequest.getSession().setAttribute("upFile",null);
        }
        if(uploadData.isEmpty()){
            return ResponseData.error("请填写发送号码或上传文件。");
        }
        //异步提交到MQ对列
        sendServiceImpl.AsyncBacthSend(uploadData,account,spnum);
        return ResponseData.success();
    }

    /**
     * 编辑接口
     *
     * @author yqy
     * @Date 2019-10-31
     */
    @RequestMapping("/editItem")
    @ResponseBody
    public ResponseData editItem(SendParam sendParam) {
        this.sendService.update(sendParam);
        return ResponseData.success();
    }

    /**
     * 删除接口
     *
     * @author yqy
     * @Date 2019-10-31
     */
    @RequestMapping("/delete")
    @ResponseBody
    public ResponseData delete(SendParam sendParam) {
        this.sendService.delete(sendParam);
        return ResponseData.success();
    }

    /**
     * 查看详情接口
     *
     * @author yqy
     * @Date 2019-10-31
     */
    @RequestMapping("/detail")
    @ResponseBody
    public ResponseData detail(SendParam sendParam) {
        Send detail = this.sendService.getById(sendParam.getTaskId());
        return ResponseData.success(detail);
    }

    /**
     * 查询列表
     *
     * @author yqy
     * @Date 2019-10-31
     */
    @ResponseBody
    @RequestMapping("/list")
    public LayuiPageInfo list(@RequestParam(required = false) String destterminalId,
                              @RequestParam(required = false) String submitDate ,
                              @RequestParam(required = false) String entityName ,
                              SendParam sendParam) {
        if(StringUtils.isNotEmpty(destterminalId))
            sendParam.setDestterminalId(destterminalId);
        if(StringUtils.isNotEmpty(entityName))
            sendParam.setEntityName(entityName);
//        sendParam.setEntityName("3331");
//        if(StringUtils.isEmpty(submitDate))
//        {
//            SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
//            String dateStr=sdf.format(new Date());
////            sendParam.setSubmitDate(DateUtil.parse(dateStr, "yyyy-MM-dd"));
//            submitDate=dateStr;
//        }
        if(!ShiroKit.isAdmin())
            sendParam.setEntityName(ShiroKit.getUser().getAccount());

        return this.sendService.findPageBySpec(sendParam);
    }

    /**
     * 获取日发送量
     */

    @RequestMapping("/getDayCount")
    @ResponseBody
    public ResponseData getDayCount() {

        ShiroUser currentUser = ShiroKit.getUser();
        if (currentUser == null) {
            throw new ServiceException(CoreExceptionEnum.NO_CURRENT_USER);
        }
        int nowcnt =0;
        if(!ShiroKit.isAdmin()) {
            String account = currentUser.getAccount();
//            nowcnt=sendService.getDayCount(account);
            nowcnt=daystatService.getDayCount(account);
        }else
        {
//            nowcnt=sendService.getDayCount("");
            nowcnt=daystatService.getDayCount("");
        }
        return new SuccessResponseData(nowcnt);
    }
    /**
     * 获取月发送量
     */

    @RequestMapping("/getMonthCount")
    @ResponseBody
    public ResponseData getMonthCount() {

        ShiroUser currentUser = ShiroKit.getUser();
        if (currentUser == null) {
            throw new ServiceException(CoreExceptionEnum.NO_CURRENT_USER);
        }
        int nowcnt =0;
        if(!ShiroKit.isAdmin()) {
            String account = currentUser.getAccount();
//            nowcnt=sendService.getMonthCount(account);
            nowcnt=daystatService.getMonthCount(account);
        }else
        {
//            nowcnt=sendService.getMonthCount("");
            nowcnt=daystatService.getMonthCount("");
        }
        return new SuccessResponseData(nowcnt);
    }
    /**
     * 获取月发送量(短信发送走势图图标)
     */

    @RequestMapping("/getThisMonthList")
    @ResponseBody
    public ResponseData getThisMonthList() {

        ShiroUser currentUser = ShiroKit.getUser();
        if (currentUser == null) {
            throw new ServiceException(CoreExceptionEnum.NO_CURRENT_USER);
        }
        List<Map<String, Object>> nowcnt;
        if(!ShiroKit.isAdmin()) {
            String account = currentUser.getAccount();
//            nowcnt=sendService.getThisMonth(account);
            nowcnt=daystatService.getThisMonth(account);
        }else
        {
//            nowcnt=sendService.getThisMonth("");
            nowcnt=daystatService.getThisMonth("");
        }
        return new SuccessResponseData(nowcnt);
    }

    /**
     * 获取所有子帐号数
     */

    @RequestMapping("/getAccountNum")
    @ResponseBody
    public ResponseData getAccountNum() {

        ShiroUser currentUser = ShiroKit.getUser();
        if (currentUser == null) {
            throw new ServiceException(CoreExceptionEnum.NO_CURRENT_USER);
        }
        int nowcnt;
        if(!ShiroKit.isAdmin()) {
            String account = currentUser.getAccount();
            QueryWrapper<User> queryWrapper=new QueryWrapper<>();
            queryWrapper.eq("account",account);
            nowcnt=userService.count(queryWrapper);
        }else
        {
            nowcnt=userService.count();
        }
        return new SuccessResponseData(nowcnt);
    }

}


