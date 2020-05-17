package cn.stylefeng.guns.modular.sms.controller;

import cn.stylefeng.guns.base.pojo.page.LayuiPageInfo;
import cn.stylefeng.guns.base.shiro.ShiroUser;
import cn.stylefeng.guns.modular.sms.entity.Signname;
import cn.stylefeng.guns.modular.sms.entity.TGwSpConfig;
import cn.stylefeng.guns.modular.sms.model.params.SignnameParam;
import cn.stylefeng.guns.modular.sms.service.SignnameService;
import cn.stylefeng.guns.modular.sms.service.TGwSpConfigService;
import cn.stylefeng.guns.sys.core.constant.factory.ConstantFactory;
import cn.stylefeng.guns.sys.core.exception.enums.BizExceptionEnum;
import cn.stylefeng.guns.sys.core.shiro.ShiroKit;
import cn.stylefeng.roses.core.base.controller.BaseController;
import cn.stylefeng.roses.core.reqres.response.ResponseData;
import cn.stylefeng.roses.kernel.model.exception.ServiceException;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.segments.MergeSegments;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * 签名配置表控制器
 *
 * @author yqy
 * @Date 2019-10-31 10:42:41
 */
@Controller
@RequestMapping("/signname")
public class SignnameController extends BaseController {

    private String PREFIX = "/sms/signname";

    @Autowired
    private SignnameService signnameService;
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
        return PREFIX + "/signname.html";
    }

    /**
     * 新增页面
     *
     * @author yqy
     * @Date 2019-10-31
     */
    @RequestMapping("/add")
    public String add() {
        return PREFIX + "/signname_add.html";
    }

    /**
     * 编辑页面
     *
     * @author yqy
     * @Date 2019-10-31
     */
    @RequestMapping("/edit")
    public String edit() {
        return PREFIX + "/signname_edit.html";
    }

    /**
     * 新增接口
     *
     * @author yqy
     * @Date 2019-10-31
     */
    @RequestMapping("/addItem")
    @ResponseBody
    public ResponseData addItem(SignnameParam signnameParam) {
        ShiroUser user = ShiroKit.getUser();
        if(!ShiroKit.isAdmin())
        {
//            signnameParam.setStatus(2);//2、待审核 3、驳回
//            String account=user.getAccount();
//            Wrapper<TGwSpConfig> tGwSpConfigWrapper = new QueryWrapper<>();
//            tGwSpConfigWrapper.getEntity().setSpnumBody(account);
//            TGwSpConfig one = tGwSpConfigService.getOne(tGwSpConfigWrapper);
//            signnameParam.setEntid(one.getSpnumId());
            throw new ServiceException(BizExceptionEnum.NO_PERMITION);
        }

        this.signnameService.add(signnameParam);
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
    public ResponseData editItem(SignnameParam signnameParam) {
        this.signnameService.update(signnameParam);
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
    public ResponseData delete(SignnameParam signnameParam) {
        this.signnameService.delete(signnameParam);
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
    public ResponseData detail(SignnameParam signnameParam) {
        Signname detail = this.signnameService.getById(signnameParam.getSignid());
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
    public LayuiPageInfo list(@RequestParam(required = false) String condition, SignnameParam signnameParam) {
        if(StringUtils.isNotEmpty(condition))
            signnameParam.setSignname(condition);
        return this.signnameService.findPageBySpec(signnameParam);
    }
    /**
     * 查询列表
     *
     * @author yqy
     * @Date 2019-10-31
     */
    @ResponseBody
    @RequestMapping("/getTypelist")
    public LayuiPageInfo getTypelist(SignnameParam signnameParam) {
        return this.signnameService.findPageBySpec(signnameParam);
    }

}


