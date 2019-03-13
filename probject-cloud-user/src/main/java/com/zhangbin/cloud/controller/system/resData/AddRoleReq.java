package com.zhangbin.cloud.controller.system.resData;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel("添加角色请求参数")
@Data
public class AddRoleReq {
	
	@ApiModelProperty(value="角色id")
	private Long roleId;
	
	@ApiModelProperty(value="角色描述")
	private String roleDesc;
	
	@ApiModelProperty(value="角色名称")
	@NotNull
	private String roleName;
	
	@ApiModelProperty(value="角色编码")
	private String roleCode;
	
	@ApiModelProperty(value="角色排序")
	private Integer sort;

}
