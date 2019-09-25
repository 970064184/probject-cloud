package com.zhangbin.cloud.controller.system.resData;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
@ApiModel(value="权限列表返回实体")
@Data
public class AllAuthResp implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value="菜单id")
	private Long authId;
	
	@ApiModelProperty(value = "菜单图标")
	private String authLogo;
	
	@ApiModelProperty(value="菜单名称")
	private String authName;
	
	@ApiModelProperty(value="跳转url")
	private String authUrl;
	
	@ApiModelProperty(value="父id")
	private Long pid;
	
	@ApiModelProperty(value="菜单类型",notes="类型（1=导航，2=菜单，3=api，4=按钮）")
	private Integer authType;
	
	@ApiModelProperty(value="是否隐藏",notes="是否隐藏（0=否，1=是）")
	private Integer isHide;
}
