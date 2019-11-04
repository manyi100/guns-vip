package cn.stylefeng.guns.modular.sms.service;

import cn.stylefeng.guns.base.pojo.page.LayuiPageInfo;
import cn.stylefeng.guns.modular.sms.entity.Recharge;
import cn.stylefeng.guns.modular.sms.model.params.RechargeParam;
import cn.stylefeng.guns.modular.sms.model.result.RechargeResult;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 充值记录表 服务类
 * </p>
 *
 * @author yqy
 * @since 2019-10-31
 */
public interface RechargeService extends IService<Recharge> {

    /**
     * 新增
     *
     * @author yqy
     * @Date 2019-10-31
     */
    void add(RechargeParam param);

    /**
     * 删除
     *
     * @author yqy
     * @Date 2019-10-31
     */
    void delete(RechargeParam param);

    /**
     * 更新
     *
     * @author yqy
     * @Date 2019-10-31
     */
    void update(RechargeParam param);

    /**
     * 查询单条数据，Specification模式
     *
     * @author yqy
     * @Date 2019-10-31
     */
    RechargeResult findBySpec(RechargeParam param);

    /**
     * 查询列表，Specification模式
     *
     * @author yqy
     * @Date 2019-10-31
     */
    List<RechargeResult> findListBySpec(RechargeParam param);

    /**
     * 查询分页数据，Specification模式
     *
     * @author yqy
     * @Date 2019-10-31
     */
     LayuiPageInfo findPageBySpec(RechargeParam param);

}
