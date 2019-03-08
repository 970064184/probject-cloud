package com.zhangbin.cloud.exception;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.zhangbin.cloud.common.CodeEnum;
import com.zhangbin.cloud.common.Dto;
import com.zhangbin.cloud.common.DtoUtils;

/**
 * 全局异常处理
 * 
 * @author admin
 *
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(BusinessException.class)
	public Object businessException(HttpServletRequest request,BusinessException e) {
		e.printStackTrace();
		return DtoUtils.returnError(e.getCodeEnum(), e.getMsg());
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Dto<Object> methodArgumentNotValidException(HttpServletRequest request, MethodArgumentNotValidException e) {
		e.printStackTrace();
		BindingResult bindingResult = e.getBindingResult();
		List<FieldError> allErrors = bindingResult.getFieldErrors();
		Map<String, String> map = new HashMap<>();
		for (FieldError fieldError : allErrors) {
			map.put(fieldError.getField(), fieldError.getDefaultMessage());
		}
		return DtoUtils.returnError(CodeEnum.SYSTEM_PARAM_CHECK_ERROR, map);
	}

	@ExceptionHandler(Exception.class)
	public Object globalExceptionHandle(HttpServletRequest request, Exception e) {
		e.printStackTrace();
		return DtoUtils.returnError(CodeEnum.WEB_SYSTEM_EXCEPTION, e.getMessage());
	}

}
