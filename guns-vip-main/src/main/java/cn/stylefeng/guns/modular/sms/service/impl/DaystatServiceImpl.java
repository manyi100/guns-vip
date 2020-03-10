package cn.stylefeng.guns.modular.sms.service.impl;

import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DateTime;
import cn.stylefeng.guns.base.pojo.page.LayuiPageFactory;
import cn.stylefeng.guns.base.pojo.page.LayuiPageInfo;
import cn.stylefeng.guns.modular.sms.entity.Daystat;
import cn.stylefeng.guns.modular.sms.entity.Monthstat;
import cn.stylefeng.guns.modular.sms.entity.Send;
import cn.stylefeng.guns.modular.sms.mapper.DaystatMapper;
import cn.stylefeng.guns.modular.sms.model.params.DaystatParam;
import cn.stylefeng.guns.modular.sms.model.result.DaystatResult;
import  cn.stylefeng.guns.modular.sms.service.DaystatService;
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
 * 日统计表 服务实现类
 * </p>
 *
 * @author yqy
 * @since 2019-11-14
 */
@Service
public class DaystatServiceImpl extends ServiceImpl<DaystatMapper, Daystat> implements DaystatService {

    @Override
    public void add(DaystatParam param){
        Daystat entity = getEntity(param);
        this.save(entity);
    }

    @Override
    public void delete(DaystatParam param){
        this.removeById(getKey(param));
    }

    @Override
    public void update(DaystatParam param){
        Daystat oldEntity = getOldEntity(param);
        Daystat newEntity = getEntity(param);
        ToolUtil.copyProperties(newEntity, oldEntity);
        this.updateById(newEntity);
    }

    @Override
    public DaystatResult findBySpec(DaystatParam param){
        return null;
    }

    @Override
    public List<DaystatResult> findListBySpec(DaystatParam param){
        return null;
    }

    @Override
    public LayuiPageInfo findPageBySpec(DaystatParam param){
        Page pageContext = getPageContext();
        IPage page = this.baseMapper.customPageList(pageContext, param);
        return LayuiPageFactory.createPageInfo(page);
    }

    @Override
    public int getDayCount(String userid) {
        QueryWrapper<Daystat> queryWrapper=new QueryWrapper<>();
        SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
        String dateStr=sdf.format(new Date());
        if(StringUtils.isNotEmpty(userid)) {
            queryWrapper.eq("date_format(statDate,'%Y-%m-%d')", dateStr).eq("entityName", userid);
        }else
        {
            queryWrapper.eq("date_format(statDate,'%Y-%m-%d')", dateStr);
        }
        queryWrapper.select("sum(submitcnt) AS submitcnt");
        queryWrapper.groupBy("date_format(statDate,'%Y-%m-%d')");
        List<Daystat> list = this.list(queryWrapper);
        int sum=0;
        for (Daystat daystat : list) {
            sum+=daystat.getSubmitcnt();
        }
        return sum;
    }

    @Override
    public int getMonthCount(String userid) {
        QueryWrapper<Daystat> queryWrapper=new QueryWrapper<>();
        SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-01");
        String dateStr=sdf.format(new Date());
        if(StringUtils.isNotEmpty(userid)) {
            queryWrapper.ge("statDate",dateStr).eq("entityName",userid);
        }else
        {
            queryWrapper.ge("statDate",dateStr);
        }
        queryWrapper.select("sum(submitcnt) AS submitcnt");
        queryWrapper.groupBy("date_format(statDate,'%Y-%m')");
        List<Daystat> list = this.list(queryWrapper);
        int sum=0;
        for (Daystat daystat : list) {
            sum+=daystat.getSubmitcnt();
        }
        return sum;
    }
    @Override
    public List<Map<String, Object>> getThisMonth(String userid) {
        DateTime now = DateTime.now();
        DateTime startdt=now.offsetNew(DateField.DAY_OF_MONTH,-30);
        QueryWrapper<Daystat> queryWrapper=new QueryWrapper<>();
        queryWrapper.select("date_format(statDate,'%Y-%m-%d') as statDate","sum(submitcnt) as cnt");
        queryWrapper.between("submitDate",startdt.toString("yyyy-MM-dd 00:00:00"),now.toString("yyyy-MM-dd 23:59:59"));
        SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM");
        String dateStr=sdf.format(new Date());
        if(StringUtils.isNotEmpty(userid)) {
            queryWrapper.eq("entityName",userid);
        }
        queryWrapper.groupBy("date_format(statDate,'%Y-%m-%d')");
        queryWrapper.last(" limit 30");
        return this.listMaps(queryWrapper);
    }

    private Serializable getKey(DaystatParam param){
        return param.getTaskId();
    }

    private Page getPageContext() {
        return LayuiPageFactory.defaultPage();
    }

    private Daystat getOldEntity(DaystatParam param) {
        return this.getById(getKey(param));
    }

    private Daystat getEntity(DaystatParam param) {
        Daystat entity = new Daystat();
        ToolUtil.copyProperties(param, entity);
        return entity;
    }


}
