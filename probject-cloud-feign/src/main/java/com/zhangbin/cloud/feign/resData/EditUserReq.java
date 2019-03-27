package com.zhangbin.cloud.feign.resData;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.Email;

import com.zhangbin.cloud.utils.IsMobile;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel("添加用户请求参数")
@Data
public class EditUserReq {
	
	@ApiModelProperty(value="用户id")
	private Long userId;
	
	@ApiModelProperty(value="出生地")
	private String birthAddress;

	@ApiModelProperty(value="出生年月")
	@Past
	private Date birthday;
	
	@ApiModelProperty(value="血型")
	private Integer bloodType;

	@ApiModelProperty(value="教育程度")
	private Integer eduction;

	@ApiModelProperty(value="居住地")
	private String liveAddress;
	
	@ApiModelProperty(value="性别")
	private Integer sex;

	@ApiModelProperty(value="电子邮箱")
	@Email
	private String userEmail;

	@ApiModelProperty(value="用户头像")
	private String userLogo;
	
	@ApiModelProperty(value="用户名称")
	@NotNull(message="用户名称不能为空")
	private String userName;
	
	@ApiModelProperty(value="用户手机号码")
	@IsMobile
	private String userPhone;
	
	@ApiModelProperty(value="当前职业")
	private String work;
}
