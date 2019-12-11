package com.zhangbin.cloud.dto;

import com.zhangbin.cloud.domain.system.TbUser;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Setter;

@ApiModel("登录接口返回参数")
@Data
@Setter
@AllArgsConstructor
public class LoginResp {
	
	@ApiModelProperty(value="认证token")
	private String auth;
	
	@ApiModelProperty(value="用户信息")
	private TbUser user;

}
