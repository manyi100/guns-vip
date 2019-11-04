package cn.stylefeng.guns.sys.core.shiro.oauth;

import lombok.Data;
import org.apache.shiro.authc.UsernamePasswordToken;

/**
 * token登陆类型
 *
 * @author fengshuonan
 * @Date 2019/6/9 17:25
 */
@Data
public class OAuthToken extends UsernamePasswordToken {

    private LoginType type;

    /**
     * 免密登录
     */
    public OAuthToken(String username) {
        super(username, "", false, null);
        this.type = LoginType.OAUTH_TOKEN;
    }

    /**
     * 账号密码登录
     */
    public OAuthToken(String username, char[] pwd) {
        super(username, pwd, false, null);
        this.type = LoginType.PASSWORD;
    }
}
