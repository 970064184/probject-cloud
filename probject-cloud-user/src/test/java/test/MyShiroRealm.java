/*package com.zhangbin.cloud.conf;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.collections.CollectionUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zhangbin.cloud.repository.AuthorityRepository;
import com.zhangbin.cloud.repository.RoleRepository;
import com.zhangbin.cloud.repository.TbRolesMenuRepository;
import com.zhangbin.cloud.repository.UserRoleRepository;
import com.zhangbin.cloud.service.UserService;

*//**自定义权限匹配和账号密码匹配
 * @author admin
 *
 *//*
@Component
public class MyShiroRealm extends AuthorizingRealm {
	
	public static final ThreadLocal<Long> THREADLOCAL = new ThreadLocal<>();
	
	@Autowired
	private UserService userService;
	@Autowired
	private UserRoleRepository userRoleRepository;
	@Autowired 
	private RoleRepository roleRepository;
	@Autowired
	private TbRolesMenuRepository tbRolesMenuRepository;
	@Autowired
	private AuthorityRepository authorityRepository;
	
	
	*//**
     * 必须重写此方法，不然会报错
     *//*
    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JwtToken;
    }

	
	*//**
	 * Authorization(授权)：访问控制。比如某个用户是否具有某个操作的使用权限
	 * Session Management（会话管理）：特定于用户的会话管理，甚至在非web或EJB应用程序
	 * Cryptography（加密）：在对数据源使用加密算法加密的同时，保证易于使用
	 * 授权访问控制，证明该用户是否允许进行当前操作，如访问某个链接，某个资源文件
	 *//*
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		System.out.println("权限配置-->MyShiroRealm.doGetAuthorizationInfo()");
		String token =(String) principals.getPrimaryPrincipal();
		System.out.println(token);
		Long userId = JwtUtil.getUserId(token);
		System.out.println(userId);
		//利用登录的用户信息来查询当前登录用户的角色或权限
		Set<String> roles = new HashSet<>();
		Set<String> permissions = new HashSet<>();
		//获得该用户角色
		List<Long> roleId = userRoleRepository.findByUserId(userId);
		if(!CollectionUtils.isEmpty(roleId)) {
			List<String> roleCodeList = roleRepository.findByRoleIdIn(roleId);
			roles.addAll(roleCodeList);
			//每个角色拥有默认的权限
			List<Long> authList = tbRolesMenuRepository.findByRoleIdIn(roleId);
			if(!CollectionUtils.isEmpty(authList)) {
				List<String> authUrlList = authorityRepository.findByAuthIdIn(authList);
				permissions.addAll(authUrlList);
			}
			//每个用户可以设置的新的权限
			
			//需要将role,permission封装到set作为info.setRoles()，info.setStringPermissions()的参数
			if(1 == userId) {
//			roles.add("admin");
				permissions.add("/test");
			}
		}
		//创建SimpleAuthorizationInfo，并设置其roles属性
		SimpleAuthorizationInfo authenticationInfo = new SimpleAuthorizationInfo();
		authenticationInfo.setRoles(roles);
		authenticationInfo.setStringPermissions(permissions);
		return authenticationInfo;
	}
	*//**
	 * Authentication(认证)：用户身份识别，通常都被称为用户“登录”
	 * 验证用户身份
	 *//*
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		System.out.println("————身份认证方法————");
		//获取用户的输入的账号
		String jwtToken = (String) token.getPrincipal();
		System.out.println(jwtToken);
		Long userId = JwtUtil.getAppUID(jwtToken);
		THREADLOCAL.set(userId);
		SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
				jwtToken,
				jwtToken,
				getName()
				);
		return authenticationInfo;
		//获取用户的输入的账号
		System.out.println("MyShiroRealm.doGetAuthenticationInfo()");
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
		return authenticationInfo;
	}

}
*/