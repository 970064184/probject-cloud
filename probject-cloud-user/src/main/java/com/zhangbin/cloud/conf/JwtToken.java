package com.zhangbin.cloud.conf;

import org.apache.shiro.authc.AuthenticationToken;

import lombok.AllArgsConstructor;
import lombok.Data;

/**自定义jwt token
 * @author Administrator
 *
 */
@AllArgsConstructor
@Data
public class JwtToken implements AuthenticationToken {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String token;

	@Override
	public Object getPrincipal() {
		return token;
	}

	@Override
	public Object getCredentials() {
		return token;
	}

}
