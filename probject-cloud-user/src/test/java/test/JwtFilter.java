/*package com.zhangbin.cloud.conf;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.UnauthenticatedException;
import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.web.filter.authc.BasicHttpAuthenticationFilter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.extern.slf4j.Slf4j;

*//**
 * 自定义jwt过滤器来作为shiro的过滤器
 * 
 * @author Administrator
 *
 *//*
@Slf4j
public class JwtFilter extends BasicHttpAuthenticationFilter {

	@Override
	protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue)
			throws UnauthorizedException {
		// 判断请求的请求头是否带上 "Authorication"
		if(isLoginRequest(request, response)) {
			return true;
		}
		try {
			executeLogin(request, response);
			// 认证通过后执行授权
			HttpServletRequest req = (HttpServletRequest) request;
			System.out.println(SecurityUtils.getSubject().isAuthenticated());
			SecurityUtils.getSubject().checkPermission(req.getRequestURI());
		} catch (UnauthenticatedException e) {// 授权异常
			// return false;
			responseError(response, e.getMessage());
		} catch (UnauthorizedException e) {// 没有访问权限，访问异常
			responseError(response, "您暂无权限，请联系管理员");
		} catch (Exception e) {
			// return false;
			responseError(response, e.getMessage());
		}
		*//**
		 * UnsupportedTokenException:验证不通过，500 401，无Authorication头
		 * 
		 *//*
		return true;
	}

	@Override
	protected boolean executeLogin(ServletRequest request, ServletResponse response) throws Exception {
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		String token = httpServletRequest.getHeader("Authorication");
		JwtToken jwtToken = new JwtToken(token);
		// 提交给realm进行登入，如果错误他会抛出异常并被捕获
		getSubject(request, response).login(jwtToken);
		// 如果没有抛出异常则代表登入成功，返回true
		return true;
	}

	@Override
	protected boolean isLoginAttempt(ServletRequest request, ServletResponse response) {
		HttpServletRequest req = (HttpServletRequest) request;
		String token = req.getHeader("Authorication");
		return token != null;
	}

	*//**
	 * 将非法请求跳转到 /unauthorized/**
	 *//*
	private void responseError(ServletResponse response, String message) {
		try {
			HttpServletResponse httpServletResponse = (HttpServletResponse) response;
			// 设置编码，否则中文字符在重定向时会变为空字符串
			message = URLEncoder.encode(message, "UTF-8");
			httpServletResponse.sendRedirect("/unauthorized/" + message);
		} catch (IOException e) {
			log.error(e.getMessage());
		}
	}

	@Override
	protected boolean preHandle(ServletRequest request, ServletResponse response) throws Exception {
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		HttpServletResponse httpServletResponse = (HttpServletResponse) response;
		httpServletResponse.setHeader("Access-control-Allow-Origin", httpServletRequest.getHeader("Origin"));
		httpServletResponse.setHeader("Access-Control-Allow-Methods", "GET,POST,OPTIONS,PUT,DELETE");
		httpServletResponse.setHeader("Access-Control-Allow-Headers",
				httpServletRequest.getHeader("Access-Control-Request-Headers"));
		// 跨域时会首先发送一个option请求，这里我们给option请求直接返回正常状态
		if (httpServletRequest.getMethod().equals(RequestMethod.OPTIONS.name())) {
			httpServletResponse.setStatus(HttpStatus.OK.value());
			return false;
		}
		return super.preHandle(request, response);
	}

}
*/