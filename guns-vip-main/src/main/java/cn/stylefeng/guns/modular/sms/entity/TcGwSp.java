package cn.stylefeng.guns.modular.sms.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

/**
 * <p>
 * 运营商配置表
 * </p>
 *
 * @author yqy
 * @since 2019-10-31
 */
@TableName("tc_gw_sp")
public class TcGwSp implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 协议ID，1，中国电信，2，中国网通，3，中国移动，4，中国联通
     */
    @TableId(value = "spid", type = IdType.AUTO)
    private Integer spid;

    /**
     * 名称
     */
    @TableField("spname")
    private String spname;

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


    public Integer getSpid() {
        return spid;
    }

    public void setSpid(Integer spid) {
        this.spid = spid;
    }

    public String getSpname() {
        return spname;
    }

    public void setSpname(String spname) {
        this.spname = spname;
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
        return "TcGwSp{" +
        "spid=" + spid +
        ", spname=" + spname +
        ", remark=" + remark +
        ", adddate=" + adddate +
        "}";
    }
}
