package cn.stylefeng.guns.modular.sms.controller;

import cn.stylefeng.guns.base.pojo.page.LayuiPageInfo;
import cn.stylefeng.guns.base.shiro.ShiroUser;
import cn.stylefeng.guns.modular.sms.entity.Daystat;
import cn.stylefeng.guns.modular.sms.model.params.DaystatParam;
import cn.stylefeng.guns.modular.sms.service.DaystatService;
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
 * 日统计表控制器
 *
 * @author yqy
 * @Date 2019-11-14 15:40:09
 */
@Controller
@RequestMapping("/daystat")
public class DaystatController extends BaseController {

    private String PREFIX = "/sms/daystat";

    @Autowired
    private DaystatService daystatService;

    /**
     * 跳转到主页面
     *
     * @author yqy
     * @Date 2019-11-14
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "/daystat.html";
    }

    /**
     * 新增页面
     *
     * @author yqy
     * @Date 2019-11-14
     */
    @RequestMapping("/add")
    public String add() {
        return PREFIX + "/daystat_add.html";
    }

    /**
     * 编辑页面
     *
     * @author yqy
     * @Date 2019-11-14
     */
    @RequestMapping("/edit")
    public String edit() {
        return PREFIX + "/daystat_edit.html";
    }

    /**
     * 新增接口
     *
     * @author yqy
     * @Date 2019-11-14
     */
    @RequestMapping("/addItem")
    @ResponseBody
    public ResponseData addItem(DaystatParam daystatParam) {
        this.daystatService.add(daystatParam);
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
    public ResponseData editItem(DaystatParam daystatParam) {
        this.daystatService.update(daystatParam);
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
    public ResponseData delete(DaystatParam daystatParam) {
        this.daystatService.delete(daystatParam);
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
    public ResponseData detail(DaystatParam daystatParam) {
        Daystat detail = this.daystatService.getById(daystatParam.getTaskId());
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
    public LayuiPageInfo list(@RequestParam(required = false) String condition, DaystatParam daystatParam) {
        if(StringUtils.isNotEmpty(condition))
            daystatParam.setEntityName(condition);
        ShiroUser user = ShiroKit.getUserNotNull();
        if(!ShiroKit.isAdmin())
        {
            daystatParam.setEntityName(user.getAccount());
        }
        return this.daystatService.findPageBySpec(daystatParam);
    }

}


