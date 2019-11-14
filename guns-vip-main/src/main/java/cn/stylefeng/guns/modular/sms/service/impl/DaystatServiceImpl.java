package cn.stylefeng.guns.modular.sms.service.impl;

import cn.stylefeng.guns.base.pojo.page.LayuiPageFactory;
import cn.stylefeng.guns.base.pojo.page.LayuiPageInfo;
import cn.stylefeng.guns.modular.sms.entity.Daystat;
import cn.stylefeng.guns.modular.sms.mapper.DaystatMapper;
import cn.stylefeng.guns.modular.sms.model.params.DaystatParam;
import cn.stylefeng.guns.modular.sms.model.result.DaystatResult;
import  cn.stylefeng.guns.modular.sms.service.DaystatService;
import cn.stylefeng.roses.core.util.ToolUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 日统计表 服务实现类
 * </p>
 *
 * @author yqy
 * @since 2019-11-14
 */
@Service
public class DaystatServiceImpl extends ServiceImpl<DaystatMapper, Daystat> implements DaystatService {

    @Override
    public void add(DaystatParam param){
        Daystat entity = getEntity(param);
        this.save(entity);
    }

    @Override
    public void delete(DaystatParam param){
        this.removeById(getKey(param));
    }

    @Override
    public void update(DaystatParam param){
        Daystat oldEntity = getOldEntity(param);
        Daystat newEntity = getEntity(param);
        ToolUtil.copyProperties(newEntity, oldEntity);
        this.updateById(newEntity);
    }

    @Override
    public DaystatResult findBySpec(DaystatParam param){
        return null;
    }

    @Override
    public List<DaystatResult> findListBySpec(DaystatParam param){
        return null;
    }

    @Override
    public LayuiPageInfo findPageBySpec(DaystatParam param){
        Page pageContext = getPageContext();
        IPage page = this.baseMapper.customPageList(pageContext, param);
        return LayuiPageFactory.createPageInfo(page);
    }

    private Serializable getKey(DaystatParam param){
        return param.getTaskId();
    }

    private Page getPageContext() {
        return LayuiPageFactory.defaultPage();
    }

    private Daystat getOldEntity(DaystatParam param) {
        return this.getById(getKey(param));
    }

    private Daystat getEntity(DaystatParam param) {
        Daystat entity = new Daystat();
        ToolUtil.copyProperties(param, entity);
        return entity;
    }

}
