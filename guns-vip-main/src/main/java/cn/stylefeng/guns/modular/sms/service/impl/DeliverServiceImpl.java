package cn.stylefeng.guns.modular.sms.service.impl;

import cn.stylefeng.guns.base.pojo.page.LayuiPageFactory;
import cn.stylefeng.guns.base.pojo.page.LayuiPageInfo;
import cn.stylefeng.guns.modular.sms.entity.Deliver;
import cn.stylefeng.guns.modular.sms.mapper.DeliverMapper;
import cn.stylefeng.guns.modular.sms.model.params.DeliverParam;
import cn.stylefeng.guns.modular.sms.model.result.DeliverResult;
import  cn.stylefeng.guns.modular.sms.service.DeliverService;
import cn.stylefeng.roses.core.util.ToolUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 短信接收表 服务实现类
 * </p>
 *
 * @author yqy
 * @since 2019-10-31
 */
@Service
public class DeliverServiceImpl extends ServiceImpl<DeliverMapper, Deliver> implements DeliverService {

    @Override
    public void add(DeliverParam param){
        Deliver entity = getEntity(param);
        this.save(entity);
    }

    @Override
    public void delete(DeliverParam param){
        this.removeById(getKey(param));
    }

    @Override
    public void update(DeliverParam param){
        Deliver oldEntity = getOldEntity(param);
        Deliver newEntity = getEntity(param);
        ToolUtil.copyProperties(newEntity, oldEntity);
        this.updateById(newEntity);
    }

    @Override
    public DeliverResult findBySpec(DeliverParam param){
        return null;
    }

    @Override
    public List<DeliverResult> findListBySpec(DeliverParam param){
        return null;
    }

    @Override
    public LayuiPageInfo findPageBySpec(DeliverParam param){
        Page pageContext = getPageContext();
        IPage page = this.baseMapper.customPageList(pageContext, param);
        return LayuiPageFactory.createPageInfo(page);
    }

    private Serializable getKey(DeliverParam param){
        return param.getDeliverId();
    }

    private Page getPageContext() {
        return LayuiPageFactory.defaultPage();
    }

    private Deliver getOldEntity(DeliverParam param) {
        return this.getById(getKey(param));
    }

    private Deliver getEntity(DeliverParam param) {
        Deliver entity = new Deliver();
        ToolUtil.copyProperties(param, entity);
        return entity;
    }

}
