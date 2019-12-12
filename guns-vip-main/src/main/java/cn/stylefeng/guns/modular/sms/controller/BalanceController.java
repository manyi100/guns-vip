package cn.stylefeng.guns.modular.sms.controller;

import cn.stylefeng.guns.base.log.BussinessLog;
import cn.stylefeng.guns.base.pojo.page.LayuiPageInfo;
import cn.stylefeng.guns.base.shiro.ShiroUser;
import cn.stylefeng.guns.base.shiro.annotion.Permission;
import cn.stylefeng.guns.modular.sms.entity.Balance;
import cn.stylefeng.guns.modular.sms.entity.TGwSpConfig;
import cn.stylefeng.guns.modular.sms.model.params.BalanceParam;
import cn.stylefeng.guns.modular.sms.service.BalanceService;
import cn.stylefeng.guns.modular.sms.service.RechargeService;
import cn.stylefeng.guns.modular.sms.service.TGwSpConfigService;
import cn.stylefeng.guns.sys.core.constant.Const;
import cn.stylefeng.guns.sys.core.exception.enums.BizExceptionEnum;
import cn.stylefeng.guns.sys.core.log.LogObjectHolder;
import cn.stylefeng.guns.sys.core.shiro.ShiroKit;
import cn.stylefeng.guns.sys.modular.system.service.UserService;
import cn.stylefeng.roses.core.base.controller.BaseController;
import cn.stylefeng.roses.core.reqres.response.ResponseData;
import cn.stylefeng.roses.kernel.model.exception.ServiceException;
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
 * 余额变更表控制器
 *
 * @author yqy
 * @Date 2019-12-10 17:04:35
 */
@Controller
@RequestMapping("/balance")
public class BalanceController extends BaseController {

    private String PREFIX = "/sms/balance";
    @Autowired
    private RechargeService rechargeService;
    @Autowired
    RedisTemplate<String, String> redisTemplate;
    @Autowired
    TGwSpConfigService tGwSpConfigService;
    @Autowired
    UserService userService;
    @Autowired
    private BalanceService balanceService;

    /**
     * 跳转到主页面
     *
     * @author yqy
     * @Date 2019-12-10
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "/balance.html";
    }

    /**
     * 新增页面
     *
     * @author yqy
     * @Date 2019-12-10
     */
    @RequestMapping("/add")
    public String add() {
        return PREFIX + "/balance_add.html";
    }

    /**
     * 编辑页面
     *
     * @author yqy
     * @Date 2019-12-10
     */
    @RequestMapping("/edit")
    public String edit() {
        return PREFIX + "/balance_edit.html";
    }

    /**
     * 新增接口
     *
     * @author yqy
     * @Date 2019-12-10
     */
    @RequestMapping("/addItem")
    @BussinessLog(value = "余额变更")
    @Permission(Const.ADMIN_NAME)
    @Transactional
    @ResponseBody
    public ResponseData addItem(BalanceParam balanceParam) {
        ShiroUser user = ShiroKit.getUserNotNull();
        if(!ShiroKit.isAdmin())
        {
            throw new ServiceException(BizExceptionEnum.NO_PERMITION);
        }

        //插入记录表
        TGwSpConfig tGwconfig = tGwSpConfigService.getById(balanceParam.getSpnumid());
        String spbody= tGwconfig.getSpnumBody();
        Long entId=userService.getByAccount(spbody).getDeptId();

        int beforecount=Integer.parseInt(redisTemplate.opsForHash().get(spbody,"balance").toString());

        //更瓣redis
        int nowcnt=balanceParam.getOptcount();//更新数量
        redisTemplate.opsForHash().increment(spbody,"balance",nowcnt);
        //更新数据库
        nowcnt=Integer.parseInt(redisTemplate.opsForHash().get(spbody,"balance").toString());
        tGwconfig.setBalance(nowcnt);
        tGwSpConfigService.updateById(tGwconfig);
        //日志
        LogObjectHolder.me().set(balanceParam);

        balanceParam.setBeforecount(beforecount);//更新前余额
        balanceParam.setCurcount(nowcnt);//更新后余额
        balanceParam.setEntid(entId);
        balanceParam.setUserid(user.getId());
        balanceParam.setUsername(user.getAccount());
        balanceParam.setAdddate(new Date());
        this.balanceService.add(balanceParam);

        return ResponseData.success();
    }

    /**
     * 编辑接口
     *
     * @author yqy
     * @Date 2019-12-10
     */
    @RequestMapping("/editItem")
    @ResponseBody
    public ResponseData editItem(BalanceParam balanceParam) {
        this.balanceService.update(balanceParam);
        return ResponseData.success();
    }

    /**
     * 删除接口
     *
     * @author yqy
     * @Date 2019-12-10
     */
    @RequestMapping("/delete")
    @ResponseBody
    public ResponseData delete(BalanceParam balanceParam) {
        this.balanceService.delete(balanceParam);
        return ResponseData.success();
    }

    /**
     * 查看详情接口
     *
     * @author yqy
     * @Date 2019-12-10
     */
    @RequestMapping("/detail")
    @ResponseBody
    public ResponseData detail(BalanceParam balanceParam) {
        Balance detail = this.balanceService.getById(balanceParam.getBalanceid());
        return ResponseData.success(detail);
    }

    /**
     * 查询列表
     *
     * @author yqy
     * @Date 2019-12-10
     */
    @ResponseBody
    @RequestMapping("/list")
    public LayuiPageInfo list(@RequestParam(required = false) String condition, BalanceParam balanceParam) {
        if(StringUtils.isNotEmpty(condition))
            balanceParam.setSpnumid(Long.parseLong(condition));
        ShiroUser user = ShiroKit.getUserNotNull();
        if(!ShiroKit.isAdmin())
        {
            balanceParam.setEntid(user.getDeptId());
        }
        return this.balanceService.findPageBySpec(balanceParam);
    }

}


