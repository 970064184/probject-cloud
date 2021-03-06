package com.zhangbin.cloud.common;

/**返回值相关方法
 * @author admin
 *
 */
public class DtoUtils {
	/**
	 * 成功，有参返回
	 * @return
	 */
	public static <T>Dto<T> isSuccess(CodeEnum codeEnum,T data) {
		Dto<T> dto = new Dto<>();
		dto.setMsg(codeEnum);
		dto.setData(data);
		return dto;
	}
	/**
	 * 成功，无参返回
	 * @return
	 */
	public static <T>Dto<T> isSuccess(CodeEnum codeEnum) {
		Dto<T> dto = new Dto<>();
		dto.setMsg(codeEnum);
		return dto;
	}
	/**
	 * 成功，有参返回
	 * @param data
	 * @return
	 */
	public static String isSuccess(Object data) {
		Dto dto = new Dto();
		dto.setMsg(CodeEnum.SUCCESS);
		dto.setData(data);
		return dto.toJson();
	}
	/**
	 * 成功，有参返回
	 * @param <T>
	 * @param data
	 * @return
	 */
	public static <T> Dto<T> returnSuccess(T data) {
		Dto<T> dto = new Dto<>();
		dto.setMsg(CodeEnum.SUCCESS);
		dto.setData(data);
		return dto;
	}
	/**
	 * 系统异常，无参返回
	 * @return
	 */
	public static String isError() {
		Dto dto = new Dto();
		dto.setMsg(CodeEnum.WEB_SYSTEM_EXCEPTION);
		return dto.toJson();
	}
	/**
	 * 系统异常，有参返回
	 * @return
	 */
	public static String isError(Object data) {
		Dto dto = new Dto();
		dto.setMsg(CodeEnum.WEB_SYSTEM_EXCEPTION);
		dto.setData(data);
		return dto.toJson();
	}
	/**
	 * 异常信息，无参返回
	 * @param codeEnum
	 * @param data
	 * @return
	 */
	public static String isError(CodeEnum codeEnum) {
		Dto dto  = new Dto();
		dto.setMsg(codeEnum);
		return dto.toJson();
	}
	
	/**
	 * 异常信息，无参返回
	 * @param object
	 * @param data
	 * @return
	 */
	public static <T> Dto<T> returnError(CodeEnum codeEnum,Object...args) {
		Dto<T> dto  = new Dto<>();
		dto.setMsg(codeEnum,args);
		return dto;
	}
	/**
	 * 异常信息，有参返回
	 * @param codeEnum
	 * @param data
	 * @return
	 */
	public static String isError(CodeEnum codeEnum,Object data) {
		Dto dto  = new Dto();
		dto.setMsg(codeEnum);
		dto.setData(data);
		return dto.toJson();
	}
	
}
