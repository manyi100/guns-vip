package cn.stylefeng.guns.modular.sms.service;

import cn.stylefeng.guns.base.pojo.page.LayuiPageInfo;
import cn.stylefeng.guns.modular.sms.entity.Mobile;
import cn.stylefeng.guns.modular.sms.model.params.MobileParam;
import cn.stylefeng.guns.modular.sms.model.result.MobileResult;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 号段配置表 服务类
 * </p>
 *
 * @author yqy
 * @since 2019-10-31
 */
public interface MobileService extends IService<Mobile> {

    /**
     * 新增
     *
     * @author yqy
     * @Date 2019-10-31
     */
    void add(MobileParam param);

    /**
     * 删除
     *
     * @author yqy
     * @Date 2019-10-31
     */
    void delete(MobileParam param);

    /**
     * 更新
     *
     * @author yqy
     * @Date 2019-10-31
     */
    void update(MobileParam param);

    /**
     * 查询单条数据，Specification模式
     *
     * @author yqy
     * @Date 2019-10-31
     */
    MobileResult findBySpec(MobileParam param);

    /**
     * 查询列表，Specification模式
     *
     * @author yqy
     * @Date 2019-10-31
     */
    List<MobileResult> findListBySpec(MobileParam param);

    /**
     * 查询分页数据，Specification模式
     *
     * @author yqy
     * @Date 2019-10-31
     */
     LayuiPageInfo findPageBySpec(MobileParam param);

}
