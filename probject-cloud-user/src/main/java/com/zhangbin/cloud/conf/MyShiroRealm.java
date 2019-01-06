package com.zhangbin.cloud.conf;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.zhangbin.cloud.service.UserService;

/**自定义权限匹配和账号密码匹配
 * @author admin
 *
 */
public class MyShiroRealm extends AuthorizingRealm {
	
	@Autowired
	private UserService userService;
	
	
	/**
	 * Authorization(授权)：访问控制。比如某个用户是否具有某个操作的使用权限
	 * Session Management（会话管理）：特定于用户的会话管理，甚至在非web或EJB应用程序
	 * Cryptography（加密）：在对数据源使用加密算法加密的同时，保证易于使用
	 * 授权访问控制，证明该用户是否允许进行当前操作，如访问某个链接，某个资源文件
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		System.out.println("权限配置-->MyShiroRealm.doGetAuthorizationInfo()");
		return null;
	}
	/**
	 * Authentication(认证)：用户身份识别，通常都被称为用户“登录”
	 * 验证用户身份
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		System.out.println("MyShiroRealm.doGetAuthenticationInfo()");
		//获取用户的输入的账号
		String jwtToken = (String) token.getPrincipal();
		System.out.println(jwtToken);
		Long userId = JwtUtil.getAppUID(jwtToken);
		SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
				jwtToken,
				jwtToken,
				getName()
				);
		return authenticationInfo;
		//获取用户的输入的账号
		/*System.out.println("MyShiroRealm.doGetAuthenticationInfo()");
		//获取用户的输入的账号
		String userName = (String) token.getPrincipal();
		System.out.println(userName);
		TbUser tbUser = userService.findByUserName(userName);
		if(null == tbUser) {
			return null;
		}
//		Long userId = JwtUtil.getAppUID(token.getCredentials());
		String salt = "123";
		SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
				tbUser,
				tbUser.getUserPwd(),
				ByteSource.Util.bytes(salt),
				getName()
				);
		return authenticationInfo;*/
	}

}
