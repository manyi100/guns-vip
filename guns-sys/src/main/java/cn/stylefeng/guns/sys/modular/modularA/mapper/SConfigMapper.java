package cn.stylefeng.guns.sys.modular.modularA.mapper;

import cn.stylefeng.guns.sys.modular.modularA.entity.SConfig;
import cn.stylefeng.guns.sys.modular.modularA.model.params.SConfigParam;
import cn.stylefeng.guns.sys.modular.modularA.model.result.SConfigResult;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 参数配置 Mapper 接口
 * </p>
 *
 * @author yqy
 * @since 2019-10-31
 */
public interface SConfigMapper extends BaseMapper<SConfig> {

    /**
     * 获取列表
     *
     * @author yqy
     * @Date 2019-10-31
     */
    List<SConfigResult> customList(@Param("paramCondition") SConfigParam paramCondition);

    /**
     * 获取map列表
     *
     * @author yqy
     * @Date 2019-10-31
     */
    List<Map<String, Object>> customMapList(@Param("paramCondition") SConfigParam paramCondition);

    /**
     * 获取分页实体列表
     *
     * @author yqy
     * @Date 2019-10-31
     */
    Page<SConfigResult> customPageList(@Param("page") Page page, @Param("paramCondition") SConfigParam paramCondition);

    /**
     * 获取分页map列表
     *
     * @author yqy
     * @Date 2019-10-31
     */
    Page<Map<String, Object>> customPageMapList(@Param("page") Page page, @Param("paramCondition") SConfigParam paramCondition);

}
