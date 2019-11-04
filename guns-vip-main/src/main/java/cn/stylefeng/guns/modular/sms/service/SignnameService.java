package cn.stylefeng.guns.modular.sms.service;

import cn.stylefeng.guns.base.pojo.page.LayuiPageInfo;
import cn.stylefeng.guns.modular.sms.entity.Signname;
import cn.stylefeng.guns.modular.sms.model.params.SignnameParam;
import cn.stylefeng.guns.modular.sms.model.result.SignnameResult;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 签名配置表 服务类
 * </p>
 *
 * @author yqy
 * @since 2019-10-31
 */
public interface SignnameService extends IService<Signname> {

    /**
     * 新增
     *
     * @author yqy
     * @Date 2019-10-31
     */
    void add(SignnameParam param);

    /**
     * 删除
     *
     * @author yqy
     * @Date 2019-10-31
     */
    void delete(SignnameParam param);

    /**
     * 更新
     *
     * @author yqy
     * @Date 2019-10-31
     */
    void update(SignnameParam param);

    /**
     * 查询单条数据，Specification模式
     *
     * @author yqy
     * @Date 2019-10-31
     */
    SignnameResult findBySpec(SignnameParam param);

    /**
     * 查询列表，Specification模式
     *
     * @author yqy
     * @Date 2019-10-31
     */
    List<SignnameResult> findListBySpec(SignnameParam param);

    /**
     * 查询分页数据，Specification模式
     *
     * @author yqy
     * @Date 2019-10-31
     */
     LayuiPageInfo findPageBySpec(SignnameParam param);

}
