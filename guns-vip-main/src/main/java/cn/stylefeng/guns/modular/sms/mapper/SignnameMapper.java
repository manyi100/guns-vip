package cn.stylefeng.guns.modular.sms.mapper;

import cn.stylefeng.guns.modular.sms.entity.Signname;
import cn.stylefeng.guns.modular.sms.model.params.SignnameParam;
import cn.stylefeng.guns.modular.sms.model.result.SignnameResult;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 签名配置表 Mapper 接口
 * </p>
 *
 * @author yqy
 * @since 2019-10-31
 */
public interface SignnameMapper extends BaseMapper<Signname> {

    /**
     * 获取列表
     *
     * @author yqy
     * @Date 2019-10-31
     */
    List<SignnameResult> customList(@Param("paramCondition") SignnameParam paramCondition);

    /**
     * 获取map列表
     *
     * @author yqy
     * @Date 2019-10-31
     */
    List<Map<String, Object>> customMapList(@Param("paramCondition") SignnameParam paramCondition);

    /**
     * 获取分页实体列表
     *
     * @author yqy
     * @Date 2019-10-31
     */
    Page<SignnameResult> customPageList(@Param("page") Page page, @Param("paramCondition") SignnameParam paramCondition);

    /**
     * 获取分页map列表
     *
     * @author yqy
     * @Date 2019-10-31
     */
    Page<Map<String, Object>> customPageMapList(@Param("page") Page page, @Param("paramCondition") SignnameParam paramCondition);

}
