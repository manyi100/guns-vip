package cn.stylefeng.guns.sys.modular.modularA.service;

import cn.stylefeng.guns.base.pojo.page.LayuiPageInfo;
import cn.stylefeng.guns.sys.modular.modularA.entity.SConfig;
import cn.stylefeng.guns.sys.modular.modularA.model.params.SConfigParam;
import cn.stylefeng.guns.sys.modular.modularA.model.result.SConfigResult;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 参数配置 服务类
 * </p>
 *
 * @author yqy
 * @since 2019-10-31
 */
public interface SConfigService extends IService<SConfig> {

    /**
     * 新增
     *
     * @author yqy
     * @Date 2019-10-31
     */
    void add(SConfigParam param);

    /**
     * 删除
     *
     * @author yqy
     * @Date 2019-10-31
     */
    void delete(SConfigParam param);

    /**
     * 更新
     *
     * @author yqy
     * @Date 2019-10-31
     */
    void update(SConfigParam param);

    /**
     * 查询单条数据，Specification模式
     *
     * @author yqy
     * @Date 2019-10-31
     */
    SConfigResult findBySpec(SConfigParam param);

    /**
     * 查询列表，Specification模式
     *
     * @author yqy
     * @Date 2019-10-31
     */
    List<SConfigResult> findListBySpec(SConfigParam param);

    /**
     * 查询分页数据，Specification模式
     *
     * @author yqy
     * @Date 2019-10-31
     */
     LayuiPageInfo findPageBySpec(SConfigParam param);

}
