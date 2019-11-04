package cn.stylefeng.guns.modular.sms.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

/**
 * <p>
 * 黑名单表
 * </p>
 *
 * @author yqy
 * @since 2019-10-31
 */
@TableName("block")
public class Block implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @TableId(value = "blockid", type = IdType.AUTO)
    private Long blockid;

    /**
     * 黑名单号码
     */
    @TableField("blockmobile")
    private String blockmobile;

    /**
     * 企业ID
     */
    @TableField("entid")
    private Integer entid;

    /**
     * 黑名单类型
     */
    @TableField("blocktype")
    private Integer blocktype;

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


    public Long getBlockid() {
        return blockid;
    }

    public void setBlockid(Long blockid) {
        this.blockid = blockid;
    }

    public String getBlockmobile() {
        return blockmobile;
    }

    public void setBlockmobile(String blockmobile) {
        this.blockmobile = blockmobile;
    }

    public Integer getEntid() {
        return entid;
    }

    public void setEntid(Integer entid) {
        this.entid = entid;
    }

    public Integer getBlocktype() {
        return blocktype;
    }

    public void setBlocktype(Integer blocktype) {
        this.blocktype = blocktype;
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
        return "Block{" +
        "blockid=" + blockid +
        ", blockmobile=" + blockmobile +
        ", entid=" + entid +
        ", blocktype=" + blocktype +
        ", remark=" + remark +
        ", status=" + status +
        ", adddate=" + adddate +
        "}";
    }
}
