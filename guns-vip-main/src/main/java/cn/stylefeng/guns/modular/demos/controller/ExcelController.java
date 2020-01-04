package cn.stylefeng.guns.modular.demos.controller;

import cn.afterturn.easypoi.entity.vo.MapExcelConstants;
import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
import cn.afterturn.easypoi.excel.entity.params.ExcelExportEntity;
import cn.afterturn.easypoi.view.PoiBaseView;
import cn.stylefeng.guns.base.pojo.page.LayuiPageInfo;
import cn.stylefeng.guns.modular.demos.entity.BlockItem;
import cn.stylefeng.guns.modular.demos.entity.ExcelItem;
import cn.stylefeng.guns.modular.sms.entity.Block;
import cn.stylefeng.guns.modular.sms.entity.Contacts;
import cn.stylefeng.guns.modular.sms.model.params.ContactsParam;
import cn.stylefeng.guns.modular.sms.service.BlockService;
import cn.stylefeng.guns.modular.sms.service.ContactsService;
import cn.stylefeng.guns.sys.core.exception.enums.BizExceptionEnum;
import cn.stylefeng.guns.sys.core.properties.GunsProperties;
import cn.stylefeng.guns.sys.core.shiro.ShiroKit;
import cn.stylefeng.guns.sys.modular.system.service.UserService;
import cn.stylefeng.roses.core.reqres.response.ResponseData;
import cn.stylefeng.roses.kernel.model.exception.ServiceException;
import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * excel导入导出示例
 *
 * @author fengshuonan
 * @Date 2019/3/9 11:03
 */
@Controller
@RequestMapping("/excel")
public class ExcelController {

    @Autowired
    private UserService userService;

    @Autowired
    private GunsProperties gunsProperties;

    @Autowired
    private BlockService blockService;
    @Autowired
    private ContactsService contactsService;
    /**
     * excel导入页面
     *
     * @author fengshuonan
     * @Date 2019/3/9 11:03
     */
    @RequestMapping("/import")
    public String importIndex() {
        return "/demos/excel_import.html";
    }

    /**
     * 上传excel填报
     */
    @RequestMapping("/uploadExcel")
    @ResponseBody
    public ResponseData uploadExcel(@RequestPart("file") MultipartFile file, HttpServletRequest request) {
        String name = file.getOriginalFilename();
        request.getSession().setAttribute("upFile", name);
        String fileSavePath = gunsProperties.getFileUploadPath();
        try {
            file.transferTo(new File(fileSavePath + name));
        } catch (Exception e) {
            throw new ServiceException(BizExceptionEnum.UPLOAD_ERROR);
        }

        HashMap<String, Object> map = new HashMap<>();
        map.put("fileId", IdWorker.getIdStr());
        return ResponseData.success(0, "上传成功", map);
    }

