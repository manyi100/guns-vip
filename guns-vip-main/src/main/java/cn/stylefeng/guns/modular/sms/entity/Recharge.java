package cn.stylefeng.guns.modular.sms.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

/**
 * <p>
 * 充值记录表
 * </p>
 *
 * @author yqy
 * @since 2019-10-31
 */
@TableName("recharge")
public class Recharge implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @TableId(value = "rechargeid", type = IdType.AUTO)
    private Long rechargeid;

    /**
     * spnumid
     */
    @TableField("spnumid")
    private Long spnumid;

    /**
     * 企业ID
     */
    @TableField("entid")
    private Long entid;

    /**
     * 操作人
     */
    @TableField("userid")
    private Long userid;

    /**
     * 条数
     */
    @TableField("cnt")
    private Integer cnt;

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


    public Long getRechargeid() {
        return rechargeid;
    }

    public void setRechargeid(Long rechargeid) {
        this.rechargeid = rechargeid;
    }

    public Long getSpnumid() {
        return spnumid;
    }

    public void setSpnumid(Long spnumid) {
        this.spnumid = spnumid;
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

    public Integer getCnt() {
        return cnt;
    }

    public void setCnt(Integer cnt) {
        this.cnt = cnt;
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
        return "Recharge{" +
        "rechargeid=" + rechargeid +
        ", spnumid=" + spnumid +
        ", entid=" + entid +
        ", userid=" + userid +
        ", cnt=" + cnt +
        ", remark=" + remark +
        ", adddate=" + adddate +
        "}";
    }
}
