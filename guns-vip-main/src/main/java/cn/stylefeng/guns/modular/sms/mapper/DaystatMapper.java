package cn.stylefeng.guns.modular.sms.mapper;

import cn.stylefeng.guns.modular.sms.entity.Daystat;
import cn.stylefeng.guns.modular.sms.model.params.DaystatParam;
import cn.stylefeng.guns.modular.sms.model.result.DaystatResult;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 日统计表 Mapper 接口
 * </p>
 *
 * @author yqy
 * @since 2019-11-14
 */
public interface DaystatMapper extends BaseMapper<Daystat> {

    /**
     * 获取列表
     *
     * @author yqy
     * @Date 2019-11-14
     */
    List<DaystatResult> customList(@Param("paramCondition") DaystatParam paramCondition);

    /**
     * 获取map列表
     *
     * @author yqy
     * @Date 2019-11-14
     */
    List<Map<String, Object>> customMapList(@Param("paramCondition") DaystatParam paramCondition);

    /**
     * 获取分页实体列表
     *
     * @author yqy
     * @Date 2019-11-14
     */
    Page<DaystatResult> customPageList(@Param("page") Page page, @Param("paramCondition") DaystatParam paramCondition);

    /**
     * 获取分页map列表
     *
     * @author yqy
     * @Date 2019-11-14
     */
    Page<Map<String, Object>> customPageMapList(@Param("page") Page page, @Param("paramCondition") DaystatParam paramCondition);

}
