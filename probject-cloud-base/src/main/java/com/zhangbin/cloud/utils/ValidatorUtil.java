package com.zhangbin.cloud.utils;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import com.zhangbin.cloud.common.CodeEnum;
import com.zhangbin.cloud.exception.BusinessException;

public class ValidatorUtil {

	/**
	 * 请求体校验
	 * 
	 * @param bindingResult
	 * @throws Exception
	 */
	public static void requesBodyCheck(BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			List<FieldError> allErrors = bindingResult.getFieldErrors();
			Map<String, String> map = new HashMap<>();
			for (FieldError fieldError : allErrors) {
				map.put(fieldError.getField(), fieldError.getDefaultMessage());
			}
			throw new BusinessException(CodeEnum.SYSTEM_PARAM_CHECK_ERROR, map);
		}
	}

	/**
	 * 校验实体参数，并返回校验不通过的字段和描述
	 * 
	 * @param t
	 * @return
	 * @throws Exception
	 */
	public static Map<String, String> validatorParams(Object t) {
		Set<ConstraintViolation<Object>> validResult = Validation.buildDefaultValidatorFactory().getValidator()
				.validate(t);
		Map<String, String> map = new HashMap<>();
		if (null != validResult && validResult.size() > 0) {
			for (Iterator<ConstraintViolation<Object>> iterator = validResult.iterator(); iterator.hasNext();) {
				ConstraintViolation<Object> constraintViolation = (ConstraintViolation<Object>) iterator.next();
				if (!StringUtils.isEmpty(constraintViolation.getMessage())) {
					map.put(constraintViolation.getPropertyPath().toString(), constraintViolation.getMessage());
				}
			}
		}
		return map;
	}

	/**
	 * 接收一个List集合校验
	 * 
	 * @param <T>
	 * @param list
	 */
	public static <T> void validationData(List<T> list) {
		if (!CollectionUtils.isEmpty(list)) {
			list.forEach((l) -> {
				Map<String, String> validatorParams = validatorParams(l);
				if (!validatorParams.isEmpty())
					throw new BusinessException(CodeEnum.SYSTEM_PARAM_CHECK_ERROR, validatorParams);
			});
		}
	}
}
