package cn.stylefeng.guns.modular.sms.mapper;

import cn.stylefeng.guns.modular.sms.entity.Block;
import cn.stylefeng.guns.modular.sms.model.params.BlockParam;
import cn.stylefeng.guns.modular.sms.model.result.BlockResult;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 黑名单表 Mapper 接口
 * </p>
 *
 * @author yqy
 * @since 2019-10-31
 */
public interface BlockMapper extends BaseMapper<Block> {

    /**
     * 修改用户状态
     */
    int setStatus(@Param("blockid") Long userId, @Param("status") int status);

    /**
     * 获取列表
     *
     * @author yqy
     * @Date 2019-10-31
     */
    List<BlockResult> customList(@Param("paramCondition") BlockParam paramCondition);

    /**
     * 获取map列表
     *
     * @author yqy
     * @Date 2019-10-31
     */
    List<Map<String, Object>> customMapList(@Param("paramCondition") BlockParam paramCondition);

    /**
     * 获取分页实体列表
     *
     * @author yqy
     * @Date 2019-10-31
     */
    Page<BlockResult> customPageList(@Param("page") Page page, @Param("paramCondition") BlockParam paramCondition);

    /**
     * 获取分页map列表
     *
     * @author yqy
     * @Date 2019-10-31
     */
    Page<Map<String, Object>> customPageMapList(@Param("page") Page page, @Param("paramCondition") BlockParam paramCondition);

}
