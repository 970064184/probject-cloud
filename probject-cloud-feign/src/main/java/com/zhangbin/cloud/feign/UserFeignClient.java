package com.zhangbin.cloud.feign;

import com.zhangbin.cloud.common.Dto;
import com.zhangbin.cloud.domain.system.TbUser;
import com.zhangbin.cloud.feign.resData.EditUserReq;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;

@FeignClient("microservice-provider-user")
public interface UserFeignClient {
	
	/**
	 * 根据用户名称查找用户信息
	 * @param userName
	 * @return
	 */
	@ApiOperation(value ="根据用户名称查找用户信息",notes = "根据用户名称查找用户信息")
	@GetMapping(value = "/findByUserName",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	Dto<TbUser>findByUserName(@RequestParam("userName")String userName);
	
	/**
	 * 根据用户id查找用户角色编码
	 */
	@ApiOperation(value ="根据用户id查找用户角色编码",notes = "根据用户id查找用户角色编码")
	@GetMapping(value = "/findRoleByUserId",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	Dto<List<String>> findRoleByUserId(@RequestParam("userId")Long userId);
	/**
	 * 根据用户id查找用户权限
	 * @param userId
	 * @return
	 */
	@ApiOperation(value ="根据用户id查找用户权限",notes = "根据用户id查找用户权限")
	@GetMapping(value = "/findAuthorityByUserId",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	Dto<List<String>> findAuthorityByUserId(@RequestParam("userId")Long userId);
	
	/**
	 * 修改用户信息
	 * @param addUserReq
	 * @return
	 */
	@ApiOperation(value="编辑用户",notes="编辑用户")
	@PostMapping(value="/editUser",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Dto<Long> editUser( @Valid @RequestBody EditUserReq editUserReq);
}
