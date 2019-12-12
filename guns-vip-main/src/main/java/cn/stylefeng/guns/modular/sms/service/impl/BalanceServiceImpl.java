package cn.stylefeng.guns.modular.sms.service.impl;

import cn.stylefeng.guns.base.pojo.page.LayuiPageFactory;
import cn.stylefeng.guns.base.pojo.page.LayuiPageInfo;
import cn.stylefeng.guns.modular.sms.entity.Balance;
import cn.stylefeng.guns.modular.sms.mapper.BalanceMapper;
import cn.stylefeng.guns.modular.sms.model.params.BalanceParam;
import cn.stylefeng.guns.modular.sms.model.result.BalanceResult;
import  cn.stylefeng.guns.modular.sms.service.BalanceService;
import cn.stylefeng.roses.core.util.ToolUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 余额变更表 服务实现类
 * </p>
 *
 * @author yqy
 * @since 2019-12-10
 */
@Service
public class BalanceServiceImpl extends ServiceImpl<BalanceMapper, Balance> implements BalanceService {

    @Override
    public void add(BalanceParam param){
        Balance entity = getEntity(param);
        this.save(entity);
    }

    @Override
    public void delete(BalanceParam param){
        this.removeById(getKey(param));
    }

    @Override
    public void update(BalanceParam param){
        Balance oldEntity = getOldEntity(param);
        Balance newEntity = getEntity(param);
        ToolUtil.copyProperties(newEntity, oldEntity);
        this.updateById(newEntity);
    }

    @Override
    public BalanceResult findBySpec(BalanceParam param){
        return null;
    }

    @Override
    public List<BalanceResult> findListBySpec(BalanceParam param){
        return null;
    }

    @Override
    public LayuiPageInfo findPageBySpec(BalanceParam param){
        Page pageContext = getPageContext();
        IPage page = this.baseMapper.customPageList(pageContext, param);
        return LayuiPageFactory.createPageInfo(page);
    }

    private Serializable getKey(BalanceParam param){
        return param.getBalanceid();
    }

    private Page getPageContext() {
        return LayuiPageFactory.defaultPage();
    }

    private Balance getOldEntity(BalanceParam param) {
        return this.getById(getKey(param));
    }

    private Balance getEntity(BalanceParam param) {
        Balance entity = new Balance();
        ToolUtil.copyProperties(param, entity);
        return entity;
    }

}
