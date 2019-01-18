package com.zhangbin.cloud.controller;

import java.io.UnsupportedEncodingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.zhangbin.cloud.common.CodeEnum;
import com.zhangbin.cloud.common.Dto;
import com.zhangbin.cloud.common.DtoUtils;
import com.zhangbin.cloud.domain.system.TbUser;
import com.zhangbin.cloud.dto.LoginReq;
import com.zhangbin.cloud.service.UserService;
import com.zhangbin.cloud.util.JwtUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @author admin
 *
 */
@Api(tags = "登录相关接口")
@RestController
public class LoginController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping(value="/notLogin")
	public Dto<String> notLogin(){
		return DtoUtils.returnError(CodeEnum.SYSTEM_LOGIN_EXCEPTION);
	}
	
	@ApiOperation(value = "登录接口", notes = "登录授权接口")
	@PostMapping(value = "/login", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Dto<Object> login(@RequestBody LoginReq loginReq) {
		System.out.println("登录接口：" + loginReq);
		TbUser tbUser = userService.findByUserName(loginReq.getUsername());
		if(tbUser == null) {
			return DtoUtils.returnError(CodeEnum.SYSTEM_USERNAME_ISNOTEXIST);
		}
		if(!tbUser.getUserPwd().equals(loginReq.getPassword())) {
			return DtoUtils.returnError(CodeEnum.SYSTEM_USERNAME_ISNOTEXIST);
		}
		try {
			String jwtToken = JwtUtil.createToken(tbUser.getUserId());
			return DtoUtils.isSuccess(CodeEnum.SYSTEM_LOGIN_SUCCESS,jwtToken);
		} catch (Exception e) {
			e.printStackTrace();
			return DtoUtils.returnError(CodeEnum.SYSTEM_LOGIN_EXCEPTION);
		}
/*		// shiro：认证、授权、加密、会话管理、与web集成、缓存等
		// Authentication：身份认证/登录
		// subject：代表了当前用户，
		Subject subject = SecurityUtils.getSubject();
		Session session = subject.getSession();
//		session.setTimeout(60000);
		long timeout = session.getTimeout();//1800000
		Date startTimestamp = session.getStartTimestamp();
		System.out.println("session:"+session.getId()+";timeout:"+timeout+";"+startTimestamp);
		System.out.println("身份认证 subject：" + subject);
		// 判断当前用户是否已经被认证
		boolean authenticated = subject.isAuthenticated();
//		if(!authenticated) {
			UsernamePasswordToken token = new UsernamePasswordToken(loginReq.getUserName(), loginReq.getUserPwd());
			try {
				subject.login(token);
				TbUser tbUser = (TbUser) subject.getPrincipal();
				String jwtToken = JwtUtil.createToken(tbUser.getUserId());
				return DtoUtils.isSuccess(CodeEnum.SYSTEM_LOGIN_SUCCESS,jwtToken);
			} catch (AuthenticationException e) {
				e.printStackTrace();
				return DtoUtils.returnError(CodeEnum.SYSTEM_LOGIN_EXCEPTION);
			} catch (Exception e) {
				return DtoUtils.returnError(CodeEnum.WEB_SYSTEM_EXCEPTION);
			}
//		}
*/	}
	/**
	 * 
	 * @param message
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	@GetMapping(path = "/unauthorized/{message}")
    public Dto<Object> unauthorized(@PathVariable String message) throws UnsupportedEncodingException {
        return DtoUtils.returnError(CodeEnum.SYSTEM_LOGIN_EXCEPTION,message);
    }
}
