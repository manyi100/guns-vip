package cn.stylefeng.guns.modular.sms.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

/**
 * <p>
 * 日统计表
 * </p>
 *
 * @author yqy
 * @since 2019-11-14
 */
@TableName("daystat")
public class Daystat implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @TableId(value = "taskId", type = IdType.AUTO)
    private Long taskId;

    /**
     * 统计日志
     */
    @TableField("statDate")
    private String statDate;

    /**
     * 接入码
     */
    @TableField("entityName")
    private String entityName;

    /**
     * 提交数量
     */
    @TableField("submitcnt")
    private Integer submitcnt;

    /**
     * 提交成功数量
     */
    @TableField("submitsucccnt")
    private Integer submitsucccnt;

    /**
     * 提交失败数量
     */
    @TableField("submitfailcnt")
    private Integer submitfailcnt;

    /**
     * 提交成功率
     */
    @TableField("submitsuccrate")
    private Double submitsuccrate;

    /**
     * 报告数量
     */
    @TableField("reportcnt")
    private Integer reportcnt;

    /**
     * 报告成功数量
     */
    @TableField("reportsucccnt")
    private Integer reportsucccnt;

    /**
     * 报告成功数量
     */
    @TableField("reportfailcnt")
    private Integer reportfailcnt;

    /**
     * 报告未知数量
     */
    @TableField("reportunknowcnt")
    private Integer reportunknowcnt;

    /**
     * 报告成功率
     */
    @TableField("reportsuccrate")
    private Double reportsuccrate;

    /**
     * 创建时间
     */
    @TableField("submitDate")
    private Date submitDate;

    /**
     * 更新时间
     */
    @TableField("updateDate")
    private Date updateDate;


    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public String getStatDate() {
        return statDate;
    }

    public void setStatDate(String statDate) {
        this.statDate = statDate;
    }

    public String getEntityName() {
        return entityName;
    }

    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }

    public Integer getSubmitcnt() {
        return submitcnt;
    }

    public void setSubmitcnt(Integer submitcnt) {
        this.submitcnt = submitcnt;
    }

    public Integer getSubmitsucccnt() {
        return submitsucccnt;
    }

    public void setSubmitsucccnt(Integer submitsucccnt) {
        this.submitsucccnt = submitsucccnt;
    }

    public Integer getSubmitfailcnt() {
        return submitfailcnt;
    }

    public void setSubmitfailcnt(Integer submitfailcnt) {
        this.submitfailcnt = submitfailcnt;
    }

    public Double getSubmitsuccrate() {
        return submitsuccrate;
    }

    public void setSubmitsuccrate(Double submitsuccrate) {
        this.submitsuccrate = submitsuccrate;
    }

    public Integer getReportcnt() {
        return reportcnt;
    }

    public void setReportcnt(Integer reportcnt) {
        this.reportcnt = reportcnt;
    }

    public Integer getReportsucccnt() {
        return reportsucccnt;
    }

    public void setReportsucccnt(Integer reportsucccnt) {
        this.reportsucccnt = reportsucccnt;
    }

    public Integer getReportfailcnt() {
        return reportfailcnt;
    }

    public void setReportfailcnt(Integer reportfailcnt) {
        this.reportfailcnt = reportfailcnt;
    }

    public Integer getReportunknowcnt() {
        return reportunknowcnt;
    }

    public void setReportunknowcnt(Integer reportunknowcnt) {
        this.reportunknowcnt = reportunknowcnt;
    }

    public Double getReportsuccrate() {
        return reportsuccrate;
    }

    public void setReportsuccrate(Double reportsuccrate) {
        this.reportsuccrate = reportsuccrate;
    }

    public Date getSubmitDate() {
        return submitDate;
    }

    public void setSubmitDate(Date submitDate) {
        this.submitDate = submitDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    @Override
    public String toString() {
        return "Daystat{" +
        "taskId=" + taskId +
        ", statDate=" + statDate +
        ", entityName=" + entityName +
        ", submitcnt=" + submitcnt +
        ", submitsucccnt=" + submitsucccnt +
        ", submitfailcnt=" + submitfailcnt +
        ", submitsuccrate=" + submitsuccrate +
        ", reportcnt=" + reportcnt +
        ", reportsucccnt=" + reportsucccnt +
        ", reportfailcnt=" + reportfailcnt +
        ", reportunknowcnt=" + reportunknowcnt +
        ", reportsuccrate=" + reportsuccrate +
        ", submitDate=" + submitDate +
        ", updateDate=" + updateDate +
        "}";
    }
}
