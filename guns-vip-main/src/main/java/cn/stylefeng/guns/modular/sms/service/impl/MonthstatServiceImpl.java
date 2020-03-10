package cn.stylefeng.guns.modular.sms.service.impl;

import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DateTime;
import cn.stylefeng.guns.base.pojo.page.LayuiPageFactory;
import cn.stylefeng.guns.base.pojo.page.LayuiPageInfo;
import cn.stylefeng.guns.modular.sms.entity.Daystat;
import cn.stylefeng.guns.modular.sms.entity.Monthstat;
import cn.stylefeng.guns.modular.sms.entity.Send;
import cn.stylefeng.guns.modular.sms.mapper.MonthstatMapper;
import cn.stylefeng.guns.modular.sms.model.params.MonthstatParam;
import cn.stylefeng.guns.modular.sms.model.result.MonthstatResult;
import  cn.stylefeng.guns.modular.sms.service.MonthstatService;
import cn.stylefeng.roses.core.util.ToolUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 月统计表 服务实现类
 * </p>
 *
 * @author yqy
 * @since 2019-11-14
 */
@Service
public class MonthstatServiceImpl extends ServiceImpl<MonthstatMapper, Monthstat> implements MonthstatService {

    @Override
    public void add(MonthstatParam param){
        Monthstat entity = getEntity(param);
        this.save(entity);
    }

    @Override
    public void delete(MonthstatParam param){
        this.removeById(getKey(param));
    }

    @Override
    public void update(MonthstatParam param){
        Monthstat oldEntity = getOldEntity(param);
        Monthstat newEntity = getEntity(param);
        ToolUtil.copyProperties(newEntity, oldEntity);
        this.updateById(newEntity);
    }

    @Override
    public MonthstatResult findBySpec(MonthstatParam param){
        return null;
    }

    @Override
    public List<MonthstatResult> findListBySpec(MonthstatParam param){
        return null;
    }

    @Override
    public LayuiPageInfo findPageBySpec(MonthstatParam param){
        Page pageContext = getPageContext();
        IPage page = this.baseMapper.customPageList(pageContext, param);
        return LayuiPageFactory.createPageInfo(page);
    }



    private Serializable getKey(MonthstatParam param){
        return param.getTaskId();
    }

    private Page getPageContext() {
        return LayuiPageFactory.defaultPage();
    }

    private Monthstat getOldEntity(MonthstatParam param) {
        return this.getById(getKey(param));
    }

    private Monthstat getEntity(MonthstatParam param) {
        Monthstat entity = new Monthstat();
        ToolUtil.copyProperties(param, entity);
        return entity;
    }



}
