package com.zhangbin.cloud.controller.system.resData;

import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
@ApiModel("角色列表")
@Data
public class AllRoleResp {
	
	@ApiModelProperty(value="角色id")
	private Long roleId;
	
	@ApiModelProperty(value="创建时间")
	private Date created;
	
	@ApiModelProperty(value="角色描述")
	private String roleDesc;
	
	@ApiModelProperty(value="角色名称")
	private String roleName;
	
	@ApiModelProperty(value="角色编码")
	private String roleCode;
	
	@ApiModelProperty(value="更新时间")
	private Date updated;

}
