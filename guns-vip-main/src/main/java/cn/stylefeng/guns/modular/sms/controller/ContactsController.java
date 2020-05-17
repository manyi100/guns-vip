package cn.stylefeng.guns.modular.sms.controller;

import cn.stylefeng.guns.base.db.entity.DatabaseInfo;
import cn.stylefeng.guns.base.pojo.page.LayuiPageInfo;
import cn.stylefeng.guns.base.shiro.ShiroUser;
import cn.stylefeng.guns.modular.sms.entity.Contacts;
import cn.stylefeng.guns.modular.sms.entity.Contactsgroup;
import cn.stylefeng.guns.modular.sms.model.params.ContactsParam;
import cn.stylefeng.guns.modular.sms.service.ContactsService;
import cn.stylefeng.guns.modular.sms.service.ContactsgroupService;
import cn.stylefeng.guns.sys.core.shiro.ShiroKit;
import cn.stylefeng.roses.core.base.controller.BaseController;
import cn.stylefeng.roses.core.reqres.response.ResponseData;
import cn.stylefeng.roses.kernel.model.exception.ServiceException;
import cn.stylefeng.roses.kernel.model.exception.enums.CoreExceptionEnum;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


/**
 * 联系人控制器
 *
 * @author yqy
 * @Date 2019-12-10 17:04:35
 */
@Controller
@RequestMapping("/contacts")
public class ContactsController extends BaseController {

    private String PREFIX = "/sms/contacts";

    @Autowired
    private ContactsService contactsService;

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
        return PREFIX + "/contacts.html";
    }

    /**
     * 新增页面
     *
     * @author yqy
     * @Date 2019-12-10
     */
    @RequestMapping("/add")
    public String add() {
        return PREFIX + "/contacts_add.html";
    }

    /**
     * 编辑页面
     *
     * @author yqy
     * @Date 2019-12-10
     */
    @RequestMapping("/edit")
    public String edit() {
        return PREFIX + "/contacts_edit.html";
    }

    /**
     * 新增接口
     *
     * @author yqy
     * @Date 2019-12-10@RequestParam(required = true) String condition,
     */
    @RequestMapping("/addItem")
    @ResponseBody
    public ResponseData addItem(ContactsParam contactsParam) {
        ShiroUser user = ShiroKit.getUserNotNull();
        contactsParam.setEntid(user.getDeptId());
        Integer groupid = contactsParam.getGroupid();
        if(null==groupid ||StringUtils.isEmpty(groupid+""))
        {
            return ResponseData.error("请选择联系人分组");
//            throw new ServiceException(CoreExceptionEnum.valueOf("请选择联系人分组"));
//            throw new ServiceException(CoreExceptionEnum.NO_CURRENT_USER);
        }
        Date birthday = contactsParam.getBirthday();
        if(null==birthday)
            contactsParam.setBirthday(null);
        contactsParam.setAdddate(new Date());
        this.contactsService.add(contactsParam);
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
    public ResponseData editItem(ContactsParam contactsParam) {
        this.contactsService.update(contactsParam);
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
    public ResponseData delete(ContactsParam contactsParam) {
        this.contactsService.delete(contactsParam);
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
    public ResponseData detail(ContactsParam contactsParam) {
        Contacts detail = this.contactsService.getById(contactsParam.getContactsid());
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
    public LayuiPageInfo list(@RequestParam(required = false) String condition, ContactsParam contactsParam) {
        if(StringUtils.isNotEmpty(condition))
            contactsParam.setMobile(condition);
        ShiroUser user = ShiroKit.getUserNotNull();
        if(!ShiroKit.isAdmin())
        {
            contactsParam.setEntid(user.getDeptId());
        }
        return this.contactsService.findPageBySpec(contactsParam);
    }
    @ResponseBody
    @RequestMapping("/gen")
    public ResponseData gendropList() {
        ShiroUser user = ShiroKit.getUserNotNull();
        QueryWrapper<Contactsgroup> objectQueryWrapper = new QueryWrapper<>();
        objectQueryWrapper.eq("entid",user.getDeptId());
        List<Contactsgroup> all = contactsgroupService.list(objectQueryWrapper);
        return ResponseData.success(all);
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }
}


