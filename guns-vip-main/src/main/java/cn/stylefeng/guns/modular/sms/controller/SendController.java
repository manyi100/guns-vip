package cn.stylefeng.guns.modular.sms.controller;

import cn.hutool.core.date.DateUtil;
import cn.stylefeng.guns.base.pojo.page.LayuiPageInfo;
import cn.stylefeng.guns.modular.sms.entity.Send;
import cn.stylefeng.guns.modular.sms.model.params.SendParam;
import cn.stylefeng.guns.modular.sms.service.SendService;
import cn.stylefeng.guns.sys.core.shiro.ShiroKit;
import cn.stylefeng.roses.core.base.controller.BaseController;
import cn.stylefeng.roses.core.reqres.response.ResponseData;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;


/**
 * 发送表控制器
 *
 * @author yqy
 * @Date 2019-10-31 10:42:41
 */
@Controller
@RequestMapping("/send")
public class SendController extends BaseController {

    private String PREFIX = "/sms/send";

    @Autowired
    private SendService sendService;

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
    public ResponseData addItem(SendParam sendParam) {
        this.sendService.add(sendParam);
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
    public LayuiPageInfo list(@RequestParam(required = false) String condition,
                              @RequestParam(required = false) String senddate ,
                              SendParam sendParam) {
        if(StringUtils.isNotEmpty(condition))
            sendParam.setDestterminalId(condition);
        if(StringUtils.isNotEmpty(senddate))
            sendParam.setSubmitDate(DateUtil.parse(senddate,"yyyy-MM-dd"));
        if(!ShiroKit.isAdmin())
            sendParam.setEntityName(ShiroKit.getUser().getAccount());

        return this.sendService.findPageBySpec(sendParam);
    }

}


