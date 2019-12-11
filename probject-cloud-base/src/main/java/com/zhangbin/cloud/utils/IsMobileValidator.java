package com.zhangbin.cloud.utils;

import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


/**手机格式验证注解实现类
 * @author admin
 *
 */
public class IsMobileValidator implements ConstraintValidator<IsMobile, String>{
	
	private  boolean required = false;
	
	@Override
	public void initialize(IsMobile constraintAnnotation) {
		required = constraintAnnotation.required();
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if(StringUtils.isEmpty(value)) {
			return true;
		}
		return Validator.isMobile(value);
	}

}
