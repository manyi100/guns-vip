package cn.stylefeng.guns.modular.sms.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

/**
 * <p>
 * 短信协议配置表
 * </p>
 *
 * @author yqy
 * @since 2019-10-31
 */
@TableName("tc_gw_protocol")
public class TcGwProtocol implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 协议ID，1，SMPP，2，SMGP，3，CNGP，4，CMPP，5，SGIP
     */
    @TableId(value = "protocolid", type = IdType.AUTO)
    private Integer protocolid;

    /**
     * 协议名称
     */
    @TableField("protocolname")
    private String protocolname;

    /**
     * 中文名称
     */
    @TableField("chsname")
    private String chsname;

    /**
     * 备注
     */
    @TableField("remark")
    private String remark;

    /**
     * 添加时间
     */
    @TableField("adddate")
    private Date adddate;


    public Integer getProtocolid() {
        return protocolid;
    }

    public void setProtocolid(Integer protocolid) {
        this.protocolid = protocolid;
    }

    public String getProtocolname() {
        return protocolname;
    }

    public void setProtocolname(String protocolname) {
        this.protocolname = protocolname;
    }

    public String getChsname() {
        return chsname;
    }

    public void setChsname(String chsname) {
        this.chsname = chsname;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getAdddate() {
        return adddate;
    }

    public void setAdddate(Date adddate) {
        this.adddate = adddate;
    }

    @Override
    public String toString() {
        return "TcGwProtocol{" +
        "protocolid=" + protocolid +
        ", protocolname=" + protocolname +
        ", chsname=" + chsname +
        ", remark=" + remark +
        ", adddate=" + adddate +
        "}";
    }
}
