package cn.stylefeng.guns.modular.sms.service;

import cn.stylefeng.guns.base.pojo.page.LayuiPageInfo;
import cn.stylefeng.guns.modular.sms.entity.TcGwProtocol;
import cn.stylefeng.guns.modular.sms.model.params.TcGwProtocolParam;
import cn.stylefeng.guns.modular.sms.model.result.TcGwProtocolResult;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 短信协议配置表 服务类
 * </p>
 *
 * @author yqy
 * @since 2019-10-31
 */
public interface TcGwProtocolService extends IService<TcGwProtocol> {

    /**
     * 新增
     *
     * @author yqy
     * @Date 2019-10-31
     */
    void add(TcGwProtocolParam param);

    /**
     * 删除
     *
     * @author yqy
     * @Date 2019-10-31
     */
    void delete(TcGwProtocolParam param);

    /**
     * 更新
     *
     * @author yqy
     * @Date 2019-10-31
     */
    void update(TcGwProtocolParam param);

    /**
     * 查询单条数据，Specification模式
     *
     * @author yqy
     * @Date 2019-10-31
     */
    TcGwProtocolResult findBySpec(TcGwProtocolParam param);

    /**
     * 查询列表，Specification模式
     *
     * @author yqy
     * @Date 2019-10-31
     */
    List<TcGwProtocolResult> findListBySpec(TcGwProtocolParam param);

    /**
     * 查询分页数据，Specification模式
     *
     * @author yqy
     * @Date 2019-10-31
     */
     LayuiPageInfo findPageBySpec(TcGwProtocolParam param);

}
