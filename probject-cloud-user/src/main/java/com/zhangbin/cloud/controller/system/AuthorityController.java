package com.zhangbin.cloud.controller.system;

import com.zhangbin.cloud.common.*;
import com.zhangbin.cloud.controller.system.resData.AddAuthReq;
import com.zhangbin.cloud.controller.system.resData.AllAuthResp;
import com.zhangbin.cloud.controller.system.resData.EditAuthReq;
import com.zhangbin.cloud.service.AuthorityService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Api(tags="权限相关的接口")
@RestController
@RequestMapping("/auth")
public class AuthorityController {
	
	@Autowired
	private AuthorityService authorityService;
	
	@ApiOperation(value = "分页查询所有角色", notes = "角色列表数据")
	@PostMapping(value = "/findAllAuthByPage", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Dto<PageData<AllAuthResp>> findAllAuthByPage(@RequestBody PageBean pageBean) {
		PageData<AllAuthResp> data = authorityService.findAllAuthByPage(pageBean);
		return DtoUtils.returnSuccess(data);
	}
	
	@ApiOperation(value = "添加权限", notes = "添加权限")
	@PostMapping(value = "/addAuth", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Dto<Long> addAuth(@RequestBody @Valid AddAuthReq addAuthReq) {
		Long userId = authorityService.addAuth(addAuthReq);
		return DtoUtils.returnSuccess(userId);
	}
	
	@ApiOperation(value = "删除权限", notes = "删除权限")
	@GetMapping(value = "/delAuth/{authId}")
	public Dto<Object> delAuth(@PathVariable("authId") Long authId) {
		authorityService.delAuth(authId);
		return DtoUtils.returnError(CodeEnum.SUCCESS);
	}

	@ApiOperation(value = "编辑权限", notes = "编辑权限")
	@PostMapping(value = "/editAuth", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Dto<Long> editAuth(@RequestBody @Valid EditAuthReq editAuthReq) {
		Long userId = authorityService.editAuth(editAuthReq);
		return DtoUtils.returnSuccess(userId);
	}

}
