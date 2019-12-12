package cn.stylefeng.guns.modular.sms.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

/**
 * <p>
 * 联系人分组
 * </p>
 *
 * @author yqy
 * @since 2019-12-10
 */
@TableName("contactsgroup")
public class Contactsgroup implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 分组ID
     */
    @TableId(value = "groupid", type = IdType.AUTO)
    private Integer groupid;

    /**
     * 联系人组名
     */
    @TableField("groupname")
    private String groupname;

    /**
     * 序列 
     */
    @TableField("orderid")
    private Integer orderid;

    /**
     * 企业ID
     */
    @TableField("entid")
    private Long entid;

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


    public Integer getGroupid() {
        return groupid;
    }

    public void setGroupid(Integer groupid) {
        this.groupid = groupid;
    }

    public String getGroupname() {
        return groupname;
    }

    public void setGroupname(String groupname) {
        this.groupname = groupname;
    }

    public Integer getOrderid() {
        return orderid;
    }

    public void setOrderid(Integer orderid) {
        this.orderid = orderid;
    }

    public Long getEntid() {
        return entid;
    }

    public void setEntid(Long entid) {
        this.entid = entid;
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
        return "Contactsgroup{" +
        "groupid=" + groupid +
        ", groupname=" + groupname +
        ", orderid=" + orderid +
        ", entid=" + entid +
        ", remark=" + remark +
        ", adddate=" + adddate +
        "}";
    }
}
