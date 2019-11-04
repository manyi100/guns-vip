package cn.stylefeng.guns.modular.sms.model.result;

import lombok.Data;
import java.util.Date;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>
 * 短信接收表
 * </p>
 *
 * @author yqy
 * @since 2019-10-31
 */
@Data
public class DeliverResult implements Serializable {

    private static final long serialVersionUID = 1L;


    /**
     * 主键ID
     */
    private Long deliverId;

    /**
     * 接入码
     */
    private String entityName;

    /**
     * Msgid
     */
    private String msgId;

    /**
     * 源号码
     */
    private String destid;

    /**
     * 目的号码
     */
    private String srcterminalid;

    /**
     * 上行内容
     */
    private String msgContent;

    /**
     * sequenceId
     */
    private Long sequenceId;

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
