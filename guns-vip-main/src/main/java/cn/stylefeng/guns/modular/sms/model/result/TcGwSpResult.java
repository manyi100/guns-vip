package cn.stylefeng.guns.modular.sms.model.result;

import lombok.Data;
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
public class TcGwSpResult implements Serializable {

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

}
