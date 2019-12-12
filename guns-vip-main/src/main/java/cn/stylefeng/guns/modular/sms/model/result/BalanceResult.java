package cn.stylefeng.guns.modular.sms.model.result;

import lombok.Data;
import java.util.Date;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>
 * 余额变更表
 * </p>
 *
 * @author yqy
 * @since 2019-12-10
 */
@Data
public class BalanceResult implements Serializable {

    private static final long serialVersionUID = 1L;


    /**
     * 主键ID
     */
    private Long balanceid;

    /**
     * spnumid
     */
    private Long spnumid;

    /**
     * 操作条数
     */
    private Integer optcount;

    /**
     * 操作前条数
     */
    private Integer beforecount;

    /**
     * 操作后条数
     */
    private Integer curcount;

    /**
     * 企业ID
     */
    private Long entid;

    /**
     * 操作人ID
     */
    private Long userid;

    /**
     * 操作人
     */
    private String username;

    /**
     * 操作类型(自动补返,补款,扣款)
     */
    private Integer balancetype;

    /**
     * 备注
     */
    private String remark;

    /**
     * 状态0,可用，1不可用
     */
    private Integer status;

    /**
     * 添加时间
     */
    private Date adddate;

}
