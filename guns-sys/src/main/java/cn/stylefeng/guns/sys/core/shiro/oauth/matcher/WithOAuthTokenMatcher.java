package cn.stylefeng.guns.sys.core.shiro.oauth.matcher;

import cn.stylefeng.guns.sys.core.shiro.oauth.LoginType;
import cn.stylefeng.guns.sys.core.shiro.oauth.OAuthToken;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;

/**
 * 针对旧的shiro密码校验的拓展（带oauth token的登录校验）
 *
 * @author fengshuonan
 * @Date 2019/6/9 19:25
 */
public class WithOAuthTokenMatcher extends HashedCredentialsMatcher {

    public WithOAuthTokenMatcher() {
    }

    public WithOAuthTokenMatcher(String hashAlgorithmName) {
        super(hashAlgorithmName);
    }

    @Override
    public boolean doCredentialsMatch(AuthenticationToken authcToken, AuthenticationInfo info) {

        if (authcToken instanceof OAuthToken) {

            //如果是oauth token登录，直接跳过密码校验
            OAuthToken oAuthToken = (OAuthToken) authcToken;
            if (oAuthToken.getType().equals(LoginType.OAUTH_TOKEN)) {
                return true;
            } else {
                return false;
            }

        } else {

            //不是免密登录，调用父类的方法
            return super.doCredentialsMatch(authcToken, info);
        }


    }
}
