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
     * 黑名单号码
     */
    @TableField("blockmobile")
    @Excel(name = "黑名单号码")
    private String blockmobile;

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

}
