package cn.stylefeng.guns.modular.sms.controller;

import cn.stylefeng.guns.base.log.BussinessLog;
import cn.stylefeng.guns.base.pojo.page.LayuiPageInfo;
import cn.stylefeng.guns.base.shiro.ShiroUser;
import cn.stylefeng.guns.base.shiro.annotion.Permission;
import cn.stylefeng.guns.modular.sms.entity.Recharge;
import cn.stylefeng.guns.modular.sms.entity.TGwSpConfig;
import cn.stylefeng.guns.modular.sms.mapper.TGwSpConfigMapper;
import cn.stylefeng.guns.modular.sms.model.params.RechargeParam;
import cn.stylefeng.guns.modular.sms.service.RechargeService;
import cn.stylefeng.guns.modular.sms.service.TGwSpConfigService;
import cn.stylefeng.guns.sys.core.constant.Const;
import cn.stylefeng.guns.sys.core.exception.enums.BizExceptionEnum;
import cn.stylefeng.guns.sys.core.log.LogObjectHolder;
import cn.stylefeng.guns.sys.core.shiro.ShiroKit;
import cn.stylefeng.guns.sys.modular.system.service.UserService;
import cn.stylefeng.roses.core.base.controller.BaseController;
import cn.stylefeng.roses.core.reqres.response.ResponseData;
import cn.stylefeng.roses.core.reqres.response.SuccessResponseData;
import cn.stylefeng.roses.kernel.model.exception.ServiceException;
import cn.stylefeng.roses.kernel.model.exception.enums.CoreExceptionEnum;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;


/**
 * 充值记录表控制器
 *
 * @author yqy
 * @Date 2019-10-31 10:42:41
 */
@Controller
@RequestMapping("/recharge")
public class RechargeController extends BaseController {

    private String PREFIX = "/sms/recharge";

    @Autowired
    private RechargeService rechargeService;
    @Autowired
    RedisTemplate<String, String> redisTemplate;
    @Autowired
    TGwSpConfigService tGwSpConfigService;
    @Autowired
    UserService userService;
    /**
     * 跳转到主页面
     *
     * @author yqy
     * @Date 2019-10-31
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "/recharge.html";
    }

    /**
     * 新增页面
     *
     * @author yqy
     * @Date 2019-10-31
     */
    @RequestMapping("/add")
    public String add() {
        return PREFIX + "/recharge_add.html";
    }

    /**
     * 编辑页面
     *
     * @author yqy
     * @Date 2019-10-31
     */
    @RequestMapping("/edit")
    public String edit() {
        return PREFIX + "/recharge_edit.html";
    }

    /**
     * 新增接口
     *
     * @author yqy
     * @Date 2019-10-31
     */
    @BussinessLog(value = "短信充值")
    @RequestMapping("/addItem")
    @Permission(Const.ADMIN_NAME)
    @Transactional
    @ResponseBody
    public ResponseData addItem(RechargeParam rechargeParam) {

        ShiroUser user = ShiroKit.getUserNotNull();
        if(!ShiroKit.isAdmin())
        {
            throw new ServiceException(BizExceptionEnum.NO_PERMITION);
        }
        //插入记录表
        TGwSpConfig tGwconfig = tGwSpConfigService.getById(rechargeParam.getSpnumid());
        String spbody= tGwconfig.getSpnumBody();
        Long deptid=userService.getByAccount(spbody).getDeptId();
        rechargeParam.setEntid(deptid);
        rechargeParam.setAdddate(new Date());
        rechargeParam.setUserid(user.getId());
        this.rechargeService.add(rechargeParam);
        //更瓣redis
        int nowcnt=rechargeParam.getCnt();
        redisTemplate.opsForHash().increment(spbody,"balance",nowcnt);
        //更新数据库
        nowcnt=Integer.parseInt(redisTemplate.opsForHash().get(spbody,"balance").toString());
        tGwconfig.setBalance(nowcnt);
        tGwSpConfigService.updateById(tGwconfig);
        //日志
        LogObjectHolder.me().set(rechargeParam);

        return ResponseData.success();
    }

    /**
     * 编辑接口
     *
     * @author yqy
     * @Date 2019-10-31
     */
    @RequestMapping("/editItem")
    @Permission(Const.ADMIN_NAME)
    @ResponseBody
    public ResponseData editItem(RechargeParam rechargeParam) {
        this.rechargeService.update(rechargeParam);
        return ResponseData.success();
    }

    /**
     * 删除接口
     *
     * @author yqy
     * @Date 2019-10-31
     */
    @RequestMapping("/delete")
    @Permission(Const.ADMIN_NAME)
    @ResponseBody
    public ResponseData delete(RechargeParam rechargeParam) {
        this.rechargeService.delete(rechargeParam);
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
    public ResponseData detail(RechargeParam rechargeParam) {
        Recharge detail = this.rechargeService.getById(rechargeParam.getRechargeid());
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
    public LayuiPageInfo list(@RequestParam(required = false) String condition, RechargeParam rechargeParam) {
        if(StringUtils.isNotEmpty(condition))
            rechargeParam.setSpnumid(Long.parseLong(condition));
        ShiroUser user = ShiroKit.getUserNotNull();
        if(!ShiroKit.isAdmin())
        {
            rechargeParam.setEntid(user.getDeptId());
        }
        return this.rechargeService.findPageBySpec(rechargeParam);
    }

    /**
     * 获取当前用户的条数余额
     * @return
     */
    @RequestMapping("/currentBalance")
    @ResponseBody
    public ResponseData getCurrentBalance() {

        ShiroUser currentUser = ShiroKit.getUser();
        if (currentUser == null) {
            throw new ServiceException(CoreExceptionEnum.NO_CURRENT_USER);
        }
        String nowcnt ="0";
        if(!ShiroKit.isAdmin()) {
            String account = currentUser.getAccount();
            nowcnt=redisTemplate.opsForHash().get(account, "balance").toString();
        }
        return new SuccessResponseData(nowcnt);
    }

}


