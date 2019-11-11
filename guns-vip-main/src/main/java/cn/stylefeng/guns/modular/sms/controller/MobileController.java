package cn.stylefeng.guns.modular.sms.controller;

import cn.stylefeng.guns.base.pojo.page.LayuiPageFactory;
import cn.stylefeng.guns.base.pojo.page.LayuiPageInfo;
import cn.stylefeng.guns.modular.sms.entity.Mobile;
import cn.stylefeng.guns.modular.sms.model.params.MobileParam;
import cn.stylefeng.guns.modular.sms.service.MobileService;
import cn.stylefeng.guns.modular.sms.wapper.MobileWrapper;
import cn.stylefeng.guns.sys.modular.system.warpper.LogWrapper;
import cn.stylefeng.roses.core.base.controller.BaseController;
import cn.stylefeng.roses.core.reqres.response.ResponseData;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;


/**
 * 号段配置表控制器
 *
 * @author yqy
 * @Date 2019-10-31 10:42:41
 */
@Controller
@RequestMapping("/mobile")
public class MobileController extends BaseController {

    private String PREFIX = "/sms/mobile";

    @Autowired
    private MobileService mobileService;

    /**
     * 跳转到主页面
     *
     * @author yqy
     * @Date 2019-10-31
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "/mobile.html";
    }

    /**
     * 新增页面
     *
     * @author yqy
     * @Date 2019-10-31
     */
    @RequestMapping("/add")
    public String add() {
        return PREFIX + "/mobile_add.html";
    }

    /**
     * 编辑页面
     *
     * @author yqy
     * @Date 2019-10-31
     */
    @RequestMapping("/edit")
    public String edit() {
        return PREFIX + "/mobile_edit.html";
    }

    /**
     * 新增接口
     *
     * @author yqy
     * @Date 2019-10-31
     */
    @RequestMapping("/addItem")
    @ResponseBody
    public ResponseData addItem(MobileParam mobileParam) {
        this.mobileService.add(mobileParam);
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
    public ResponseData editItem(MobileParam mobileParam) {
        this.mobileService.update(mobileParam);
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
    public ResponseData delete(MobileParam mobileParam) {
        this.mobileService.delete(mobileParam);
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
    public ResponseData detail(MobileParam mobileParam) {
        Mobile detail = this.mobileService.getById(mobileParam.getMobileid());
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
    public LayuiPageInfo list(@RequestParam(required = false) String condition, MobileParam mobileParam) {

//        //获取分页参数
//        Page page = LayuiPageFactory.defaultPage();
//
//        //根据条件查询日志
//        List<Map<String, Object>> result = mobileService.getMobileByPage(page,condition);
//        page.setRecords(new MobileWrapper(result).wrap());
//
//        return LayuiPageFactory.createPageInfo(page);
        mobileParam.setMobile(condition);

        return this.mobileService.findPageBySpec(mobileParam);

    }

}


