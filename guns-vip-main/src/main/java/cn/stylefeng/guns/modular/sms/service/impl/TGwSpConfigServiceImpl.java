package cn.stylefeng.guns.modular.sms.service.impl;

import cn.stylefeng.guns.base.pojo.page.LayuiPageFactory;
import cn.stylefeng.guns.base.pojo.page.LayuiPageInfo;
import cn.stylefeng.guns.modular.sms.entity.TGwSpConfig;
import cn.stylefeng.guns.modular.sms.mapper.TGwSpConfigMapper;
import cn.stylefeng.guns.modular.sms.model.params.TGwSpConfigParam;
import cn.stylefeng.guns.modular.sms.model.result.TGwSpConfigResult;
import  cn.stylefeng.guns.modular.sms.service.TGwSpConfigService;
import cn.stylefeng.roses.core.util.ToolUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 网关配置表 服务实现类
 * </p>
 *
 * @author yqy
 * @since 2019-10-31
 */
@Service
public class TGwSpConfigServiceImpl extends ServiceImpl<TGwSpConfigMapper, TGwSpConfig> implements TGwSpConfigService {

    @Override
    public void add(TGwSpConfigParam param){
        TGwSpConfig entity = getEntity(param);
        this.save(entity);
    }

    @Override
    public void delete(TGwSpConfigParam param){
        this.removeById(getKey(param));
    }

    @Override
    public void update(TGwSpConfigParam param){
        TGwSpConfig oldEntity = getOldEntity(param);
        TGwSpConfig newEntity = getEntity(param);
        ToolUtil.copyProperties(newEntity, oldEntity);
        this.updateById(newEntity);
    }

    @Override
    public TGwSpConfigResult findBySpec(TGwSpConfigParam param){
        return null;
    }

    @Override
    public List<TGwSpConfigResult> findListBySpec(TGwSpConfigParam param){
        return null;
    }

    @Override
    public LayuiPageInfo findPageBySpec(TGwSpConfigParam param){
        Page pageContext = getPageContext();
        IPage page = this.baseMapper.customPageList(pageContext, param);
        return LayuiPageFactory.createPageInfo(page);
    }

    private Serializable getKey(TGwSpConfigParam param){
        return param.getSpnumId();
    }

    private Page getPageContext() {
        return LayuiPageFactory.defaultPage();
    }

    private TGwSpConfig getOldEntity(TGwSpConfigParam param) {
        return this.getById(getKey(param));
    }

    private TGwSpConfig getEntity(TGwSpConfigParam param) {
        TGwSpConfig entity = new TGwSpConfig();
        ToolUtil.copyProperties(param, entity);
        return entity;
    }
    public Page<Map<String, Object>> list(String condition) {
        Page page = LayuiPageFactory.defaultPage();
        return this.baseMapper.list(page, condition);
    }
}
