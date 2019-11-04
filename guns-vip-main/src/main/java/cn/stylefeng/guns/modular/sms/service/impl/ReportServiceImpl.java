package cn.stylefeng.guns.modular.sms.service.impl;

import cn.stylefeng.guns.base.pojo.page.LayuiPageFactory;
import cn.stylefeng.guns.base.pojo.page.LayuiPageInfo;
import cn.stylefeng.guns.modular.sms.entity.Report;
import cn.stylefeng.guns.modular.sms.mapper.ReportMapper;
import cn.stylefeng.guns.modular.sms.model.params.ReportParam;
import cn.stylefeng.guns.modular.sms.model.result.ReportResult;
import  cn.stylefeng.guns.modular.sms.service.ReportService;
import cn.stylefeng.roses.core.util.ToolUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 回执表 服务实现类
 * </p>
 *
 * @author yqy
 * @since 2019-10-31
 */
@Service
public class ReportServiceImpl extends ServiceImpl<ReportMapper, Report> implements ReportService {

    @Override
    public void add(ReportParam param){
        Report entity = getEntity(param);
        this.save(entity);
    }

    @Override
    public void delete(ReportParam param){
        this.removeById(getKey(param));
    }

    @Override
    public void update(ReportParam param){
        Report oldEntity = getOldEntity(param);
        Report newEntity = getEntity(param);
        ToolUtil.copyProperties(newEntity, oldEntity);
        this.updateById(newEntity);
    }

    @Override
    public ReportResult findBySpec(ReportParam param){
        return null;
    }

    @Override
    public List<ReportResult> findListBySpec(ReportParam param){
        return null;
    }

    @Override
    public LayuiPageInfo findPageBySpec(ReportParam param){
        Page pageContext = getPageContext();
        IPage page = this.baseMapper.customPageList(pageContext, param);
        return LayuiPageFactory.createPageInfo(page);
    }

    private Serializable getKey(ReportParam param){
        return param.getReportId();
    }

    private Page getPageContext() {
        return LayuiPageFactory.defaultPage();
    }

    private Report getOldEntity(ReportParam param) {
        return this.getById(getKey(param));
    }

    private Report getEntity(ReportParam param) {
        Report entity = new Report();
        ToolUtil.copyProperties(param, entity);
        return entity;
    }

}
