package cn.stylefeng.guns.modular.sms.service.impl;

import cn.stylefeng.guns.base.pojo.page.LayuiPageFactory;
import cn.stylefeng.guns.base.pojo.page.LayuiPageInfo;
import cn.stylefeng.guns.modular.sms.entity.Contacts;
import cn.stylefeng.guns.modular.sms.mapper.ContactsMapper;
import cn.stylefeng.guns.modular.sms.model.params.ContactsParam;
import cn.stylefeng.guns.modular.sms.model.result.ContactsResult;
import  cn.stylefeng.guns.modular.sms.service.ContactsService;
import cn.stylefeng.roses.core.util.ToolUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 联系人 服务实现类
 * </p>
 *
 * @author yqy
 * @since 2019-12-10
 */
@Service
public class ContactsServiceImpl extends ServiceImpl<ContactsMapper, Contacts> implements ContactsService {

    @Override
    public void add(ContactsParam param){
        Contacts entity = getEntity(param);
        this.save(entity);
    }

    @Override
    public void delete(ContactsParam param){
        this.removeById(getKey(param));
    }

    @Override
    public void update(ContactsParam param){
        Contacts oldEntity = getOldEntity(param);
        Contacts newEntity = getEntity(param);
        ToolUtil.copyProperties(newEntity, oldEntity);
        this.updateById(newEntity);
    }

    @Override
    public ContactsResult findBySpec(ContactsParam param){
        return null;
    }

    @Override
    public List<ContactsResult> findListBySpec(ContactsParam param){
        return null;
    }

    @Override
    public LayuiPageInfo findPageBySpec(ContactsParam param){
        Page pageContext = getPageContext();
        IPage page = this.baseMapper.customPageList(pageContext, param);
        return LayuiPageFactory.createPageInfo(page);
    }

    private Serializable getKey(ContactsParam param){
        return param.getContactsid();
    }

    private Page getPageContext() {
        return LayuiPageFactory.defaultPage();
    }

    private Contacts getOldEntity(ContactsParam param) {
        return this.getById(getKey(param));
    }

    private Contacts getEntity(ContactsParam param) {
        Contacts entity = new Contacts();
        ToolUtil.copyProperties(param, entity);
        return entity;
    }

}
