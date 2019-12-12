package cn.stylefeng.guns.modular.sms.model.params;

import lombok.Data;
import cn.stylefeng.roses.kernel.model.validator.BaseValidatingParam;
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
public class ContactsgroupParam implements Serializable, BaseValidatingParam {

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

    @Override
    public String checkParam() {
        return null;
    }

}
