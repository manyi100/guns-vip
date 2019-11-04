package cn.stylefeng.guns.modular.sms.model.result;

import lombok.Data;
import java.util.Date;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>
 * 短信协议配置表
 * </p>
 *
 * @author yqy
 * @since 2019-10-31
 */
@Data
public class TcGwProtocolResult implements Serializable {

    private static final long serialVersionUID = 1L;


    /**
     * 协议ID，1，SMPP，2，SMGP，3，CNGP，4，CMPP，5，SGIP
     */
    private Integer protocolid;

    /**
     * 协议名称
     */
    private String protocolname;

    /**
     * 中文名称
     */
    private String chsname;

    /**
     * 备注
     */
    private String remark;

    /**
     * 添加时间
     */
    private Date adddate;

}
