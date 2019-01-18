package com.zhangbin.cloud.conf;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.ShiroException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.zhangbin.cloud.common.CodeEnum;
import com.zhangbin.cloud.common.Dto;
import com.zhangbin.cloud.common.DtoUtils;

/**全局异常处理
 * @author admin
 *
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(ShiroException.class)
	public Dto<Object> shiroExceptionHandle(HttpServletRequest request,ShiroException e){
		return DtoUtils.returnError(CodeEnum.SYSTEM_AUTHENTICATIONTOKEN_EXCEPTION,e.getMessage());
	}
	
	@ExceptionHandler(Exception.class)
	public Object globalExceptionHandle(HttpServletRequest request, Exception e){
		e.printStackTrace();
		return DtoUtils.returnError(CodeEnum.WEB_SYSTEM_EXCEPTION,e.getMessage());
	}
	
}
