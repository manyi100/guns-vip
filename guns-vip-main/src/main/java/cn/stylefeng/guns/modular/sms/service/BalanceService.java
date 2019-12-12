package cn.stylefeng.guns.modular.sms.service;

import cn.stylefeng.guns.base.pojo.page.LayuiPageInfo;
import cn.stylefeng.guns.modular.sms.entity.Balance;
import cn.stylefeng.guns.modular.sms.model.params.BalanceParam;
import cn.stylefeng.guns.modular.sms.model.result.BalanceResult;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 余额变更表 服务类
 * </p>
 *
 * @author yqy
 * @since 2019-12-10
 */
public interface BalanceService extends IService<Balance> {

    /**
     * 新增
     *
     * @author yqy
     * @Date 2019-12-10
     */
    void add(BalanceParam param);

    /**
     * 删除
     *
     * @author yqy
     * @Date 2019-12-10
     */
    void delete(BalanceParam param);

    /**
     * 更新
     *
     * @author yqy
     * @Date 2019-12-10
     */
    void update(BalanceParam param);

    /**
     * 查询单条数据，Specification模式
     *
     * @author yqy
     * @Date 2019-12-10
     */
    BalanceResult findBySpec(BalanceParam param);

    /**
     * 查询列表，Specification模式
     *
     * @author yqy
     * @Date 2019-12-10
     */
    List<BalanceResult> findListBySpec(BalanceParam param);

    /**
     * 查询分页数据，Specification模式
     *
     * @author yqy
     * @Date 2019-12-10
     */
     LayuiPageInfo findPageBySpec(BalanceParam param);

}
