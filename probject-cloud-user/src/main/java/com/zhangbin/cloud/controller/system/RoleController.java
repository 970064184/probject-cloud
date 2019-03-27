package com.zhangbin.cloud.controller.system;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zhangbin.cloud.common.CodeEnum;
import com.zhangbin.cloud.common.Dto;
import com.zhangbin.cloud.common.DtoUtils;
import com.zhangbin.cloud.common.PageBean;
import com.zhangbin.cloud.common.PageData;
import com.zhangbin.cloud.controller.system.resData.AddRoleReq;
import com.zhangbin.cloud.controller.system.resData.AllRoleResp;
import com.zhangbin.cloud.controller.system.resData.ConfigAuthReq;
import com.zhangbin.cloud.controller.system.resData.TbAuthorityResp;
import com.zhangbin.cloud.service.RoleService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags="角色相关的接口")
@RestController
@RequestMapping("/role")
public class RoleController {
	
	@Autowired
	private RoleService roleService;
	
	@ApiOperation(value = "分页查询所有角色", notes = "角色列表数据")
	@PostMapping(value = "/findAllRoleByPage", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Dto<PageData<AllRoleResp>> findAllRoleByPage(@RequestBody PageBean pageBean) {
		PageData<AllRoleResp> data = roleService.findAllRoleByPage(pageBean);
		return DtoUtils.returnSuccess(data);
	}
	
	@ApiOperation(value = "添加角色", notes = "添加角色")
	@PostMapping(value = "/addRole", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Dto<Long> addRole(@RequestBody @Valid AddRoleReq addRoleReq) {
		Long roleId = roleService.addRole(addRoleReq);
		return DtoUtils.returnSuccess(roleId);
	}
	
	@ApiOperation(value = "删除角色", notes = "删除角色")
	@GetMapping(value = "/delRole/{roleId}")
	public Dto<Object> delRole(@PathVariable("roleId") Long roleId) {
		roleService.delRole(roleId);
		return DtoUtils.returnSuccess(CodeEnum.SUCCESS);
	}
	
	@ApiOperation(value="分配权限",notes="为角色分配权限")
	@PostMapping(value="/configAuth",produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Dto<Object> configAuth(@Valid @RequestBody ConfigAuthReq configAuthReq){
		roleService.configAuth(configAuthReq);
		return DtoUtils.returnSuccess(CodeEnum.SUCCESS);
	}
	
	@ApiOperation(value="查询角色对应的权限",notes="查询角色对应的权限")
	@GetMapping(value="/findByRoleId/{roleId}",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Dto<List<TbAuthorityResp>> findByRoleId(@PathVariable long roleId){
		List<TbAuthorityResp> allMenu = roleService.findByRoleId(roleId);
		return DtoUtils.returnSuccess(allMenu);
	}
}
