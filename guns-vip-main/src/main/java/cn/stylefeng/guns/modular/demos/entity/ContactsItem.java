package cn.stylefeng.guns.modular.demos.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
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
@TableName("contacts")
@Data
public class ContactsItem implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableField("blockmobile")
    @Excel(name = "黑名单号码")
    private String blockmobile;

    @TableField("blocktype")
    @Excel(name = "黑名单类型")
    private int blocktype;



    /**
     * 手机号
     */
    @TableField("mobile")
    @Excel(name = "手机号")
    private String mobile;

    /**
     * 姓名
     */
    @TableField("contactsname")
    @Excel(name = "姓名")
    private String contactsname;

    /**
     * 性别
     */
    @TableField("sex")
    @Excel(name = "性别")
    private Integer sex;

    /**
     * 邮箱
     */
    @TableField("email")
    @Excel(name = "邮箱")
    private String email;

    /**
     * 地址
     */
    @TableField("address")
    @Excel(name = "地址")
    private String address;

    /**
     * qq
     */
    @TableField("qq")
    @Excel(name = "qq")
    private String qq;

    /**
     * 生日
     */
    @TableField("birthday")
    @Excel(name = "生日")
    private Date birthday;

    /**
     * 组别
     */
    @TableField("groupid")
    @Excel(name = "组别")
    private Integer groupid;

    /**
     * 企业ID
     */
    @TableField("entid")
    @Excel(name = "企业ID")
    private Long entid;


    /**
     * 备注
     */
    @TableField(value = "remark",fill = FieldFill.DEFAULT)
    @Excel(name = "备注")
    private String remark;


}