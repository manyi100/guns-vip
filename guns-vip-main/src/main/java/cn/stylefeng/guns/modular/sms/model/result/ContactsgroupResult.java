package cn.stylefeng.guns.modular.sms.model.result;

import lombok.Data;
import java.util.Date;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>
 * 联系人分组
 * </p>
 *
 * @author yqy
 * @since 2019-12-10
 */
@Data
public class ContactsgroupResult implements Serializable {

    private static final long serialVersionUID = 1L;


    /**
     * 分组ID
     */
    private Integer groupid;

    /**
     * 联系人组名
     */
    private String groupname;

    /**
     * 序列 
     */
    private Integer orderid;

    /**
     * 企业ID
     */
    private Long entid;

    /**
     * 备注
     */
    private String remark;

    /**
     * 添加时间
     */
    private Date adddate;

}
