package cn.stylefeng.guns.modular.sms.model.params;

import lombok.Data;
import cn.stylefeng.roses.kernel.model.validator.BaseValidatingParam;
import java.util.Date;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>
 * 充值记录表
 * </p>
 *
 * @author yqy
 * @since 2019-10-31
 */
@Data
public class RechargeParam implements Serializable, BaseValidatingParam {

    private static final long serialVersionUID = 1L;


    /**
     * 主键ID
     */
    private Long rechargeid;

    /**
     * spnumid
     */
    private Long spnumid;

    /**
     * 企业ID
     */
    private Long entid;

    /**
     * 操作人
     */
    private Long userid;

    /**
     * 条数
     */
    private Integer cnt;

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
