package cn.stylefeng.guns.modular.sms.service.impl;

import cn.stylefeng.guns.base.pojo.page.LayuiPageFactory;
import cn.stylefeng.guns.base.pojo.page.LayuiPageInfo;
import cn.stylefeng.guns.modular.sms.entity.Signname;
import cn.stylefeng.guns.modular.sms.mapper.SignnameMapper;
import cn.stylefeng.guns.modular.sms.model.params.SignnameParam;
import cn.stylefeng.guns.modular.sms.model.result.SignnameResult;
import  cn.stylefeng.guns.modular.sms.service.SignnameService;
import cn.stylefeng.roses.core.util.ToolUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 签名配置表 服务实现类
 * </p>
 *
 * @author yqy
 * @since 2019-10-31
 */
@Service
public class SignnameServiceImpl extends ServiceImpl<SignnameMapper, Signname> implements SignnameService {

    @Override
    public void add(SignnameParam param){
        Signname entity = getEntity(param);
        this.save(entity);
    }

    @Override
    public void delete(SignnameParam param){
        this.removeById(getKey(param));
    }

    @Override
    public void update(SignnameParam param){
        Signname oldEntity = getOldEntity(param);
        Signname newEntity = getEntity(param);
        ToolUtil.copyProperties(newEntity, oldEntity);
        this.updateById(newEntity);
    }

    @Override
    public SignnameResult findBySpec(SignnameParam param){
        return null;
    }

    @Override
    public List<SignnameResult> findListBySpec(SignnameParam param){
        return null;
    }

    @Override
    public LayuiPageInfo findPageBySpec(SignnameParam param){
        Page pageContext = getPageContext();
        IPage page = this.baseMapper.customPageList(pageContext, param);
        return LayuiPageFactory.createPageInfo(page);
    }

    private Serializable getKey(SignnameParam param){
        return param.getSignid();
    }

    private Page getPageContext() {
        return LayuiPageFactory.defaultPage();
    }

    private Signname getOldEntity(SignnameParam param) {
        return this.getById(getKey(param));
    }

    private Signname getEntity(SignnameParam param) {
        Signname entity = new Signname();
        ToolUtil.copyProperties(param, entity);
        return entity;
    }

}