    /**
     * 获取上传成功的数据
     */
    @RequestMapping("/getUploadData")
    @ResponseBody
    public Object getUploadData(HttpServletRequest request) {
        String name = (String) request.getSession().getAttribute("upFile");
        String fileSavePath = gunsProperties.getFileUploadPath();
        if (name != null) {
            File file = new File(fileSavePath + name);
            try {
                ImportParams params = new ImportParams();
                params.setTitleRows(1);
                params.setHeadRows(1);
                List result = ExcelImportUtil.importExcel(file, ExcelItem.class, params);

                LayuiPageInfo returns = new LayuiPageInfo();
                returns.setCount(result.size());
                returns.setData(result);
                return returns;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /**
     * excel导出
     *
     * @author fengshuonan
     * @Date 2019/3/9 11:03
     */
    @RequestMapping("/export")
    public void export(ModelMap modelMap, HttpServletRequest request,
                       HttpServletResponse response) {

        //初始化表头
        List<ExcelExportEntity> entity = new ArrayList<>();
        entity.add(new ExcelExportEntity("用户id", "user_id"));
        entity.add(new ExcelExportEntity("头像", "avatar"));
        entity.add(new ExcelExportEntity("账号", "account"));
        entity.add(new ExcelExportEntity("姓名", "name"));
        entity.add(new ExcelExportEntity("生日", "birthday"));
        entity.add(new ExcelExportEntity("性别", "sex"));
        entity.add(new ExcelExportEntity("邮箱", "email"));
        entity.add(new ExcelExportEntity("电话", "phone"));
        entity.add(new ExcelExportEntity("角色id", "role_id"));
        entity.add(new ExcelExportEntity("部门id", "dept_id"));
        entity.add(new ExcelExportEntity("状态", "status"));
        entity.add(new ExcelExportEntity("创建时间", "create_time"));

        //初始化化数据
        List<Map<String, Object>> maps = userService.listMaps();
        ArrayList<Map<String, Object>> total = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            total.addAll(maps);
        }

        ExportParams params = new ExportParams("Guns管理系统所有用户", "用户表", ExcelType.XSSF);
        modelMap.put(MapExcelConstants.MAP_LIST, total);
        modelMap.put(MapExcelConstants.ENTITY_LIST, entity);
        modelMap.put(MapExcelConstants.PARAMS, params);
        modelMap.put(MapExcelConstants.FILE_NAME, "Guns管理系统所有用户");
        PoiBaseView.render(modelMap, request, response, MapExcelConstants.EASYPOI_MAP_EXCEL_VIEW);
    }

    /**
     * 上传黑名单--获取上传成功的数据
     */
    @RequestMapping("/getUploadBlockData")
    @Transactional(rollbackFor = Exception.class, timeout = 600)
    @ResponseBody
    public Object getUploadBlockData(HttpServletRequest request) {
      return  this.getupolad(request, BlockItem.class);
    }
    private Object getupolad(HttpServletRequest request,Class<?> pojoClass)
    {
        String name = (String) request.getSession().getAttribute("upFile");
        String fileSavePath = gunsProperties.getFileUploadPath();
        if (name != null) {
            File file = new File(fileSavePath + name);
            try {
                ImportParams params = new ImportParams();
//                params.setTitleRows(1);
                params.setHeadRows(1);
                List<BlockItem> result = ExcelImportUtil.importExcel(file, pojoClass, params);
                Block block=null;
                List<Block> blocks=new ArrayList<>();
                for (BlockItem blockItem : result) {
                    block=new Block();
                    block.setBlockmobile(blockItem.getBlockmobile());
                    block.setBlocktype(blockItem.getBlocktype());
                    block.setEntid(blockItem.getEntid());
//                    blocks.add(block);
                    blockService.save(block);
                }
//                boolean flag= blockService.saveBatch(blocks);
//                return flag==true ? ResponseData.success(0, "上传成功",null):ResponseData.error(0, "上传失败");
                LayuiPageInfo returns = new LayuiPageInfo();
                returns.setCount(result.size());
                returns.setData(result);
                return returns;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /**
     * 上传黑名单--获取上传成功的数据
     */
    @RequestMapping("/getUploadContactsData")
    @Transactional(rollbackFor = Exception.class, timeout = 600)
    @ResponseBody
    public Object getUploadContactsData(HttpServletRequest request) {
        return  this.getContactsupolad(request, Contacts.class);
    }
    private Object getContactsupolad(HttpServletRequest request,Class<?> pojoClass)
    {
        String name = (String) request.getSession().getAttribute("upFile");
        String fileSavePath = gunsProperties.getFileUploadPath();
        if (name != null) {
            File file = new File(fileSavePath + name);
            try {
                ImportParams params = new ImportParams();
//                params.setTitleRows(1);
                params.setHeadRows(1);
                List<Contacts> result = ExcelImportUtil.importExcel(file, pojoClass, params);
                ContactsParam cp=null;
                Long deptId = ShiroKit.getUser().getDeptId();
                for (Contacts contact : result) {
                    cp=new ContactsParam();
                    cp.setMobile(contact.getMobile());
                    cp.setEntid(deptId);
                    cp.setContactsid(1L);
                    contactsService.add(cp);
                }
//                boolean flag= blockService.saveBatch(blocks);
//                return flag==true ? ResponseData.success(0, "上传成功",null):ResponseData.error(0, "上传失败");
                LayuiPageInfo returns = new LayuiPageInfo();
                returns.setCount(result.size());
                returns.setData(result);
                return returns;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
