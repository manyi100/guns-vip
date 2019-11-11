package cn.stylefeng.guns.modular.sms.controller;

import cn.hutool.core.date.DateUtil;
import cn.stylefeng.guns.base.pojo.page.LayuiPageInfo;
import cn.stylefeng.guns.modular.sms.entity.Report;
import cn.stylefeng.guns.modular.sms.model.params.ReportParam;
import cn.stylefeng.guns.modular.sms.service.ReportService;
import cn.stylefeng.roses.core.base.controller.BaseController;
import cn.stylefeng.roses.core.reqres.response.ResponseData;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * 回执表控制器
 *
 * @author yqy
 * @Date 2019-10-31 10:42:41
 */
@Controller
@RequestMapping("/report")
public class ReportController extends BaseController {

    private String PREFIX = "/sms/report";

    @Autowired
    private ReportService reportService;

    /**
     * 跳转到主页面
     *
     * @author yqy
     * @Date 2019-10-31
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "/report.html";
    }

    /**
     * 新增页面
     *
     * @author yqy
     * @Date 2019-10-31
     */
    @RequestMapping("/add")
    public String add() {
        return PREFIX + "/report_add.html";
    }

    /**
     * 编辑页面
     *
     * @author yqy
     * @Date 2019-10-31
     */
    @RequestMapping("/edit")
    public String edit() {
        return PREFIX + "/report_edit.html";
    }

    /**
     * 新增接口
     *
     * @author yqy
     * @Date 2019-10-31
     */
    @RequestMapping("/addItem")
    @ResponseBody
    public ResponseData addItem(ReportParam reportParam) {
        this.reportService.add(reportParam);
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
    public ResponseData editItem(ReportParam reportParam) {
        this.reportService.update(reportParam);
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
    public ResponseData delete(ReportParam reportParam) {
        this.reportService.delete(reportParam);
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
    public ResponseData detail(ReportParam reportParam) {
        Report detail = this.reportService.getById(reportParam.getReportId());
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
    public LayuiPageInfo list(@RequestParam(required = false) String condition, @RequestParam(required = false) String senddate,ReportParam reportParam) {
        if(StringUtils.isNotEmpty(condition))
            reportParam.setStat(condition);
        if(StringUtils.isNotEmpty(senddate))
            reportParam.setSubmitDate(DateUtil.parseDate(senddate));
        return this.reportService.findPageBySpec(reportParam);
    }

}


