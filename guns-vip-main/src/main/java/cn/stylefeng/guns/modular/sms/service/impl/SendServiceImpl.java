package cn.stylefeng.guns.modular.sms.service.impl;

import cn.stylefeng.guns.base.pojo.page.LayuiPageFactory;
import cn.stylefeng.guns.base.pojo.page.LayuiPageInfo;
import cn.stylefeng.guns.modular.sms.entity.Send;
import cn.stylefeng.guns.modular.sms.mapper.SendMapper;
import cn.stylefeng.guns.modular.sms.model.params.SendParam;
import cn.stylefeng.guns.modular.sms.model.result.SendResult;
import  cn.stylefeng.guns.modular.sms.service.SendService;
import cn.stylefeng.roses.core.util.ToolUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 发送表 服务实现类
 * </p>
 *
 * @author yqy
 * @since 2019-10-31
 */
@Service
public class SendServiceImpl extends ServiceImpl<SendMapper, Send> implements SendService {

    @Override
    public void add(SendParam param){
        Send entity = getEntity(param);
        this.save(entity);
    }

    @Override
    public void delete(SendParam param){
        this.removeById(getKey(param));
    }

    @Override
    public void update(SendParam param){
        Send oldEntity = getOldEntity(param);
        Send newEntity = getEntity(param);
        ToolUtil.copyProperties(newEntity, oldEntity);
        this.updateById(newEntity);
    }

    @Override
    public SendResult findBySpec(SendParam param){
        return null;
    }

    @Override
    public List<SendResult> findListBySpec(SendParam param){
        return null;
    }

    @Override
    public LayuiPageInfo findPageBySpec(SendParam param){
        Page pageContext = getPageContext();
        IPage page = this.baseMapper.customPageList(pageContext, param);
        return LayuiPageFactory.createPageInfo(page);
    }

    private Serializable getKey(SendParam param){
        return param.getTaskId();
    }

    private Page getPageContext() {
        return LayuiPageFactory.defaultPage();
    }

    private Send getOldEntity(SendParam param) {
        return this.getById(getKey(param));
    }

    private Send getEntity(SendParam param) {
        Send entity = new Send();
        ToolUtil.copyProperties(param, entity);
        return entity;
    }

}
