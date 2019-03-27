package com.zhangbin.cloud.common;

/**统一状态码及对应的返回信息
 * 
 * 1. 系统异常代码由7位组成， 规则为：S+3位系统代码+3位数字编码，如：SAPV001   服务调用超时
 * 2. 业务异常代码由7位代码组成，规则为：B+3位系统代码+3位数字， 如BAPV000   请求参数为空
 * 3. enum常量命名格式为：模块代码+‘_’+异常变量，异常变量含义与中文一致，命名含义清晰，见字识义
 * 4. 错误代码按模块连续编码，不同模块之间起始位数字不一样
 * @author admin
 *
 */
public enum CodeEnum {
	
	SUCCESS("200","成功"),
	
	SYSTEM_LOGIN_SUCCESS("S200","欢迎登录"),
	
	SYSTEM_AUTHENTICATIONTOKEN_EXCEPTION("403","访问异常：%s"),
	
	SYSTEM_LOGIN_EXCEPTION("401","访问异常：%s"),
	
	SYSTEM_UNAUTHENTICATED_EXCEPTION("403","您没有权限，请联系管理员：%s"),
	
	SYSTEM_USERNAME_ISNOTEXIST("S404","用户不存在"),
	
	SYSTEM_PARAM_CHECK_ERROR("S405","参数校验失败:%s"),
	
	SYSTEM_EXCEL_IMPORT_ERROR("S406","请使用正确的excel模板"),
	
	WEB_SYSTEM_EXCEPTION("BWEB500","系统异常：%s"),
	
	USER_USERNAME_ISEXIST("BUSER600","用户名已存在"),
	
	USER_USERPHONE_ISEXIST("BUSER601","手机号码已注册"),
	
	USER_IMPORT_ERROR("BUSER602","导入用户失败：%s"),
	
	USER_USERNAME_IN_ISEXIST("BUSER603","用户名已存在:%s"),
	
	USER_USERPHONE_IN_ISEXIST("BUSER604","手机号码已注册:%s"),
	
	USER_ROLENAME_IN_ISEXIST("BUSER605","角色名称已存在"),
	
	USER_AUTHNAME_IN_ISEXIST("BUSER606","权限名称已存在"),
	
	USER_ROLEID_CANNOT_EXIST("BUSER607","角色ID不存在"),
	
	USER_AUTHID_CANNOT_EXIST("BUSER608","权限ID不存在或已下线"),
	
	COMMON_FILE_ERROR("BCOMMON700","文件上传失败:%s");
	
	
	
	private String code;
	
	private String desc;
	
	private CodeEnum(String code, String desc) {
		this.code = code;
		this.desc = desc;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
	
}
