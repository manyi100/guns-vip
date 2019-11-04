package cn.stylefeng.guns.modular.sms.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

/**
 * <p>
 * 网关配置表
 * </p>
 *
 * @author yqy
 * @since 2019-10-31
 */
@TableName("t_gw_sp_config")
public class TGwSpConfig implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @TableId(value = "spnumId", type = IdType.AUTO)
    private Long spnumId;

    /**
     * 协议ID，1，SMPP，2，SMGP，3，CNGP，4，CMPP，5，SGIP
     */
    @TableField("protocolId")
    private Integer protocolId;

    /**
     * 运营商ID，1，电信，2，网通 3，移动 4，联通  (注意发送电信就填电信，移动 就选 移动)
     */
    @TableField("spId")
    private Integer spId;

    /**
     * 企业ID，0，管理员，1，2，3
     */
    @TableField("entId")
    private Integer entId;

    /**
     * 接入号IP
     */
    @TableField("spnumIp")
    private String spnumIp;

    /**
     * 端口号
     */
    @TableField("spnumPort")
    private Integer spnumPort;

    /**
     * SP号码
     */
    @TableField("spnum")
    private String spnum;

    /**
     * 帐号
     */
    @TableField("spnumBody")
    private String spnumBody;

    /**
     * 密码
     */
    @TableField("spnumPass")
    private String spnumPass;

    /**
     * 发送速率
     */
    @TableField("sendSpeed")
    private Integer sendSpeed;

    /**
     * 余额
     */
    @TableField("balance")
    private Integer balance;

    /**
     * 单价，分
     */
    @TableField("price")
    private Integer price;

    /**
     * 落地省份
     */
    @TableField("province")
    private String province;

    /**
     * 通道数量
     */
    @TableField("channelNum")
    private Integer channelNum;

    /**
     * 用途：0,管理员，1，客户端
     */
    @TableField("entmsnUse")
    private Integer entmsnUse;

    /**
     * 网关标记
     */
    @TableField("gwStation")
    private String gwStation;

    /**
     * 屏蔽区域，格式如下：北京，南京，上海
     */
    @TableField("blockarea")
    private String blockarea;

    /**
     * 备注
     */
    @TableField("remark")
    private String remark;

    /**
     * 客户端IP
     */
    @TableField("clientIp")
    private String clientIp;

    /**
     * 版本号
     */
    @TableField("version")
    private String version;

    /**
     * 状态0,可用，1，不可用
     */
    @TableField("status")
    private Integer status;

    /**
     * 提交时间
     */
    @TableField("submitdate")
    private Date submitdate;

    /**
     * 处理时间
     */
    @TableField("dealdate")
    private Date dealdate;


    public Long getSpnumId() {
        return spnumId;
    }

    public void setSpnumId(Long spnumId) {
        this.spnumId = spnumId;
    }

    public Integer getProtocolId() {
        return protocolId;
    }

    public void setProtocolId(Integer protocolId) {
        this.protocolId = protocolId;
    }

    public Integer getSpId() {
        return spId;
    }

    public void setSpId(Integer spId) {
        this.spId = spId;
    }

    public Integer getEntId() {
        return entId;
    }

    public void setEntId(Integer entId) {
        this.entId = entId;
    }

    public String getSpnumIp() {
        return spnumIp;
    }

    public void setSpnumIp(String spnumIp) {
        this.spnumIp = spnumIp;
    }

    public Integer getSpnumPort() {
        return spnumPort;
    }

    public void setSpnumPort(Integer spnumPort) {
        this.spnumPort = spnumPort;
    }

    public String getSpnum() {
        return spnum;
    }

    public void setSpnum(String spnum) {
        this.spnum = spnum;
    }

    public String getSpnumBody() {
        return spnumBody;
    }

    public void setSpnumBody(String spnumBody) {
        this.spnumBody = spnumBody;
    }

    public String getSpnumPass() {
        return spnumPass;
    }

    public void setSpnumPass(String spnumPass) {
        this.spnumPass = spnumPass;
    }

    public Integer getSendSpeed() {
        return sendSpeed;
    }

    public void setSendSpeed(Integer sendSpeed) {
        this.sendSpeed = sendSpeed;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public Integer getChannelNum() {
        return channelNum;
    }

    public void setChannelNum(Integer channelNum) {
        this.channelNum = channelNum;
    }

    public Integer getEntmsnUse() {
        return entmsnUse;
    }

    public void setEntmsnUse(Integer entmsnUse) {
        this.entmsnUse = entmsnUse;
    }

    public String getGwStation() {
        return gwStation;
    }

    public void setGwStation(String gwStation) {
        this.gwStation = gwStation;
    }

    public String getBlockarea() {
        return blockarea;
    }

    public void setBlockarea(String blockarea) {
        this.blockarea = blockarea;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getClientIp() {
        return clientIp;
    }

    public void setClientIp(String clientIp) {
        this.clientIp = clientIp;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getSubmitdate() {
        return submitdate;
    }

    public void setSubmitdate(Date submitdate) {
        this.submitdate = submitdate;
    }

    public Date getDealdate() {
        return dealdate;
    }

    public void setDealdate(Date dealdate) {
        this.dealdate = dealdate;
    }

    @Override
    public String toString() {
        return "TGwSpConfig{" +
        "spnumId=" + spnumId +
        ", protocolId=" + protocolId +
        ", spId=" + spId +
        ", entId=" + entId +
        ", spnumIp=" + spnumIp +
        ", spnumPort=" + spnumPort +
        ", spnum=" + spnum +
        ", spnumBody=" + spnumBody +
        ", spnumPass=" + spnumPass +
        ", sendSpeed=" + sendSpeed +
        ", balance=" + balance +
        ", price=" + price +
        ", province=" + province +
        ", channelNum=" + channelNum +
        ", entmsnUse=" + entmsnUse +
        ", gwStation=" + gwStation +
        ", blockarea=" + blockarea +
        ", remark=" + remark +
        ", clientIp=" + clientIp +
        ", version=" + version +
        ", status=" + status +
        ", submitdate=" + submitdate +
        ", dealdate=" + dealdate +
        "}";
    }
}
