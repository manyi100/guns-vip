package cn.stylefeng.guns.modular.sms.mapper;

import cn.stylefeng.guns.modular.sms.entity.Deliver;
import cn.stylefeng.guns.modular.sms.model.params.DeliverParam;
import cn.stylefeng.guns.modular.sms.model.result.DeliverResult;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 短信接收表 Mapper 接口
 * </p>
 *
 * @author yqy
 * @since 2019-10-31
 */
public interface DeliverMapper extends BaseMapper<Deliver> {

    /**
     * 获取列表
     *
     * @author yqy
     * @Date 2019-10-31
     */
    List<DeliverResult> customList(@Param("paramCondition") DeliverParam paramCondition);

    /**
     * 获取map列表
     *
     * @author yqy
     * @Date 2019-10-31
     */
    List<Map<String, Object>> customMapList(@Param("paramCondition") DeliverParam paramCondition);

    /**
     * 获取分页实体列表
     *
     * @author yqy
     * @Date 2019-10-31
     */
    Page<DeliverResult> customPageList(@Param("page") Page page, @Param("paramCondition") DeliverParam paramCondition);

    /**
     * 获取分页map列表
     *
     * @author yqy
     * @Date 2019-10-31
     */
    Page<Map<String, Object>> customPageMapList(@Param("page") Page page, @Param("paramCondition") DeliverParam paramCondition);

}
