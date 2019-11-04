package cn.stylefeng.guns.modular.sms.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

/**
 * <p>
 * 号段配置表
 * </p>
 *
 * @author yqy
 * @since 2019-10-31
 */
@TableName("mobile")
public class Mobile implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @TableId(value = "mobileid", type = IdType.AUTO)
    private Long mobileid;

    /**
     * 前缀
     */
    @TableField("prefix")
    private String prefix;

    /**
     * 号段
     */
    @TableField("mobile")
    private String mobile;

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
     * 运营商
     */
    @TableField("corp")
    private String corp;

    /**
     * 区号
     */
    @TableField("areacode")
    private String areacode;

    /**
     * 邮编
     */
    @TableField("postcode")
    private String postcode;

    /**
     * 管理号
     */
    @TableField("admincode")
    private String admincode;

    /**
     * 添加时间
     */
    @TableField("adddate")
    private Date adddate;


    public Long getMobileid() {
        return mobileid;
    }

    public void setMobileid(Long mobileid) {
        this.mobileid = mobileid;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
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

    public String getCorp() {
        return corp;
    }

    public void setCorp(String corp) {
        this.corp = corp;
    }

    public String getAreacode() {
        return areacode;
    }

    public void setAreacode(String areacode) {
        this.areacode = areacode;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getAdmincode() {
        return admincode;
    }

    public void setAdmincode(String admincode) {
        this.admincode = admincode;
    }

    public Date getAdddate() {
        return adddate;
    }

    public void setAdddate(Date adddate) {
        this.adddate = adddate;
    }

    @Override
    public String toString() {
        return "Mobile{" +
        "mobileid=" + mobileid +
        ", prefix=" + prefix +
        ", mobile=" + mobile +
        ", province=" + province +
        ", city=" + city +
        ", corp=" + corp +
        ", areacode=" + areacode +
        ", postcode=" + postcode +
        ", admincode=" + admincode +
        ", adddate=" + adddate +
        "}";
    }
}
