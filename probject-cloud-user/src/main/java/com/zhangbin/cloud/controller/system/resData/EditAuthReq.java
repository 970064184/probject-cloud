package com.zhangbin.cloud.controller.system.resData;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@ApiModel(value="编辑权限请求参数")
@Data
public class EditAuthReq {

	@ApiModelProperty(value="权限id")
	@NotNull(message = "权限id不能为空")
	private Long authId;

	@ApiModelProperty(value = "权限图标")
	private String authLogo;

	@ApiModelProperty(value="权限名称")
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

