package cn.stylefeng.guns.modular.sms.mapper;

import cn.stylefeng.guns.modular.sms.entity.Monthstat;
import cn.stylefeng.guns.modular.sms.model.params.MonthstatParam;
import cn.stylefeng.guns.modular.sms.model.result.MonthstatResult;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 月统计表 Mapper 接口
 * </p>
 *
 * @author yqy
 * @since 2019-11-14
 */
public interface MonthstatMapper extends BaseMapper<Monthstat> {

    /**
     * 获取列表
     *
     * @author yqy
     * @Date 2019-11-14
     */
    List<MonthstatResult> customList(@Param("paramCondition") MonthstatParam paramCondition);

    /**
     * 获取map列表
     *
     * @author yqy
     * @Date 2019-11-14
     */
    List<Map<String, Object>> customMapList(@Param("paramCondition") MonthstatParam paramCondition);

    /**
     * 获取分页实体列表
     *
     * @author yqy
     * @Date 2019-11-14
     */
    Page<MonthstatResult> customPageList(@Param("page") Page page, @Param("paramCondition") MonthstatParam paramCondition);

    /**
     * 获取分页map列表
     *
     * @author yqy
     * @Date 2019-11-14
     */
    Page<Map<String, Object>> customPageMapList(@Param("page") Page page, @Param("paramCondition") MonthstatParam paramCondition);

}
