package cn.stylefeng.guns.modular.sms.mapper;

import cn.stylefeng.guns.modular.sms.entity.Balance;
import cn.stylefeng.guns.modular.sms.model.params.BalanceParam;
import cn.stylefeng.guns.modular.sms.model.result.BalanceResult;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 余额变更表 Mapper 接口
 * </p>
 *
 * @author yqy
 * @since 2019-12-10
 */
public interface BalanceMapper extends BaseMapper<Balance> {

    /**
     * 获取列表
     *
     * @author yqy
     * @Date 2019-12-10
     */
    List<BalanceResult> customList(@Param("paramCondition") BalanceParam paramCondition);

    /**
     * 获取map列表
     *
     * @author yqy
     * @Date 2019-12-10
     */
    List<Map<String, Object>> customMapList(@Param("paramCondition") BalanceParam paramCondition);

    /**
     * 获取分页实体列表
     *
     * @author yqy
     * @Date 2019-12-10
     */
    Page<BalanceResult> customPageList(@Param("page") Page page, @Param("paramCondition") BalanceParam paramCondition);

    /**
     * 获取分页map列表
     *
     * @author yqy
     * @Date 2019-12-10
     */
    Page<Map<String, Object>> customPageMapList(@Param("page") Page page, @Param("paramCondition") BalanceParam paramCondition);

}
