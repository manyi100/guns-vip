package cn.stylefeng.guns.modular.sms.controller;

import cn.stylefeng.guns.base.pojo.page.LayuiPageInfo;
import cn.stylefeng.guns.modular.sms.entity.TcGwSp;
import cn.stylefeng.guns.modular.sms.model.params.TcGwSpParam;
import cn.stylefeng.guns.modular.sms.service.TcGwSpService;
import cn.stylefeng.roses.core.base.controller.BaseController;
import cn.stylefeng.roses.core.reqres.response.ResponseData;
import org.apache.commons.lang3.StringUtils;
import org.beetl.ext.fn.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * 运营商配置表控制器
 *
 * @author yqy
 * @Date 2019-10-31 10:42:41
 */
@Controller
@RequestMapping("/tcGwSp")
public class TcGwSpController extends BaseController {

    private String PREFIX = "/sms/tcGwSp";

    @Autowired
    private TcGwSpService tcGwSpService;

    /**
     * 跳转到主页面
     *
     * @author yqy
     * @Date 2019-10-31
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "/tcGwSp.html";
    }

    /**
     * 新增页面
     *
     * @author yqy
     * @Date 2019-10-31
     */
    @RequestMapping("/add")
    public String add() {
        return PREFIX + "/tcGwSp_add.html";
    }

    /**
     * 编辑页面
     *
     * @author yqy
     * @Date 2019-10-31
     */
    @RequestMapping("/edit")
    public String edit() {
        return PREFIX + "/tcGwSp_edit.html";
    }

    /**
     * 新增接口
     *
     * @author yqy
     * @Date 2019-10-31
     */
    @RequestMapping("/addItem")
    @ResponseBody
    public ResponseData addItem(TcGwSpParam tcGwSpParam) {
        this.tcGwSpService.add(tcGwSpParam);
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
    public ResponseData editItem(TcGwSpParam tcGwSpParam) {
        this.tcGwSpService.update(tcGwSpParam);
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
    public ResponseData delete(TcGwSpParam tcGwSpParam) {
        this.tcGwSpService.delete(tcGwSpParam);
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
    public ResponseData detail(TcGwSpParam tcGwSpParam) {
        TcGwSp detail = this.tcGwSpService.getById(tcGwSpParam.getSpid());
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
    public LayuiPageInfo list(@RequestParam(required = false) String condition, TcGwSpParam tcGwSpParam) {
        if(StringUtils.isNoneEmpty(condition))
            tcGwSpParam.setSpname(condition);
        return this.tcGwSpService.findPageBySpec(tcGwSpParam);
    }

}


