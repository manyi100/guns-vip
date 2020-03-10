package cn.stylefeng.guns.modular.sms.service;

import cn.stylefeng.guns.base.pojo.page.LayuiPageInfo;
import cn.stylefeng.guns.modular.sms.entity.Send;
import cn.stylefeng.guns.modular.sms.model.params.SendParam;
import cn.stylefeng.guns.modular.sms.model.result.SendResult;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 发送表 服务类
 * </p>
 *
 * @author yqy
 * @since 2019-10-31
 */
public interface SendService extends IService<Send> {

    /**
     * 新增
     *
     * @author yqy
     * @Date 2019-10-31
     */
    void add(SendParam param);

    /**
     * 删除
     *
     * @author yqy
     * @Date 2019-10-31
     */
    void delete(SendParam param);

    /**
     * 更新
     *
     * @author yqy
     * @Date 2019-10-31
     */
    void update(SendParam param);

    /**
     * 查询单条数据，Specification模式
     *
     * @author yqy
     * @Date 2019-10-31
     */
    SendResult findBySpec(SendParam param);

    /**
     * 查询列表，Specification模式
     *
     * @author yqy
     * @Date 2019-10-31
     */
    List<SendResult> findListBySpec(SendParam param);

    /**
     * 查询分页数据，Specification模式
     *
     * @author yqy
     * @Date 2019-10-31
     */
     LayuiPageInfo findPageBySpec(SendParam param);
//    int getMonthCount(@Param("userid") String userid,@Param("submitDate") String adddate);
//    int getDayCount(@Param("userid") String userid,@Param("submitDate") String adddate);

    /**
     * 按日统计
     * @param userid
     * @return
     */

//    int getDayCount(@Param("userid") String userid, @Param("submitDate") String adddate);
//    /**
//     * 按月统计
//     * @param userid
//     * @param adddate
//     * @return
//     */
//
//    int getMonthCount(@Param("userid") String userid,@Param("submitDate") String adddate);

//    @Select("Select count(*) as count " +
//            "from send where entityName=#{userid} and date_format(submitDate,'%Y-%m-%d')=#{submitDate}" +
//            "group by entityName,date_format(submitDate,'%Y-%m-%d')")
    @Select(" select submitcnt from daystat " +
            " where entityName=#{userid} and date_format(submitDate,'%Y-%m-%d')=#{submitDate}"
            )
    int getDayCount(String userid);


    @Select(" select submitcnt from monthstat  " +
            "from send where entityName=#{userid} and date_format(submitDate,'%Y-%m')=#{submitDate}"
           )
    int getMonthCount(String userid);

    List<Map<String, Object>> getThisMonth(String userid);
}
