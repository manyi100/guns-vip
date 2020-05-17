package cn.stylefeng.guns.modular.sms.model.params;

import lombok.Data;
import cn.stylefeng.roses.kernel.model.validator.BaseValidatingParam;

import java.time.LocalDateTime;
import java.util.Date;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>
 * 发送表
 * </p>
 *
 * @author yqy
 * @since 2019-10-31
 */
@Data
public class SendParam implements Serializable, BaseValidatingParam {

    private static final long serialVersionUID = 1L;


    /**
     * 主键ID
     */
    private Long taskId;

    /**
     * 内容
     */
    private String content;

    /**
     * 源号码
     */
    private String srcId;

    /**
     * 目的号码
     */
    private String destterminalId;

    /**
     * 接入码
     */
    private String entityName;

    /**
     * Msgid
     */
    private String msgId;

    /**
     * 网关返回状态
     */
    private Integer result;

    /**
     * 网关返回序列号
     */
    private Integer sequenceid;

    /**
     * linkId
     */
    private String linkId;

    /**
     * 接入号
     */
    private String msgsrc;

    /**
     * 运营商ID
     */
    private Integer spid;

    /**
     * 省份
     */
    private String province;

    /**
     * 城市
     */
    private String city;

    /**
     * 区号
     */
    private String areacode;

    /**
     * 状态 0 未发送，己发送
     */
    private Integer status;

    /**
     * 发送网关
     */
    private String entityid;

    /**
     * 真实网关返回id
     */
    private String realmsgid;

    /**
     * 真实网关返回状态
     */
    private Integer realresult;

    /**
     * 提交时间
     */
    private Date submitDate;

    /**
     * 处理时间
     */
    private Date sendDate;

    @Override
    public String checkParam() {
        return null;
    }

}
