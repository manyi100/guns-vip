package cn.stylefeng.guns.modular.sms.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

/**
 * <p>
 * 余额变更表
 * </p>
 *
 * @author yqy
 * @since 2019-12-10
 */
@TableName("balance")
public class Balance implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @TableId(value = "balanceid", type = IdType.AUTO)
    private Long balanceid;

    /**
     * spnumid
     */
    @TableField("spnumid")
    private Long spnumid;

    /**
     * 操作条数
     */
    @TableField("optcount")
    private Integer optcount;

    /**
     * 操作前条数
     */
    @TableField("beforecount")
    private Integer beforecount;

    /**
     * 操作后条数
     */
    @TableField("curcount")
    private Integer curcount;

    /**
     * 企业ID
     */
    @TableField("entid")
    private Long entid;

    /**
     * 操作人ID
     */
    @TableField("userid")
    private Long userid;

    /**
     * 操作人
     */
    @TableField("username")
    private String username;

    /**
     * 操作类型(自动补返,补款,扣款)
     */
    @TableField("balancetype")
    private Integer balancetype;

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


    public Long getBalanceid() {
        return balanceid;
    }

    public void setBalanceid(Long balanceid) {
        this.balanceid = balanceid;
    }

    public Long getSpnumid() {
        return spnumid;
    }

    public void setSpnumid(Long spnumid) {
        this.spnumid = spnumid;
    }

    public Integer getOptcount() {
        return optcount;
    }

    public void setOptcount(Integer optcount) {
        this.optcount = optcount;
    }

    public Integer getBeforecount() {
        return beforecount;
    }

    public void setBeforecount(Integer beforecount) {
        this.beforecount = beforecount;
    }

    public Integer getCurcount() {
        return curcount;
    }

    public void setCurcount(Integer curcount) {
        this.curcount = curcount;
    }

    public Long getEntid() {
        return entid;
    }

    public void setEntid(Long entid) {
        this.entid = entid;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getBalancetype() {
        return balancetype;
    }

    public void setBalancetype(Integer balancetype) {
        this.balancetype = balancetype;
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
        return "Balance{" +
        "balanceid=" + balanceid +
        ", spnumid=" + spnumid +
        ", optcount=" + optcount +
        ", beforecount=" + beforecount +
        ", curcount=" + curcount +
        ", entid=" + entid +
        ", userid=" + userid +
        ", username=" + username +
        ", balancetype=" + balancetype +
        ", remark=" + remark +
        ", status=" + status +
        ", adddate=" + adddate +
        "}";
    }
}
