package cn.stylefeng.guns.modular.sms.service;

import cn.stylefeng.guns.base.pojo.page.LayuiPageInfo;
import cn.stylefeng.guns.modular.sms.entity.Daystat;
import cn.stylefeng.guns.modular.sms.model.params.DaystatParam;
import cn.stylefeng.guns.modular.sms.model.result.DaystatResult;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 日统计表 服务类
 * </p>
 *
 * @author yqy
 * @since 2019-11-14
 */
public interface DaystatService extends IService<Daystat> {

    /**
     * 新增
     *
     * @author yqy
     * @Date 2019-11-14
     */
    void add(DaystatParam param);

    /**
     * 删除
     *
     * @author yqy
     * @Date 2019-11-14
     */
    void delete(DaystatParam param);

    /**
     * 更新
     *
     * @author yqy
     * @Date 2019-11-14
     */
    void update(DaystatParam param);

    /**
     * 查询单条数据，Specification模式
     *
     * @author yqy
     * @Date 2019-11-14
     */
    DaystatResult findBySpec(DaystatParam param);

    /**
     * 查询列表，Specification模式
     *
     * @author yqy
     * @Date 2019-11-14
     */
    List<DaystatResult> findListBySpec(DaystatParam param);

    /**
     * 查询分页数据，Specification模式
     *
     * @author yqy
     * @Date 2019-11-14
     */
     LayuiPageInfo findPageBySpec(DaystatParam param);

    int getMonthCount(String userid);

    int getDayCount(String userid);
    List<Map<String, Object>> getThisMonth(String userid);

}
