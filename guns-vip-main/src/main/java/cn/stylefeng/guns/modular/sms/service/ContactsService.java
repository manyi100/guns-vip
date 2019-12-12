package cn.stylefeng.guns.modular.sms.service;

import cn.stylefeng.guns.base.pojo.page.LayuiPageInfo;
import cn.stylefeng.guns.modular.sms.entity.Contacts;
import cn.stylefeng.guns.modular.sms.model.params.ContactsParam;
import cn.stylefeng.guns.modular.sms.model.result.ContactsResult;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 联系人 服务类
 * </p>
 *
 * @author yqy
 * @since 2019-12-10
 */
public interface ContactsService extends IService<Contacts> {

    /**
     * 新增
     *
     * @author yqy
     * @Date 2019-12-10
     */
    void add(ContactsParam param);

    /**
     * 删除
     *
     * @author yqy
     * @Date 2019-12-10
     */
    void delete(ContactsParam param);

    /**
     * 更新
     *
     * @author yqy
     * @Date 2019-12-10
     */
    void update(ContactsParam param);

    /**
     * 查询单条数据，Specification模式
     *
     * @author yqy
     * @Date 2019-12-10
     */
    ContactsResult findBySpec(ContactsParam param);

    /**
     * 查询列表，Specification模式
     *
     * @author yqy
     * @Date 2019-12-10
     */
    List<ContactsResult> findListBySpec(ContactsParam param);

    /**
     * 查询分页数据，Specification模式
     *
     * @author yqy
     * @Date 2019-12-10
     */
     LayuiPageInfo findPageBySpec(ContactsParam param);

}
