package cn.stylefeng.guns.modular.sms.service;

import cn.stylefeng.guns.base.pojo.page.LayuiPageInfo;
import cn.stylefeng.guns.modular.sms.entity.TcGwSp;
import cn.stylefeng.guns.modular.sms.model.params.TcGwSpParam;
import cn.stylefeng.guns.modular.sms.model.result.TcGwSpResult;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 运营商配置表 服务类
 * </p>
 *
 * @author yqy
 * @since 2019-10-31
 */
public interface TcGwSpService extends IService<TcGwSp> {

    /**
     * 新增
     *
     * @author yqy
     * @Date 2019-10-31
     */
    void add(TcGwSpParam param);

    /**
     * 删除
     *
     * @author yqy
     * @Date 2019-10-31
     */
    void delete(TcGwSpParam param);

    /**
     * 更新
     *
     * @author yqy
     * @Date 2019-10-31
     */
    void update(TcGwSpParam param);

    /**
     * 查询单条数据，Specification模式
     *
     * @author yqy
     * @Date 2019-10-31
     */
    TcGwSpResult findBySpec(TcGwSpParam param);

    /**
     * 查询列表，Specification模式
     *
     * @author yqy
     * @Date 2019-10-31
     */
    List<TcGwSpResult> findListBySpec(TcGwSpParam param);

    /**
     * 查询分页数据，Specification模式
     *
     * @author yqy
     * @Date 2019-10-31
     */
     LayuiPageInfo findPageBySpec(TcGwSpParam param);

}
