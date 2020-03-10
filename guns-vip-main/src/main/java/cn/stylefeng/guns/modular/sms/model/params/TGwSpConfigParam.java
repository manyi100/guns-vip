package cn.stylefeng.guns.modular.sms.model.params;

import lombok.Data;
import cn.stylefeng.roses.kernel.model.validator.BaseValidatingParam;
import java.util.Date;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>
 * 网关配置表
 * </p>
 *
 * @author yqy
 * @since 2019-10-31
 */
@Data
public class TGwSpConfigParam implements Serializable, BaseValidatingParam {

    private static final long serialVersionUID = 1L;


    /**
     * 主键ID
     */
    private Long spnumId;

    /**
     * 协议ID，1，SMPP，2，SMGP，3，CNGP，4，CMPP，5，SGIP
     */
    private Integer protocolId;

    /**
     * 运营商ID，1，电信，2，网通 3，移动 4，联通  (注意发送电信就填电信，移动 就选 移动)
     */
    private Integer spId;

    /**
     * 企业ID，0，管理员，1，2，3
     */
    private Integer entId;

    /**
     * 接入号IP
     */
    private String spnumIp;

    /**
     * 端口号
     */
    private Integer spnumPort;

    /**
     * SP号码
     */
    private String spnum;

    /**
     * 帐号
     */
    private String spnumBody;

    /**
     * 密码
     */
    private String spnumPass;

    /**
     * 发送速率
     */
    private Integer sendSpeed;

    /**
     * 余额
     */
    private Integer balance;

    /**
     * 单价，分
     */
    private Integer price;

    /**
     * 落地省份
     */
    private String province;

    /**
     * 通道数量
     */
    private Integer channelNum;

    /**
     * 用途：0,管理员，1，客户端
     */
    private Integer entmsnUse;

    /**
     * 网关标记
     */
    private String gwStation;

    /**
     * 屏蔽区域，格式如下：北京，南京，上海
     */
    private String blockarea;

    private String limitime;

    /**
     * 备注
     */
    private String remark;

    /**
     * 客户端IP
     */
    private String clientIp;

    /**
     * 版本号
     */
    private String version;

    /**
     * 状态0,可用，1，不可用
     */
    private Integer status;

    private Integer online;
    private Integer frequency;
    private Integer issignname;
    private Integer istemplate;
    /**
     * 提交时间
     */
    private Date submitdate;

    /**
     * 处理时间
     */
    private Date dealdate;

    @Override
    public String checkParam() {
        return null;
    }

}
