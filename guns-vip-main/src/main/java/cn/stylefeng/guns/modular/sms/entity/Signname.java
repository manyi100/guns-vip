package cn.stylefeng.guns.modular.sms.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

/**
 * <p>
 * 签名配置表
 * </p>
 *
 * @author yqy
 * @since 2019-10-31
 */
@TableName("signname")
public class Signname implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @TableId(value = "signid", type = IdType.AUTO)
    private Long signid;

    /**
     * 黑名单号码
     */
    @TableField("signname")
    private String signname;

    /**
     * 企业ID
     */
    @TableField("entid")
    private Integer entid;

    /**
     * 黑名单类型
     */
    @TableField("signtype")
    private Integer signtype;

    /**
     * 备注
     */
    @TableField("remark")
    private String remark;

    /**
     * 状态0,可用，1不可用
     */
    @TableField("status")
    private Integer status;

    /**
     * 添加时间
     */
    @TableField("adddate")
    private Date adddate;


    public Long getSignid() {
        return signid;
    }

    public void setSignid(Long signid) {
        this.signid = signid;
    }

    public String getSignname() {
        return signname;
    }

    public void setSignname(String signname) {
        this.signname = signname;
    }

    public Integer getEntid() {
        return entid;
    }

    public void setEntid(Integer entid) {
        this.entid = entid;
    }

    public Integer getSigntype() {
        return signtype;
    }

    public void setSigntype(Integer signtype) {
        this.signtype = signtype;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getAdddate() {
        return adddate;
    }

    public void setAdddate(Date adddate) {
        this.adddate = adddate;
    }

    @Override
    public String toString() {
        return "Signname{" +
        "signid=" + signid +
        ", signname=" + signname +
        ", entid=" + entid +
        ", signtype=" + signtype +
        ", remark=" + remark +
        ", status=" + status +
        ", adddate=" + adddate +
        "}";
    }
}
