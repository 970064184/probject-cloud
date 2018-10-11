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
	
	SUCCESS("成功","200"),
	
	WEB_SYSTEM_EXCEPTION("系统异常","SWEB500");
	
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
