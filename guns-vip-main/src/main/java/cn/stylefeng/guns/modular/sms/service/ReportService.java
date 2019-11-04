package cn.stylefeng.guns.modular.sms.service;

import cn.stylefeng.guns.base.pojo.page.LayuiPageInfo;
import cn.stylefeng.guns.modular.sms.entity.Report;
import cn.stylefeng.guns.modular.sms.model.params.ReportParam;
import cn.stylefeng.guns.modular.sms.model.result.ReportResult;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 回执表 服务类
 * </p>
 *
 * @author yqy
 * @since 2019-10-31
 */
public interface ReportService extends IService<Report> {

    /**
     * 新增
     *
     * @author yqy
     * @Date 2019-10-31
     */
    void add(ReportParam param);

    /**
     * 删除
     *
     * @author yqy
     * @Date 2019-10-31
     */
    void delete(ReportParam param);

    /**
     * 更新
     *
     * @author yqy
     * @Date 2019-10-31
     */
    void update(ReportParam param);

    /**
     * 查询单条数据，Specification模式
     *
     * @author yqy
     * @Date 2019-10-31
     */
    ReportResult findBySpec(ReportParam param);

    /**
     * 查询列表，Specification模式
     *
     * @author yqy
     * @Date 2019-10-31
     */
    List<ReportResult> findListBySpec(ReportParam param);

    /**
     * 查询分页数据，Specification模式
     *
     * @author yqy
     * @Date 2019-10-31
     */
     LayuiPageInfo findPageBySpec(ReportParam param);

}
