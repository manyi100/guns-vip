package cn.stylefeng.guns.modular.sms.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * <p>
 * 联系人
 * </p>
 *
 * @author yqy
 * @since 2019-12-10
 */
@TableName("contacts")
public class Contacts implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @TableId(value = "contactsid", type = IdType.AUTO)
    private Long contactsid;

    /**
     * 手机号
     */
    @TableField("mobile")
    private String mobile;

    /**
     * 姓名
     */
    @TableField("contactsname")
    private String contactsname;

    /**
     * 性别
     */
    @TableField("sex")
    private Integer sex;

    /**
     * 邮箱
     */
    @TableField("email")
    private String email;

    /**
     * 地址
     */
    @TableField("address")
    private String address;

    /**
     * qq
     */
    @TableField("qq")
    private String qq;

    /**
     * 生日
     */
    @TableField("birthday")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;

    /**
     * 组别
     */
    @TableField("groupid")
    private Integer groupid;

    /**
     * 状态
     */
    @TableField("status")
    private Integer status;

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
     * 提交时间
     */
    @TableField("adddate")
    private Date adddate;


    public Long getContactsid() {
        return contactsid;
    }

    public void setContactsid(Long contactsid) {
        this.contactsid = contactsid;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getContactsname() {
        return contactsname;
    }

    public void setContactsname(String contactsname) {
        this.contactsname = contactsname;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Integer getGroupid() {
        return groupid;
    }

    public void setGroupid(Integer groupid) {
        this.groupid = groupid;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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
        return "Contacts{" +
        "contactsid=" + contactsid +
        ", mobile=" + mobile +
        ", contactsname=" + contactsname +
        ", sex=" + sex +
        ", email=" + email +
        ", address=" + address +
        ", qq=" + qq +
        ", birthday=" + birthday +
        ", groupid=" + groupid +
        ", status=" + status +
        ", entid=" + entid +
        ", remark=" + remark +
        ", adddate=" + adddate +
        "}";
    }
}
