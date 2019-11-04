package cn.stylefeng.guns.modular.sms.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

/**
 * <p>
 * 短信接收表
 * </p>
 *
 * @author yqy
 * @since 2019-10-31
 */
@TableName("deliver")
public class Deliver implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @TableId(value = "deliverId", type = IdType.AUTO)
    private Long deliverId;

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
     * 上行内容
     */
    @TableField("msgContent")
    private String msgContent;

    /**
     * sequenceId
     */
    @TableField("sequenceId")
    private Long sequenceId;

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


    public Long getDeliverId() {
        return deliverId;
    }

    public void setDeliverId(Long deliverId) {
        this.deliverId = deliverId;
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

    public String getMsgContent() {
        return msgContent;
    }

    public void setMsgContent(String msgContent) {
        this.msgContent = msgContent;
    }

    public Long getSequenceId() {
        return sequenceId;
    }

    public void setSequenceId(Long sequenceId) {
        this.sequenceId = sequenceId;
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
        return "Deliver{" +
        "deliverId=" + deliverId +
        ", entityName=" + entityName +
        ", msgId=" + msgId +
        ", destid=" + destid +
        ", srcterminalid=" + srcterminalid +
        ", msgContent=" + msgContent +
        ", sequenceId=" + sequenceId +
        ", status=" + status +
        ", submitDate=" + submitDate +
        ", dealDate=" + dealDate +
        "}";
    }
}
