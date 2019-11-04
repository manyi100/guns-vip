package cn.stylefeng.guns.modular.sms.model.result;

import lombok.Data;
import java.util.Date;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>
 * 回执表
 * </p>
 *
 * @author yqy
 * @since 2019-10-31
 */
@Data
public class ReportResult implements Serializable {

    private static final long serialVersionUID = 1L;


    /**
     * 主键ID
     */
    private Long reportId;

    /**
     * 接入码
     */
    private String entityName;

    /**
     * Msgid
     */
    private String msgId;

    /**
     * 原Msgid和send表中msgid对应
     */
    private String srcmsgId;

    /**
     * 回执状态
     */
    private String stat;

    /**
     * 错误代码表
     */
    private String err;

    /**
     * 源号码
     */
    private String destid;

    /**
     * 目的号码
     */
    private String srcterminalid;

    /**
     * linkId
     */
    private String linkId;

    /**
     * serverid
     */
    private String serverid;

    /**
     * 状态0,未发送，1己发送
     */
    private Integer status;

    /**
     * 提交时间
     */
    private Date submitDate;

    /**
     * 处理时间
     */
    private Date dealDate;

}
