package cn.stylefeng.guns.modular.sms.model.params;

import lombok.Data;
import cn.stylefeng.roses.kernel.model.validator.BaseValidatingParam;
import java.util.Date;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>
 * 签名配置表
 * </p>
 *
 * @author yqy
 * @since 2019-10-31
 */
@Data
public class SignnameParam implements Serializable, BaseValidatingParam {

    private static final long serialVersionUID = 1L;


    /**
     * 主键ID
     */
    private Long signid;

    /**
     * 黑名单号码
     */
    private String signname;

    /**
     * 企业ID
     */
    private Long entid;

    /**
     * 黑名单类型
     */
    private Integer signtype;

    /**
     * 备注
     */
    private String remark;

    /**
     * 状态0,可用，1不可用
     */
    private Integer status;

    /**
     * 添加时间
     */
    private Date adddate;

    @Override
    public String checkParam() {
        return null;
    }

}
