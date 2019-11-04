package cn.stylefeng.guns.modular.sms.service.impl;

import cn.stylefeng.guns.base.pojo.page.LayuiPageFactory;
import cn.stylefeng.guns.base.pojo.page.LayuiPageInfo;
import cn.stylefeng.guns.modular.sms.entity.Recharge;
import cn.stylefeng.guns.modular.sms.mapper.RechargeMapper;
import cn.stylefeng.guns.modular.sms.model.params.RechargeParam;
import cn.stylefeng.guns.modular.sms.model.result.RechargeResult;
import  cn.stylefeng.guns.modular.sms.service.RechargeService;
import cn.stylefeng.roses.core.util.ToolUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 充值记录表 服务实现类
 * </p>
 *
 * @author yqy
 * @since 2019-10-31
 */
@Service
public class RechargeServiceImpl extends ServiceImpl<RechargeMapper, Recharge> implements RechargeService {

    @Override
    public void add(RechargeParam param){
        Recharge entity = getEntity(param);
        this.save(entity);
    }

    @Override
    public void delete(RechargeParam param){
        this.removeById(getKey(param));
    }

    @Override
    public void update(RechargeParam param){
        Recharge oldEntity = getOldEntity(param);
        Recharge newEntity = getEntity(param);
        ToolUtil.copyProperties(newEntity, oldEntity);
        this.updateById(newEntity);
    }

    @Override
    public RechargeResult findBySpec(RechargeParam param){
        return null;
    }

    @Override
    public List<RechargeResult> findListBySpec(RechargeParam param){
        return null;
    }

    @Override
    public LayuiPageInfo findPageBySpec(RechargeParam param){
        Page pageContext = getPageContext();
        IPage page = this.baseMapper.customPageList(pageContext, param);
        return LayuiPageFactory.createPageInfo(page);
    }

    private Serializable getKey(RechargeParam param){
        return param.getRechargeid();
    }

    private Page getPageContext() {
        return LayuiPageFactory.defaultPage();
    }

    private Recharge getOldEntity(RechargeParam param) {
        return this.getById(getKey(param));
    }

    private Recharge getEntity(RechargeParam param) {
        Recharge entity = new Recharge();
        ToolUtil.copyProperties(param, entity);
        return entity;
    }

}
