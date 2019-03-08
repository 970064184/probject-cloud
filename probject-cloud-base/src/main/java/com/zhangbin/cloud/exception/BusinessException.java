package com.zhangbin.cloud.exception;

import com.zhangbin.cloud.common.CodeEnum;

/**业务异常
 * @author admin
 *
 */
public class BusinessException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private CodeEnum codeEnum;
	
	private Object msg;

	public BusinessException(CodeEnum codeEnum, Object msg) {
		super();
		this.codeEnum = codeEnum;
		this.msg = msg;
	}
	
	
	public BusinessException(CodeEnum codeEnum) {
		super();
		this.codeEnum = codeEnum;
	}


	public CodeEnum getCodeEnum() {
		return codeEnum;
	}

	public void setCodeEnum(CodeEnum codeEnum) {
		this.codeEnum = codeEnum;
	}

	public Object getMsg() {
		return msg;
	}

	public void setMsg(Object msg) {
		this.msg = msg;
	}

}
