package com.zhangbin.cloud.conf;

import org.apache.shiro.authc.AuthenticationToken;

/**自定义jwt token
 * @author Administrator
 *
 */
public class JwtToken implements AuthenticationToken {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String token;
	
	public JwtToken() {
		super();
	}

	public JwtToken(String token) {
		super();
		this.token = token;
	}

	@Override
	public Object getPrincipal() {
		return token;
	}

	@Override
	public Object getCredentials() {
		return token;
	}

}
