package cn.stylefeng.guns.modular.sms.service.impl;

import cn.stylefeng.guns.base.pojo.page.LayuiPageFactory;
import cn.stylefeng.guns.base.pojo.page.LayuiPageInfo;
import cn.stylefeng.guns.modular.sms.entity.TcGwSp;
import cn.stylefeng.guns.modular.sms.mapper.TcGwSpMapper;
import cn.stylefeng.guns.modular.sms.model.params.TcGwSpParam;
import cn.stylefeng.guns.modular.sms.model.result.TcGwSpResult;
import  cn.stylefeng.guns.modular.sms.service.TcGwSpService;
import cn.stylefeng.roses.core.util.ToolUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 运营商配置表 服务实现类
 * </p>
 *
 * @author yqy
 * @since 2019-10-31
 */
@Service
public class TcGwSpServiceImpl extends ServiceImpl<TcGwSpMapper, TcGwSp> implements TcGwSpService {

    @Override
    public void add(TcGwSpParam param){
        TcGwSp entity = getEntity(param);
        this.save(entity);
    }

    @Override
    public void delete(TcGwSpParam param){
        this.removeById(getKey(param));
    }

    @Override
    public void update(TcGwSpParam param){
        TcGwSp oldEntity = getOldEntity(param);
        TcGwSp newEntity = getEntity(param);
        ToolUtil.copyProperties(newEntity, oldEntity);
        this.updateById(newEntity);
    }

    @Override
    public TcGwSpResult findBySpec(TcGwSpParam param){
        return null;
    }

    @Override
    public List<TcGwSpResult> findListBySpec(TcGwSpParam param){
        return null;
    }

    @Override
    public LayuiPageInfo findPageBySpec(TcGwSpParam param){
        Page pageContext = getPageContext();
        IPage page = this.baseMapper.customPageList(pageContext, param);
        return LayuiPageFactory.createPageInfo(page);
    }

    private Serializable getKey(TcGwSpParam param){
        return param.getSpid();
    }

    private Page getPageContext() {
        return LayuiPageFactory.defaultPage();
    }

    private TcGwSp getOldEntity(TcGwSpParam param) {
        return this.getById(getKey(param));
    }

    private TcGwSp getEntity(TcGwSpParam param) {
        TcGwSp entity = new TcGwSp();
        ToolUtil.copyProperties(param, entity);
        return entity;
    }

}
