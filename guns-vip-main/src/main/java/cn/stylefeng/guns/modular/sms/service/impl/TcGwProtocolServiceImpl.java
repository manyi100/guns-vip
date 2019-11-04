package cn.stylefeng.guns.modular.sms.service.impl;

import cn.stylefeng.guns.base.pojo.page.LayuiPageFactory;
import cn.stylefeng.guns.base.pojo.page.LayuiPageInfo;
import cn.stylefeng.guns.modular.sms.entity.TcGwProtocol;
import cn.stylefeng.guns.modular.sms.mapper.TcGwProtocolMapper;
import cn.stylefeng.guns.modular.sms.model.params.TcGwProtocolParam;
import cn.stylefeng.guns.modular.sms.model.result.TcGwProtocolResult;
import  cn.stylefeng.guns.modular.sms.service.TcGwProtocolService;
import cn.stylefeng.roses.core.util.ToolUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 短信协议配置表 服务实现类
 * </p>
 *
 * @author yqy
 * @since 2019-10-31
 */
@Service
public class TcGwProtocolServiceImpl extends ServiceImpl<TcGwProtocolMapper, TcGwProtocol> implements TcGwProtocolService {

    @Override
    public void add(TcGwProtocolParam param){
        TcGwProtocol entity = getEntity(param);
        this.save(entity);
    }

    @Override
    public void delete(TcGwProtocolParam param){
        this.removeById(getKey(param));
    }

    @Override
    public void update(TcGwProtocolParam param){
        TcGwProtocol oldEntity = getOldEntity(param);
        TcGwProtocol newEntity = getEntity(param);
        ToolUtil.copyProperties(newEntity, oldEntity);
        this.updateById(newEntity);
    }

    @Override
    public TcGwProtocolResult findBySpec(TcGwProtocolParam param){
        return null;
    }

    @Override
    public List<TcGwProtocolResult> findListBySpec(TcGwProtocolParam param){
        return null;
    }

    @Override
    public LayuiPageInfo findPageBySpec(TcGwProtocolParam param){
        Page pageContext = getPageContext();
        IPage page = this.baseMapper.customPageList(pageContext, param);
        return LayuiPageFactory.createPageInfo(page);
    }

    private Serializable getKey(TcGwProtocolParam param){
        return param.getProtocolid();
    }

    private Page getPageContext() {
        return LayuiPageFactory.defaultPage();
    }

    private TcGwProtocol getOldEntity(TcGwProtocolParam param) {
        return this.getById(getKey(param));
    }

    private TcGwProtocol getEntity(TcGwProtocolParam param) {
        TcGwProtocol entity = new TcGwProtocol();
        ToolUtil.copyProperties(param, entity);
        return entity;
    }

}
