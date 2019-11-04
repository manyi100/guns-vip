package cn.stylefeng.guns.modular.sms.service.impl;

import cn.stylefeng.guns.base.pojo.page.LayuiPageFactory;
import cn.stylefeng.guns.base.pojo.page.LayuiPageInfo;
import cn.stylefeng.guns.modular.sms.entity.Mobile;
import cn.stylefeng.guns.modular.sms.mapper.MobileMapper;
import cn.stylefeng.guns.modular.sms.model.params.MobileParam;
import cn.stylefeng.guns.modular.sms.model.result.MobileResult;
import  cn.stylefeng.guns.modular.sms.service.MobileService;
import cn.stylefeng.roses.core.util.ToolUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 号段配置表 服务实现类
 * </p>
 *
 * @author yqy
 * @since 2019-10-31
 */
@Service
public class MobileServiceImpl extends ServiceImpl<MobileMapper, Mobile> implements MobileService {

    @Override
    public void add(MobileParam param){
        Mobile entity = getEntity(param);
        this.save(entity);
    }

    @Override
    public void delete(MobileParam param){
        this.removeById(getKey(param));
    }

    @Override
    public void update(MobileParam param){
        Mobile oldEntity = getOldEntity(param);
        Mobile newEntity = getEntity(param);
        ToolUtil.copyProperties(newEntity, oldEntity);
        this.updateById(newEntity);
    }

    @Override
    public MobileResult findBySpec(MobileParam param){
        return null;
    }

    @Override
    public List<MobileResult> findListBySpec(MobileParam param){
        return null;
    }

    @Override
    public LayuiPageInfo findPageBySpec(MobileParam param){
        Page pageContext = getPageContext();
        IPage page = this.baseMapper.customPageList(pageContext, param);
        return LayuiPageFactory.createPageInfo(page);
    }

    private Serializable getKey(MobileParam param){
        return param.getMobileid();
    }

    private Page getPageContext() {
        return LayuiPageFactory.defaultPage();
    }

    private Mobile getOldEntity(MobileParam param) {
        return this.getById(getKey(param));
    }

    private Mobile getEntity(MobileParam param) {
        Mobile entity = new Mobile();
        ToolUtil.copyProperties(param, entity);
        return entity;
    }

}
