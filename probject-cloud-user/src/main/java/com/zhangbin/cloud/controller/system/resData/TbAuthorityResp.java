package com.zhangbin.cloud.controller.system.resData;

import java.io.Serializable;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(value="菜单栏返回实体")
@Data
public class TbAuthorityResp implements Serializable {
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
	
	@ApiModelProperty(value="是否选中")
	private boolean check = false;
	
	@ApiModelProperty(value="子菜单")
	private List<TbAuthorityResp> children;
}