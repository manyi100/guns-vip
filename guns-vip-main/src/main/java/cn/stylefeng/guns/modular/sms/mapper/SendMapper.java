package cn.stylefeng.guns.modular.sms.mapper;

import cn.stylefeng.guns.modular.sms.entity.Send;
import cn.stylefeng.guns.modular.sms.model.params.SendParam;
import cn.stylefeng.guns.modular.sms.model.result.SendResult;
import cn.stylefeng.roses.core.mutidatasource.annotion.DataSource;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 发送表 Mapper 接口
 * </p>
 *
 * @author yqy
 * @since 2019-10-31
 */
public interface SendMapper extends BaseMapper<Send> {

    /**
     * 获取列表
     *
     * @author yqy
     * @Date 2019-10-31
     */
    List<SendResult> customList(@Param("paramCondition") SendParam paramCondition);

    /**
     * 获取map列表
     *
     * @author yqy
     * @Date 2019-10-31
     */
    List<Map<String, Object>> customMapList(@Param("paramCondition") SendParam paramCondition);

    /**
     * 获取分页实体列表
     *
     * @author yqy
     * @Date 2019-10-31
     */
    Page<SendResult> customPageList(@Param("page") Page page, @Param("paramCondition") SendParam paramCondition);

    /**
     * 获取分页map列表
     *
     * @author yqy
     * @Date 2019-10-31
     */
    Page<Map<String, Object>> customPageMapList(@Param("page") Page page, @Param("paramCondition") SendParam paramCondition);


}
