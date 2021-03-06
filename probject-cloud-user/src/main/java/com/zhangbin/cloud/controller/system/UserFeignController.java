package com.zhangbin.cloud.controller.system;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.zhangbin.cloud.common.Dto;
import com.zhangbin.cloud.common.DtoUtils;
import com.zhangbin.cloud.domain.system.TbUser;
import com.zhangbin.cloud.feign.UserFeignClient;
import com.zhangbin.cloud.feign.resData.EditUserReq;
import com.zhangbin.cloud.service.UserService;

import io.swagger.annotations.Api;

@Api(tags = "用户相关服务可调用接口API")
@RestController
public class UserFeignController implements UserFeignClient {

	@Autowired
	private UserService userService;

	@Override
	public Dto<TbUser> findByUserName(String userName) {
		return DtoUtils.returnSuccess(userService.findByUserName(userName));
	}

	@Override
	public Dto<List<String>> findRoleByUserId(Long userId) {
		return DtoUtils.returnSuccess(userService.findRoleByUserId(userId));
		
	}

	@Override
	public Dto<List<String>> findAuthorityByUserId(Long userId) {
		return DtoUtils.returnSuccess(userService.findAuthorityByUserId(userId));
	}
	
	@Override
	public Dto<Long> editUser(@Valid @RequestBody EditUserReq editUserReq) {
		Long userId = userService.editUser(editUserReq);
		return DtoUtils.returnSuccess(userId);
	}
	
}
