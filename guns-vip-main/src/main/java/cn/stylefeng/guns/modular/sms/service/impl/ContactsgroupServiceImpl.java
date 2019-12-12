package cn.stylefeng.guns.modular.sms.service.impl;

import cn.stylefeng.guns.base.pojo.page.LayuiPageFactory;
import cn.stylefeng.guns.base.pojo.page.LayuiPageInfo;
import cn.stylefeng.guns.modular.sms.entity.Contactsgroup;
import cn.stylefeng.guns.modular.sms.mapper.ContactsgroupMapper;
import cn.stylefeng.guns.modular.sms.model.params.ContactsgroupParam;
import cn.stylefeng.guns.modular.sms.model.result.ContactsgroupResult;
import  cn.stylefeng.guns.modular.sms.service.ContactsgroupService;
import cn.stylefeng.roses.core.util.ToolUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 联系人分组 服务实现类
 * </p>
 *
 * @author yqy
 * @since 2019-12-10
 */
@Service
public class ContactsgroupServiceImpl extends ServiceImpl<ContactsgroupMapper, Contactsgroup> implements ContactsgroupService {

    @Override
    public void add(ContactsgroupParam param){
        Contactsgroup entity = getEntity(param);
        this.save(entity);
    }

    @Override
    public void delete(ContactsgroupParam param){
        this.removeById(getKey(param));
    }

    @Override
    public void update(ContactsgroupParam param){
        Contactsgroup oldEntity = getOldEntity(param);
        Contactsgroup newEntity = getEntity(param);
        ToolUtil.copyProperties(newEntity, oldEntity);
        this.updateById(newEntity);
    }

    @Override
    public ContactsgroupResult findBySpec(ContactsgroupParam param){
        return null;
    }

    @Override
    public List<ContactsgroupResult> findListBySpec(ContactsgroupParam param){
        return null;
    }

    @Override
    public LayuiPageInfo findPageBySpec(ContactsgroupParam param){
        Page pageContext = getPageContext();
        IPage page = this.baseMapper.customPageList(pageContext, param);
        return LayuiPageFactory.createPageInfo(page);
    }

    private Serializable getKey(ContactsgroupParam param){
        return param.getGroupid();
    }

    private Page getPageContext() {
        return LayuiPageFactory.defaultPage();
    }

    private Contactsgroup getOldEntity(ContactsgroupParam param) {
        return this.getById(getKey(param));
    }

    private Contactsgroup getEntity(ContactsgroupParam param) {
        Contactsgroup entity = new Contactsgroup();
        ToolUtil.copyProperties(param, entity);
        return entity;
    }

}
