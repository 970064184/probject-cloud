package com.zhangbin.cloud.controller.system.resData;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author admin
 *
 */
@ApiModel(value="分配权限请求参数")
@Data
public class ConfigAuthReq {
	
	@ApiModelProperty(value="角色id")
	private Long roleId;
	
	@ApiModelProperty(value="一组权限id")
	private List<Long> authId;
}
