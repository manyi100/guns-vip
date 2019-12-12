package cn.stylefeng.guns.modular.sms.controller;

import cn.stylefeng.guns.base.pojo.page.LayuiPageInfo;
import cn.stylefeng.guns.base.shiro.ShiroUser;
import cn.stylefeng.guns.modular.sms.entity.Contactsgroup;
import cn.stylefeng.guns.modular.sms.model.params.ContactsgroupParam;
import cn.stylefeng.guns.modular.sms.service.ContactsgroupService;
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
 * 联系人分组控制器
 *
 * @author yqy
 * @Date 2019-12-10 17:04:35
 */
@Controller
@RequestMapping("/contactsgroup")
public class ContactsgroupController extends BaseController {

    private String PREFIX = "/sms/contactsgroup";

    @Autowired
    private ContactsgroupService contactsgroupService;

    /**
     * 跳转到主页面
     *
     * @author yqy
     * @Date 2019-12-10
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "/contactsgroup.html";
    }

    /**
     * 新增页面
     *
     * @author yqy
     * @Date 2019-12-10
     */
    @RequestMapping("/add")
    public String add() {
        return PREFIX + "/contactsgroup_add.html";
    }

    /**
     * 编辑页面
     *
     * @author yqy
     * @Date 2019-12-10
     */
    @RequestMapping("/edit")
    public String edit() {
        return PREFIX + "/contactsgroup_edit.html";
    }

    /**
     * 新增接口
     *
     * @author yqy
     * @Date 2019-12-10
     */
    @RequestMapping("/addItem")
    @ResponseBody
    public ResponseData addItem(ContactsgroupParam contactsgroupParam) {
        ShiroUser user = ShiroKit.getUserNotNull();
        contactsgroupParam.setEntid(user.getDeptId());
        contactsgroupParam.setAdddate(new Date());
        this.contactsgroupService.add(contactsgroupParam);
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
    public ResponseData editItem(ContactsgroupParam contactsgroupParam) {
        this.contactsgroupService.update(contactsgroupParam);
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
    public ResponseData delete(ContactsgroupParam contactsgroupParam) {
        this.contactsgroupService.delete(contactsgroupParam);
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
    public ResponseData detail(ContactsgroupParam contactsgroupParam) {
        Contactsgroup detail = this.contactsgroupService.getById(contactsgroupParam.getGroupid());
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
    public LayuiPageInfo list(@RequestParam(required = false) String condition, ContactsgroupParam contactsgroupParam) {
        if(StringUtils.isNotEmpty(condition))
            contactsgroupParam.setGroupname(condition);
        ShiroUser user = ShiroKit.getUserNotNull();
        if(!ShiroKit.isAdmin())
        {
            contactsgroupParam.setEntid(user.getDeptId());
        }
        return this.contactsgroupService.findPageBySpec(contactsgroupParam);
    }

}


