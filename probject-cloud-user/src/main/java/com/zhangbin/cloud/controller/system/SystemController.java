package com.zhangbin.cloud.controller.system;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zhangbin.cloud.common.Dto;
import com.zhangbin.cloud.common.DtoUtils;
import com.zhangbin.cloud.controller.system.resData.TbAuthorityResData;
import com.zhangbin.cloud.service.SystemService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(tags = "系统相关接口API")
@RestController
@RequestMapping("/system")
public class SystemController {
	
	@Autowired
	private SystemService systemService;
	
	@ApiOperation(value ="获取菜单",notes = "获取菜单")
	@GetMapping(value = "/getMenu",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Dto<List<TbAuthorityResData>> getAllMenu(@ApiParam(name="authType",value="菜单类型:1=导航，2=菜单，3=api，4=按钮",required=true) @RequestParam(value="authType") Integer authType) {
		List<TbAuthorityResData> findByAuthTypeAndIsHide = systemService.findByAuthTypeAndIsHide(authType);
		return DtoUtils.returnSuccess(findByAuthTypeAndIsHide);
	}
	
	
	
}
