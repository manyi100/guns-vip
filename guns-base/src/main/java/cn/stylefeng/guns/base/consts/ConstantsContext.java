package cn.stylefeng.guns.base.consts;

import cn.stylefeng.guns.base.enums.CommonStatus;
import cn.stylefeng.guns.base.sms.AliyunSmsProperties;
import cn.stylefeng.roses.core.util.ToolUtil;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static cn.stylefeng.guns.base.consts.ConfigConstant.SYSTEM_CONSTANT_PREFIX;

/**
 * 系统常量的容器
 *
 * @author fengshuonan
 * @Date 2019-06-20 13:37
 */
@Slf4j
public class ConstantsContext {

    /**
     * 所有的常量，可以增删改查
     */
    private static Map<String, Object> CONSTNTS_HOLDER = new ConcurrentHashMap<>();

    /**
     * 添加系统常量
     */
    public static void putConstant(String key, Object value) {
        if (ToolUtil.isOneEmpty(key, value)) {
            return;
        }
        CONSTNTS_HOLDER.put(key, value);
    }

    /**
     * 删除常量
     */
    public static void deleteConstant(String key) {
        if (ToolUtil.isOneEmpty(key)) {
            return;
        }

        //如果是系统常量
        if (!key.startsWith(SYSTEM_CONSTANT_PREFIX)) {
            CONSTNTS_HOLDER.remove(key);
        }
    }

    /**
     * 获取系统常量
     */
    public static Map<String, Object> getConstntsMap() {
        return CONSTNTS_HOLDER;
    }

    /**
     * 获取验证码开关
     */
    public static Boolean getKaptchaOpen() {
        String gunsKaptchaOpen = (String) CONSTNTS_HOLDER.get("GUNS_KAPTCHA_OPEN");
        if (CommonStatus.ENABLE.getCode().equalsIgnoreCase(gunsKaptchaOpen)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 获取短信的配置
     */
    public static AliyunSmsProperties getAliyunSmsProperties() {
        String gunsSmsAccesskeyId = (String) CONSTNTS_HOLDER.get("GUNS_SMS_ACCESSKEY_ID");
        String gunsSmsAccesskeySecret = (String) CONSTNTS_HOLDER.get("GUNS_SMS_ACCESSKEY_SECRET");
        String gunsSmsSignName = (String) CONSTNTS_HOLDER.get("GUNS_SMS_SIGN_NAME");
        String gunsSmsLoginTemplateCode = (String) CONSTNTS_HOLDER.get("GUNS_SMS_LOGIN_TEMPLATE_CODE");
        String gunsSmsInvalidateMinutes = (String) CONSTNTS_HOLDER.get("GUNS_SMS_INVALIDATE_MINUTES");

        AliyunSmsProperties aliyunSmsProperties = new AliyunSmsProperties();
        aliyunSmsProperties.setAccessKeyId(gunsSmsAccesskeyId);
        aliyunSmsProperties.setAccessKeySecret(gunsSmsAccesskeySecret);
        aliyunSmsProperties.setSignName(gunsSmsSignName);
        aliyunSmsProperties.setLoginTemplateCode(gunsSmsLoginTemplateCode);
        aliyunSmsProperties.setInvalidateMinutes(Integer.valueOf(gunsSmsInvalidateMinutes));
        return aliyunSmsProperties;
    }

    /**
     * 获取管理系统名称
     */
    public static String getSystemName() {
        String systemName = (String) CONSTNTS_HOLDER.get("GUNS_SYSTEM_NAME");
        if (ToolUtil.isEmpty(systemName)) {
            log.error("系统常量存在空值！常量名称：GUNS_SYSTEM_NAME，采用默认名称：Guns快速开发平台");
            return "Guns快速开发平台";
        } else {
            return systemName;
        }
    }

    /**
     * 获取管理系统名称
     */
    public static String getDefaultPassword() {
        String defaultPassword = (String) CONSTNTS_HOLDER.get("GUNS_DEFAULT_PASSWORD");
        if (ToolUtil.isEmpty(defaultPassword)) {
            log.error("系统常量存在空值！常量名称：GUNS_DEFAULT_PASSWORD，采用默认密码：111111");
            return "111111";
        } else {
            return defaultPassword;
        }
    }

    /**
     * 获取管理系统名称
     */
    public static String getOAuth2UserPrefix() {
        String oauth2Prefix = (String) CONSTNTS_HOLDER.get("GUNS_OAUTH2_PREFIX");
        if (ToolUtil.isEmpty(oauth2Prefix)) {
            log.error("系统常量存在空值！常量名称：GUNS_OAUTH2_PREFIX，采用默认值：oauth2");
            return "oauth2";
        } else {
            return oauth2Prefix;
        }
    }

    /**
     * 获取顶部导航条是否开启
     */
    public static Boolean getDefaultAdvert() {
        String gunsDefaultAdvert = (String) CONSTNTS_HOLDER.get("GUNS_DEFAULT_ADVERT");
        if (ToolUtil.isEmpty(gunsDefaultAdvert)) {
            log.error("系统常量存在空值！常量名称：GUNS_DEFAULT_ADVERT，采用默认值：true");
            return true;
        } else {
            if (CommonStatus.ENABLE.getCode().equalsIgnoreCase(gunsDefaultAdvert)) {
                return true;
            } else {
                return false;
            }
        }
    }

    /**
     * 获取系统发布的版本号（防止css和js的缓存）
     */
    public static String getReleaseVersion() {
        String systemReleaseVersion = (String) CONSTNTS_HOLDER.get("GUNS_SYSTEM_RELEASE_VERSION");
        if (ToolUtil.isEmpty(systemReleaseVersion)) {
            log.error("系统常量存在空值！常量名称：systemReleaseVersion，采用默认值：guns");
            return ToolUtil.getRandomString(8);
        } else {
            return systemReleaseVersion;
        }
    }
}
