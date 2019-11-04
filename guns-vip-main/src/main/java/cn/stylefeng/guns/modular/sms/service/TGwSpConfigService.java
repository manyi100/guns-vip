package cn.stylefeng.guns.modular.sms.service;

import cn.stylefeng.guns.base.pojo.page.LayuiPageInfo;
import cn.stylefeng.guns.modular.sms.entity.TGwSpConfig;
import cn.stylefeng.guns.modular.sms.model.params.TGwSpConfigParam;
import cn.stylefeng.guns.modular.sms.model.result.TGwSpConfigResult;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 网关配置表 服务类
 * </p>
 *
 * @author yqy
 * @since 2019-10-31
 */
public interface TGwSpConfigService extends IService<TGwSpConfig> {

    /**
     * 新增
     *
     * @author yqy
     * @Date 2019-10-31
     */
    void add(TGwSpConfigParam param);

    /**
     * 删除
     *
     * @author yqy
     * @Date 2019-10-31
     */
    void delete(TGwSpConfigParam param);

    /**
     * 更新
     *
     * @author yqy
     * @Date 2019-10-31
     */
    void update(TGwSpConfigParam param);

    /**
     * 查询单条数据，Specification模式
     *
     * @author yqy
     * @Date 2019-10-31
     */
    TGwSpConfigResult findBySpec(TGwSpConfigParam param);

    /**
     * 查询列表，Specification模式
     *
     * @author yqy
     * @Date 2019-10-31
     */
    List<TGwSpConfigResult> findListBySpec(TGwSpConfigParam param);

    /**
     * 查询分页数据，Specification模式
     *
     * @author yqy
     * @Date 2019-10-31
     */
     LayuiPageInfo findPageBySpec(TGwSpConfigParam param);

}
