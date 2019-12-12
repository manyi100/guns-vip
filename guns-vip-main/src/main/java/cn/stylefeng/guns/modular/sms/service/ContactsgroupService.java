package cn.stylefeng.guns.modular.sms.service;

import cn.stylefeng.guns.base.pojo.page.LayuiPageInfo;
import cn.stylefeng.guns.modular.sms.entity.Contactsgroup;
import cn.stylefeng.guns.modular.sms.model.params.ContactsgroupParam;
import cn.stylefeng.guns.modular.sms.model.result.ContactsgroupResult;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 联系人分组 服务类
 * </p>
 *
 * @author yqy
 * @since 2019-12-10
 */
public interface ContactsgroupService extends IService<Contactsgroup> {

    /**
     * 新增
     *
     * @author yqy
     * @Date 2019-12-10
     */
    void add(ContactsgroupParam param);

    /**
     * 删除
     *
     * @author yqy
     * @Date 2019-12-10
     */
    void delete(ContactsgroupParam param);

    /**
     * 更新
     *
     * @author yqy
     * @Date 2019-12-10
     */
    void update(ContactsgroupParam param);

    /**
     * 查询单条数据，Specification模式
     *
     * @author yqy
     * @Date 2019-12-10
     */
    ContactsgroupResult findBySpec(ContactsgroupParam param);

    /**
     * 查询列表，Specification模式
     *
     * @author yqy
     * @Date 2019-12-10
     */
    List<ContactsgroupResult> findListBySpec(ContactsgroupParam param);

    /**
     * 查询分页数据，Specification模式
     *
     * @author yqy
     * @Date 2019-12-10
     */
     LayuiPageInfo findPageBySpec(ContactsgroupParam param);

}
