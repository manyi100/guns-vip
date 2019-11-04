package cn.stylefeng.guns.modular.sms.service;

import cn.stylefeng.guns.base.pojo.page.LayuiPageInfo;
import cn.stylefeng.guns.modular.sms.entity.Deliver;
import cn.stylefeng.guns.modular.sms.model.params.DeliverParam;
import cn.stylefeng.guns.modular.sms.model.result.DeliverResult;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 短信接收表 服务类
 * </p>
 *
 * @author yqy
 * @since 2019-10-31
 */
public interface DeliverService extends IService<Deliver> {

    /**
     * 新增
     *
     * @author yqy
     * @Date 2019-10-31
     */
    void add(DeliverParam param);

    /**
     * 删除
     *
     * @author yqy
     * @Date 2019-10-31
     */
    void delete(DeliverParam param);

    /**
     * 更新
     *
     * @author yqy
     * @Date 2019-10-31
     */
    void update(DeliverParam param);

    /**
     * 查询单条数据，Specification模式
     *
     * @author yqy
     * @Date 2019-10-31
     */
    DeliverResult findBySpec(DeliverParam param);

    /**
     * 查询列表，Specification模式
     *
     * @author yqy
     * @Date 2019-10-31
     */
    List<DeliverResult> findListBySpec(DeliverParam param);

    /**
     * 查询分页数据，Specification模式
     *
     * @author yqy
     * @Date 2019-10-31
     */
     LayuiPageInfo findPageBySpec(DeliverParam param);

}
