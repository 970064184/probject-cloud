package com.zhangbin.cloud.controller.system.resData;

import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel("用户列表")
@Data
public class AllUserResp {
	
	@ApiModelProperty(value="用户id")
	private Long userId;
	
	@ApiModelProperty(value="出生地")
	private String birthAddress;

	@ApiModelProperty(value="出生年月")
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
	private String userEmail;

	@ApiModelProperty(value="用户头像")
	private String userLogo;
	
	@ApiModelProperty(value="用户名称")
	private String userName;
	
	@ApiModelProperty(value="用户手机号码")
	private String userPhone;

	@ApiModelProperty(value="当前职业")
	private String work;
	
	@ApiModelProperty(value="注册时间")
	private Date created;
}
