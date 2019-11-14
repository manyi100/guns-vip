package cn.stylefeng.guns.modular.sms.model.result;

import lombok.Data;
import java.util.Date;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>
 * 日统计表
 * </p>
 *
 * @author yqy
 * @since 2019-11-14
 */
@Data
public class DaystatResult implements Serializable {

    private static final long serialVersionUID = 1L;


    /**
     * 主键ID
     */
    private Long taskId;

    /**
     * 统计日志
     */
    private String statDate;

    /**
     * 接入码
     */
    private String entityName;

    /**
     * 提交数量
     */
    private Integer submitcnt;

    /**
     * 提交成功数量
     */
    private Integer submitsucccnt;

    /**
     * 提交失败数量
     */
    private Integer submitfailcnt;

    /**
     * 提交成功率
     */
    private Double submitsuccrate;

    /**
     * 报告数量
     */
    private Integer reportcnt;

    /**
     * 报告成功数量
     */
    private Integer reportsucccnt;

    /**
     * 报告成功数量
     */
    private Integer reportfailcnt;

    /**
     * 报告未知数量
     */
    private Integer reportunknowcnt;

    /**
     * 报告成功率
     */
    private Double reportsuccrate;

    /**
     * 创建时间
     */
    private Date submitDate;

    /**
     * 更新时间
     */
    private Date updateDate;

}
