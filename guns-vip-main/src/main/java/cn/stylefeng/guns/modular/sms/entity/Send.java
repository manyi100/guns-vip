package cn.stylefeng.guns.modular.sms.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

/**
 * <p>
 * 发送表
 * </p>
 *
 * @author yqy
 * @since 2019-10-31
 */
@TableName("send")
public class Send implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @TableId(value = "taskId", type = IdType.AUTO)
    private Long taskId;

    /**
     * 内容
     */
    @TableField("content")
    private String content;

    /**
     * 源号码
     */
    @TableField("srcId")
    private String srcId;

    /**
     * 目的号码
     */
    @TableField("destterminalId")
    private String destterminalId;

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
     * 网关返回状态
     */
    @TableField("result")
    private Integer result;

    /**
     * 网关返回序列号
     */
    @TableField("sequenceid")
    private Integer sequenceid;

    /**
     * linkId
     */
    @TableField("linkId")
    private String linkId;

    /**
     * 接入号
     */
    @TableField("msgsrc")
    private String msgsrc;

    /**
     * 运营商ID
     */
    @TableField("spid")
    private Integer spid;

    /**
     * 省份
     */
    @TableField("province")
    private String province;

    /**
     * 城市
     */
    @TableField("city")
    private String city;

    /**
     * 区号
     */
    @TableField("areacode")
    private String areacode;

    /**
     * 状态 0 未发送，己发送
     */
    @TableField("status")
    private Integer status;

    /**
     * 发送网关
     */
    @TableField("entityid")
    private String entityid;

    /**
     * 真实网关返回id
     */
    @TableField("realmsgid")
    private String realmsgid;

    /**
     * 真实网关返回状态
     */
    @TableField("realresult")
    private Integer realresult;

    /**
     * 提交时间
     */
    @TableField("submitDate")
    private Date submitDate;

    /**
     * 处理时间
     */
    @TableField("sendDate")
    private Date sendDate;


    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSrcId() {
        return srcId;
    }

    public void setSrcId(String srcId) {
        this.srcId = srcId;
    }

    public String getDestterminalId() {
        return destterminalId;
    }

    public void setDestterminalId(String destterminalId) {
        this.destterminalId = destterminalId;
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

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }

    public Integer getSequenceid() {
        return sequenceid;
    }

    public void setSequenceid(Integer sequenceid) {
        this.sequenceid = sequenceid;
    }

    public String getLinkId() {
        return linkId;
    }

    public void setLinkId(String linkId) {
        this.linkId = linkId;
    }

    public String getMsgsrc() {
        return msgsrc;
    }

    public void setMsgsrc(String msgsrc) {
        this.msgsrc = msgsrc;
    }

    public Integer getSpid() {
        return spid;
    }

    public void setSpid(Integer spid) {
        this.spid = spid;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAreacode() {
        return areacode;
    }

    public void setAreacode(String areacode) {
        this.areacode = areacode;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getEntityid() {
        return entityid;
    }

    public void setEntityid(String entityid) {
        this.entityid = entityid;
    }

    public String getRealmsgid() {
        return realmsgid;
    }

    public void setRealmsgid(String realmsgid) {
        this.realmsgid = realmsgid;
    }

    public Integer getRealresult() {
        return realresult;
    }

    public void setRealresult(Integer realresult) {
        this.realresult = realresult;
    }

    public Date getSubmitDate() {
        return submitDate;
    }

    public void setSubmitDate(Date submitDate) {
        this.submitDate = submitDate;
    }

    public Date getSendDate() {
        return sendDate;
    }

    public void setSendDate(Date sendDate) {
        this.sendDate = sendDate;
    }

    @Override
    public String toString() {
        return "Send{" +
        "taskId=" + taskId +
        ", content=" + content +
        ", srcId=" + srcId +
        ", destterminalId=" + destterminalId +
        ", entityName=" + entityName +
        ", msgId=" + msgId +
        ", result=" + result +
        ", sequenceid=" + sequenceid +
        ", linkId=" + linkId +
        ", msgsrc=" + msgsrc +
        ", spid=" + spid +
        ", province=" + province +
        ", city=" + city +
        ", areacode=" + areacode +
        ", status=" + status +
        ", entityid=" + entityid +
        ", realmsgid=" + realmsgid +
        ", realresult=" + realresult +
        ", submitDate=" + submitDate +
        ", sendDate=" + sendDate +
        "}";
    }
}
