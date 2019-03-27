package com.zhangbin.cloud.controller.system.resData;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(value="添加权限请求参数")
@Data
public class AddAuthReq {
	
	@ApiModelProperty(value="权限id")
	private Long authId;
	
	@ApiModelProperty(value = "权限图标")
	private String authLogo;
	
	@ApiModelProperty(value="权限名称")
	@NotNull
	private String authName;
	
	@ApiModelProperty(value="权限类型",notes="类型（1=导航，2=菜单，3=api，4=按钮）")
	private Integer authType;
	
	@ApiModelProperty(value="跳转url")
	private String authUrl;
	
	@ApiModelProperty(value="父id")
	private Long pId;
	
	@ApiModelProperty(value="权限排序")
	private Integer sort;
}
