package cn.stylefeng.guns.modular.sms.controller;

import cn.stylefeng.guns.base.pojo.page.LayuiPageInfo;
import cn.stylefeng.guns.base.shiro.ShiroUser;
import cn.stylefeng.guns.modular.sms.entity.Monthstat;
import cn.stylefeng.guns.modular.sms.model.params.MonthstatParam;
import cn.stylefeng.guns.modular.sms.service.MonthstatService;
import cn.stylefeng.guns.sys.core.shiro.ShiroKit;
import cn.stylefeng.roses.core.base.controller.BaseController;
import cn.stylefeng.roses.core.reqres.response.ResponseData;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * 月统计表控制器
 *
 * @author yqy
 * @Date 2019-11-14 16:04:20
 */
@Controller
@RequestMapping("/monthstat")
public class MonthstatController extends BaseController {

    private String PREFIX = "/sms/monthstat";

    @Autowired
    private MonthstatService monthstatService;

    /**
     * 跳转到主页面
     *
     * @author yqy
     * @Date 2019-11-14
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "/monthstat.html";
    }

    /**
     * 新增页面
     *
     * @author yqy
     * @Date 2019-11-14
     */
    @RequestMapping("/add")
    public String add() {
        return PREFIX + "/monthstat_add.html";
    }

    /**
     * 编辑页面
     *
     * @author yqy
     * @Date 2019-11-14
     */
    @RequestMapping("/edit")
    public String edit() {
        return PREFIX + "/monthstat_edit.html";
    }

    /**
     * 新增接口
     *
     * @author yqy
     * @Date 2019-11-14
     */
    @RequestMapping("/addItem")
    @ResponseBody
    public ResponseData addItem(MonthstatParam monthstatParam) {
        this.monthstatService.add(monthstatParam);
        return ResponseData.success();
    }

    /**
     * 编辑接口
     *
     * @author yqy
     * @Date 2019-11-14
     */
    @RequestMapping("/editItem")
    @ResponseBody
    public ResponseData editItem(MonthstatParam monthstatParam) {
        this.monthstatService.update(monthstatParam);
        return ResponseData.success();
    }

    /**
     * 删除接口
     *
     * @author yqy
     * @Date 2019-11-14
     */
    @RequestMapping("/delete")
    @ResponseBody
    public ResponseData delete(MonthstatParam monthstatParam) {
        this.monthstatService.delete(monthstatParam);
        return ResponseData.success();
    }

    /**
     * 查看详情接口
     *
     * @author yqy
     * @Date 2019-11-14
     */
    @RequestMapping("/detail")
    @ResponseBody
    public ResponseData detail(MonthstatParam monthstatParam) {
        Monthstat detail = this.monthstatService.getById(monthstatParam.getTaskId());
        return ResponseData.success(detail);
    }

    /**
     * 查询列表
     *
     * @author yqy
     * @Date 2019-11-14
     */
    @ResponseBody
    @RequestMapping("/list")
    public LayuiPageInfo list(@RequestParam(required = false) String condition, MonthstatParam monthstatParam) {
        if(StringUtils.isNotEmpty(condition))
            monthstatParam.setEntityName(condition);
        ShiroUser user = ShiroKit.getUserNotNull();
        if(!ShiroKit.isAdmin())
        {
            monthstatParam.setEntityName(user.getAccount());
        }
        return this.monthstatService.findPageBySpec(monthstatParam);
    }

}


