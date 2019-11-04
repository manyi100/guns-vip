package cn.stylefeng.guns.modular.sms.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

/**
 * <p>
 * 回执表
 * </p>
 *
 * @author yqy
 * @since 2019-10-31
 */
@TableName("report")
public class Report implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @TableId(value = "reportId", type = IdType.AUTO)
    private Long reportId;

    /**
     * 接入码
     */
    @TableField("entityName")
    private String entityName;

    /**
     * Msgid
     */
    @TableField("msgId")
    private String msgId;

    /**
     * 原Msgid和send表中msgid对应
     */
    @TableField("srcmsgId")
    private String srcmsgId;

    /**
     * 回执状态
     */
    @TableField("stat")
    private String stat;

    /**
     * 错误代码表
     */
    @TableField("err")
    private String err;

    /**
     * 源号码
     */
    @TableField("destid")
    private String destid;

    /**
     * 目的号码
     */
    @TableField("srcterminalid")
    private String srcterminalid;

    /**
     * linkId
     */
    @TableField("linkId")
    private String linkId;

    /**
     * serverid
     */
    @TableField("serverid")
    private String serverid;

    /**
     * 状态0,未发送，1己发送
     */
    @TableField("status")
    private Integer status;

    /**
     * 提交时间
     */
    @TableField("submitDate")
    private Date submitDate;

    /**
     * 处理时间
     */
    @TableField("dealDate")
    private Date dealDate;


    public Long getReportId() {
        return reportId;
    }

    public void setReportId(Long reportId) {
        this.reportId = reportId;
    }

    public String getEntityName() {
        return entityName;
    }

    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }

    public String getMsgId() {
        return msgId;
    }

    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }

    public String getSrcmsgId() {
        return srcmsgId;
    }

    public void setSrcmsgId(String srcmsgId) {
        this.srcmsgId = srcmsgId;
    }

    public String getStat() {
        return stat;
    }

    public void setStat(String stat) {
        this.stat = stat;
    }

    public String getErr() {
        return err;
    }

    public void setErr(String err) {
        this.err = err;
    }

    public String getDestid() {
        return destid;
    }

    public void setDestid(String destid) {
        this.destid = destid;
    }

    public String getSrcterminalid() {
        return srcterminalid;
    }

    public void setSrcterminalid(String srcterminalid) {
        this.srcterminalid = srcterminalid;
    }

    public String getLinkId() {
        return linkId;
    }

    public void setLinkId(String linkId) {
        this.linkId = linkId;
    }

    public String getServerid() {
        return serverid;
    }

    public void setServerid(String serverid) {
        this.serverid = serverid;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getSubmitDate() {
        return submitDate;
    }

    public void setSubmitDate(Date submitDate) {
        this.submitDate = submitDate;
    }

    public Date getDealDate() {
        return dealDate;
    }

    public void setDealDate(Date dealDate) {
        this.dealDate = dealDate;
    }

    @Override
    public String toString() {
        return "Report{" +
        "reportId=" + reportId +
        ", entityName=" + entityName +
        ", msgId=" + msgId +
        ", srcmsgId=" + srcmsgId +
        ", stat=" + stat +
        ", err=" + err +
        ", destid=" + destid +
        ", srcterminalid=" + srcterminalid +
        ", linkId=" + linkId +
        ", serverid=" + serverid +
        ", status=" + status +
        ", submitDate=" + submitDate +
        ", dealDate=" + dealDate +
        "}";
    }
}
