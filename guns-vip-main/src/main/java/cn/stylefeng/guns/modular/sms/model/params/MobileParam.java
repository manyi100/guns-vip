package cn.stylefeng.guns.modular.sms.model.params;

import lombok.Data;
import cn.stylefeng.roses.kernel.model.validator.BaseValidatingParam;
import java.util.Date;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>
 * 号段配置表
 * </p>
 *
 * @author yqy
 * @since 2019-10-31
 */
@Data
public class MobileParam implements Serializable, BaseValidatingParam {

    private static final long serialVersionUID = 1L;


    /**
     * 主键ID
     */
    private Long mobileid;

    /**
     * 前缀
     */
    private String prefix;

    /**
     * 号段
     */
    private String mobile;

    /**
     * 省份
     */
    private String province;

    /**
     * 城市
     */
    private String city;

    /**
     * 运营商
     */
    private String corp;

    /**
     * 区号
     */
    private String areacode;

    /**
     * 邮编
     */
    private String postcode;

    /**
     * 管理号
     */
    private String admincode;

    /**
     * 添加时间
     */
    private Date adddate;

    @Override
    public String checkParam() {
        return null;
    }

}
