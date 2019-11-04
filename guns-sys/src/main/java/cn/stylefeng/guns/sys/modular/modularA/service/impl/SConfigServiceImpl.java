package cn.stylefeng.guns.sys.modular.modularA.service.impl;

import cn.stylefeng.guns.base.pojo.page.LayuiPageFactory;
import cn.stylefeng.guns.base.pojo.page.LayuiPageInfo;
import cn.stylefeng.guns.sys.modular.modularA.entity.SConfig;
import cn.stylefeng.guns.sys.modular.modularA.mapper.SConfigMapper;
import cn.stylefeng.guns.sys.modular.modularA.model.params.SConfigParam;
import cn.stylefeng.guns.sys.modular.modularA.model.result.SConfigResult;
import  cn.stylefeng.guns.sys.modular.modularA.service.SConfigService;
import cn.stylefeng.roses.core.util.ToolUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 参数配置 服务实现类
 * </p>
 *
 * @author yqy
 * @since 2019-10-31
 */
@Service
public class SConfigServiceImpl extends ServiceImpl<SConfigMapper, SConfig> implements SConfigService {

    @Override
    public void add(SConfigParam param){
        SConfig entity = getEntity(param);
        this.save(entity);
    }

    @Override
    public void delete(SConfigParam param){
        this.removeById(getKey(param));
    }

    @Override
    public void update(SConfigParam param){
        SConfig oldEntity = getOldEntity(param);
        SConfig newEntity = getEntity(param);
        ToolUtil.copyProperties(newEntity, oldEntity);
        this.updateById(newEntity);
    }

    @Override
    public SConfigResult findBySpec(SConfigParam param){
        return null;
    }

    @Override
    public List<SConfigResult> findListBySpec(SConfigParam param){
        return null;
    }

    @Override
    public LayuiPageInfo findPageBySpec(SConfigParam param){
        Page pageContext = getPageContext();
        IPage page = this.baseMapper.customPageList(pageContext, param);
        return LayuiPageFactory.createPageInfo(page);
    }

    private Serializable getKey(SConfigParam param){
        return param.getId();
    }

    private Page getPageContext() {
        return LayuiPageFactory.defaultPage();
    }

    private SConfig getOldEntity(SConfigParam param) {
        return this.getById(getKey(param));
    }

    private SConfig getEntity(SConfigParam param) {
        SConfig entity = new SConfig();
        ToolUtil.copyProperties(param, entity);
        return entity;
    }

}
