package cn.stylefeng.guns.modular.sms.service;

import cn.stylefeng.guns.base.pojo.page.LayuiPageInfo;
import cn.stylefeng.guns.modular.sms.entity.Block;
import cn.stylefeng.guns.modular.sms.model.params.BlockParam;
import cn.stylefeng.guns.modular.sms.model.result.BlockResult;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;


/**
 * <p>
 * 黑名单表 服务类
 * </p>
 *
 * @author yqy
 * @since 2019-10-31
 */
public interface BlockService extends IService<Block> {

    int setStatus(Long userId, int status);

    /**
     * 新增
     *
     * @author yqy
     * @Date 2019-10-31
     */
    void add(BlockParam param);

    /**
     * 删除
     *
     * @author yqy
     * @Date 2019-10-31
     */
    void delete(BlockParam param);

    /**
     * 更新
     *
     * @author yqy
     * @Date 2019-10-31
     */
    void update(BlockParam param);

    /**
     * 查询单条数据，Specification模式
     *
     * @author yqy
     * @Date 2019-10-31
     */
    BlockResult findBySpec(BlockParam param);

    /**
     * 查询列表，Specification模式
     *
     * @author yqy
     * @Date 2019-10-31
     */
    List<BlockResult> findListBySpec(BlockParam param);

    /**
     * 查询分页数据，Specification模式
     *
     * @author yqy
     * @Date 2019-10-31
     */
     LayuiPageInfo findPageBySpec(BlockParam param);

}
