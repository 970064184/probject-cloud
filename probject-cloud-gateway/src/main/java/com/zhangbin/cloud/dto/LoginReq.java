package com.zhangbin.cloud.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;

import javax.validation.constraints.NotNull;

/**登录接口的请求参数
 * @author admin
 *
 */
@ApiModel("登录接口的请求参数")
@Data
@Getter
public class LoginReq {
	
	@ApiModelProperty(value="用户名",required=true)
	@NotNull(message="用户名不能为空")
	private String username;
	
	@ApiModelProperty(value="密码",required=true)
	@NotNull(message="密码不能为空")
	private String password;

}
