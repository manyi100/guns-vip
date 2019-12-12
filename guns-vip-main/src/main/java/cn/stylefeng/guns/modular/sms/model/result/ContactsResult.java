package cn.stylefeng.guns.modular.sms.model.result;

import lombok.Data;
import java.util.Date;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>
 * 联系人
 * </p>
 *
 * @author yqy
 * @since 2019-12-10
 */
@Data
public class ContactsResult implements Serializable {

    private static final long serialVersionUID = 1L;


    /**
     * 主键ID
     */
    private Long contactsid;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 姓名
     */
    private String contactsname;

    /**
     * 性别
     */
    private Integer sex;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 地址
     */
    private String address;

    /**
     * qq
     */
    private String qq;

    /**
     * 生日
     */
    private Date birthday;

    /**
     * 组别
     */
    private Integer groupid;

    /**
     * 状态
     */
    private Integer status;

    /**
     * 企业ID
     */
    private Long entid;

    /**
     * 备注
     */
    private String remark;

    /**
     * 提交时间
     */
    private Date adddate;

}
