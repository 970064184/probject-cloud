package com.zhangbin.cloud.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.zhangbin.cloud.common.CodeEnum;
import com.zhangbin.cloud.common.DtoUtils;
import com.zhangbin.cloud.dto.LoginReq;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @author admin
 *
 */
@Api(tags = "登录相关接口")
@RestController
public class LoginController {

	@ApiOperation(value = "登录接口", notes = "登录授权接口")
	@PostMapping(value = "/login", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public String login(@RequestBody LoginReq loginReq) {
		System.out.println("登录接口：" + loginReq);
		// shiro：认证、授权、加密、会话管理、与web集成、缓存等
		// Authentication：身份认证/登录
		// subject：代表了当前用户，
		Subject subject = SecurityUtils.getSubject();
		System.out.println("身份认证 subject：" + subject);
		// 判断当前用户是否已经被认证
		boolean authenticated = subject.isAuthenticated();
		UsernamePasswordToken token = new UsernamePasswordToken(loginReq.getUserName(), loginReq.getUserPwd());
		try {
			subject.login(token);
		} catch (AuthenticationException e) {
			return DtoUtils.isError(CodeEnum.WEB_SYSTEM_EXCEPTION);
		} catch (Exception e) {
		}
		return DtoUtils.isSuccess();
	}
}
