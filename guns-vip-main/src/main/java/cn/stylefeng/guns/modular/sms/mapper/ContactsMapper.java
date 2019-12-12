package cn.stylefeng.guns.modular.sms.mapper;

import cn.stylefeng.guns.modular.sms.entity.Contacts;
import cn.stylefeng.guns.modular.sms.model.params.ContactsParam;
import cn.stylefeng.guns.modular.sms.model.result.ContactsResult;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 联系人 Mapper 接口
 * </p>
 *
 * @author yqy
 * @since 2019-12-10
 */
public interface ContactsMapper extends BaseMapper<Contacts> {

    /**
     * 获取列表
     *
     * @author yqy
     * @Date 2019-12-10
     */
    List<ContactsResult> customList(@Param("paramCondition") ContactsParam paramCondition);

    /**
     * 获取map列表
     *
     * @author yqy
     * @Date 2019-12-10
     */
    List<Map<String, Object>> customMapList(@Param("paramCondition") ContactsParam paramCondition);

    /**
     * 获取分页实体列表
     *
     * @author yqy
     * @Date 2019-12-10
     */
    Page<ContactsResult> customPageList(@Param("page") Page page, @Param("paramCondition") ContactsParam paramCondition);

    /**
     * 获取分页map列表
     *
     * @author yqy
     * @Date 2019-12-10
     */
    Page<Map<String, Object>> customPageMapList(@Param("page") Page page, @Param("paramCondition") ContactsParam paramCondition);

}
