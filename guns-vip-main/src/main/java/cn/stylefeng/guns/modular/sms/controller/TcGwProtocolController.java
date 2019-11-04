package cn.stylefeng.guns.modular.sms.controller;

import cn.stylefeng.guns.base.pojo.page.LayuiPageInfo;
import cn.stylefeng.guns.modular.sms.entity.TcGwProtocol;
import cn.stylefeng.guns.modular.sms.model.params.TcGwProtocolParam;
import cn.stylefeng.guns.modular.sms.service.TcGwProtocolService;
import cn.stylefeng.roses.core.base.controller.BaseController;
import cn.stylefeng.roses.core.reqres.response.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * 短信协议配置表控制器
 *
 * @author yqy
 * @Date 2019-10-31 10:42:41
 */
@Controller
@RequestMapping("/tcGwProtocol")
public class TcGwProtocolController extends BaseController {

    private String PREFIX = "/sms/tcGwProtocol";

    @Autowired
    private TcGwProtocolService tcGwProtocolService;

    /**
     * 跳转到主页面
     *
     * @author yqy
     * @Date 2019-10-31
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "/tcGwProtocol.html";
    }

    /**
     * 新增页面
     *
     * @author yqy
     * @Date 2019-10-31
     */
    @RequestMapping("/add")
    public String add() {
        return PREFIX + "/tcGwProtocol_add.html";
    }

    /**
     * 编辑页面
     *
     * @author yqy
     * @Date 2019-10-31
     */
    @RequestMapping("/edit")
    public String edit() {
        return PREFIX + "/tcGwProtocol_edit.html";
    }

    /**
     * 新增接口
     *
     * @author yqy
     * @Date 2019-10-31
     */
    @RequestMapping("/addItem")
    @ResponseBody
    public ResponseData addItem(TcGwProtocolParam tcGwProtocolParam) {
        this.tcGwProtocolService.add(tcGwProtocolParam);
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
    public ResponseData editItem(TcGwProtocolParam tcGwProtocolParam) {
        this.tcGwProtocolService.update(tcGwProtocolParam);
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
    public ResponseData delete(TcGwProtocolParam tcGwProtocolParam) {
        this.tcGwProtocolService.delete(tcGwProtocolParam);
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
    public ResponseData detail(TcGwProtocolParam tcGwProtocolParam) {
        TcGwProtocol detail = this.tcGwProtocolService.getById(tcGwProtocolParam.getProtocolid());
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
    public LayuiPageInfo list(TcGwProtocolParam tcGwProtocolParam) {
        return this.tcGwProtocolService.findPageBySpec(tcGwProtocolParam);
    }

}


