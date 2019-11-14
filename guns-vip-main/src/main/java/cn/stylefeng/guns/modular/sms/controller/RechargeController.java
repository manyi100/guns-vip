package cn.stylefeng.guns.modular.sms.controller;

import cn.stylefeng.guns.base.pojo.page.LayuiPageInfo;
import cn.stylefeng.guns.base.shiro.ShiroUser;
import cn.stylefeng.guns.modular.sms.entity.Recharge;
import cn.stylefeng.guns.modular.sms.mapper.TGwSpConfigMapper;
import cn.stylefeng.guns.modular.sms.model.params.RechargeParam;
import cn.stylefeng.guns.modular.sms.service.RechargeService;
import cn.stylefeng.guns.modular.sms.service.TGwSpConfigService;
import cn.stylefeng.guns.sys.core.shiro.ShiroKit;
import cn.stylefeng.roses.core.base.controller.BaseController;
import cn.stylefeng.roses.core.reqres.response.ResponseData;
import cn.stylefeng.roses.core.reqres.response.SuccessResponseData;
import cn.stylefeng.roses.kernel.model.exception.ServiceException;
import cn.stylefeng.roses.kernel.model.exception.enums.CoreExceptionEnum;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
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
    @RequestMapping("/addItem")
    @ResponseBody
    public ResponseData addItem(RechargeParam rechargeParam) {
        ShiroUser user = ShiroKit.getUserNotNull();
        rechargeParam.setEntid(user.getDeptId());
        rechargeParam.setAdddate(new Date());
        rechargeParam.setUserid(user.getId());
        this.rechargeService.add(rechargeParam);
        String spbody=tGwSpConfigService.getById(rechargeParam.getSpnumid()).getSpnumBody();
        int nowcnt=Integer.parseInt(redisTemplate.opsForHash().get(spbody,"balance").toString());
        nowcnt=nowcnt+rechargeParam.getCnt();
        redisTemplate.opsForHash().put(spbody,"balance",String.valueOf(nowcnt));
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
        if(!user.getRoleList().contains(1L))
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


