package com.zhangbin.cloud.common;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**统一结果返回格式
 * @author admin
 *
 */
@ApiModel("统一结果返回值")
@Data
public class Dto {
	
	@ApiModelProperty("状态码")
	private String code ="200";
	
	@ApiModelProperty("详细信息")
	private String msg;
	
	@ApiModelProperty("返回值")
	private Object data;
	
	/**
	 * 设置详细信息及相关状态码
	 * @param codeEnum
	 */
	public void setMsg(CodeEnum codeEnum) {
		this.code = codeEnum.getCode();
		this.msg = codeEnum.getDesc();
	}
	/**
	 * 对象转换成json字符串
	 * @return
	 */
	public String toJson() {
		return JSON.toJSONString(this, SerializerFeature.DisableCircularReferenceDetect);
	}
}
