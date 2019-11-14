package cn.stylefeng.guns.modular.sms.service;

import cn.stylefeng.guns.base.pojo.page.LayuiPageInfo;
import cn.stylefeng.guns.modular.sms.entity.Monthstat;
import cn.stylefeng.guns.modular.sms.model.params.MonthstatParam;
import cn.stylefeng.guns.modular.sms.model.result.MonthstatResult;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 月统计表 服务类
 * </p>
 *
 * @author yqy
 * @since 2019-11-14
 */
public interface MonthstatService extends IService<Monthstat> {

    /**
     * 新增
     *
     * @author yqy
     * @Date 2019-11-14
     */
    void add(MonthstatParam param);

    /**
     * 删除
     *
     * @author yqy
     * @Date 2019-11-14
     */
    void delete(MonthstatParam param);

    /**
     * 更新
     *
     * @author yqy
     * @Date 2019-11-14
     */
    void update(MonthstatParam param);

    /**
     * 查询单条数据，Specification模式
     *
     * @author yqy
     * @Date 2019-11-14
     */
    MonthstatResult findBySpec(MonthstatParam param);

    /**
     * 查询列表，Specification模式
     *
     * @author yqy
     * @Date 2019-11-14
     */
    List<MonthstatResult> findListBySpec(MonthstatParam param);

    /**
     * 查询分页数据，Specification模式
     *
     * @author yqy
     * @Date 2019-11-14
     */
     LayuiPageInfo findPageBySpec(MonthstatParam param);

}
