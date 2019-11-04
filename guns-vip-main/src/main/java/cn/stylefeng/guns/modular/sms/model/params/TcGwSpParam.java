package cn.stylefeng.guns.modular.sms.model.params;

import lombok.Data;
import cn.stylefeng.roses.kernel.model.validator.BaseValidatingParam;
import java.util.Date;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>
 * 运营商配置表
 * </p>
 *
 * @author yqy
 * @since 2019-10-31
 */
@Data
public class TcGwSpParam implements Serializable, BaseValidatingParam {

    private static final long serialVersionUID = 1L;


    /**
     * 协议ID，1，中国电信，2，中国网通，3，中国移动，4，中国联通
     */
    private Integer spid;

    /**
     * 名称
     */
    private String spname;

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
