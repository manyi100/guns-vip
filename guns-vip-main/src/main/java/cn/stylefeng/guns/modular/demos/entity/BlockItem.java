package cn.stylefeng.guns.modular.demos.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 黑名单
 * </p>
 *
 * @author stylefeng
 * @since 2018-12-07
 */
@TableName("block")
@Data
public class BlockItem implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @TableId(value = "blockid", type = IdType.AUTO)
    @Excel(name = "主键ID")
    private Long blockid;

    /**
     * 黑名单号码
     */
    @TableField("blockmobile")
    @Excel(name = "黑名单号码")
    private String blockmobile;

    /**
     * 企业ID
     */
    @TableField(value = "entid",fill = FieldFill.DEFAULT)
    @Excel(name = "企业ID")
    private int entid;

    /**
     * 黑名单类型
     */
    @TableField("blocktype")
    @Excel(name = "黑名单类型")
    private int blocktype;

    /**
     * 备注
     */
    @TableField(value = "remark",fill = FieldFill.DEFAULT)
    @Excel(name = "备注")
    private String remark;
    /**
     * 状态
     */
    @TableField(value = "status",fill = FieldFill.DEFAULT)
    @Excel(name = "状态")
    private String status;
    /**
     * 创建时间
     */
    @TableField(value = "adddate", fill = FieldFill.INSERT_UPDATE)
    @Excel(name = "添加时间")
    private Date adddate;


}
