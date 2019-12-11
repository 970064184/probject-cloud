package com.zhangbin.cloud.utils;

import org.springframework.util.StringUtils;

import java.util.regex.Pattern;


public class Validator {
	/**
	 * 正则表达式：验证手机号
	 */
	public static final String REGEX_MOBILE = "^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$";
	/**
	 * 验证手机号码
	 * @param mobile
	 * @return
	 */
	public static boolean isMobile(String mobile) {
		if(StringUtils.isEmpty(mobile)) {
			return false;
		}
		boolean matches =Pattern.matches(REGEX_MOBILE, mobile);;
 		return matches;
	}
	
	public static void main(String[] args) {
		String mobile="13800013800";
		boolean matches = isMobile(mobile);
		System.out.println(matches);
	}
}
