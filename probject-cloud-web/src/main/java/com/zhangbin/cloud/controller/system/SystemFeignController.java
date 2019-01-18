package com.zhangbin.cloud.controller.system;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.zhangbin.cloud.common.Dto;
import com.zhangbin.cloud.common.DtoUtils;
import com.zhangbin.cloud.domain.system.TbAuthority;
import com.zhangbin.cloud.feign.SystemFeignClient;
import com.zhangbin.cloud.service.SystemService;

import io.swagger.annotations.Api;

@Api(tags = "系统相关接口API")
@RestController
public class SystemFeignController implements SystemFeignClient{
	
	@Autowired
	private SystemService systemService;
	
	@Override
	public String getAllMenu(HttpServletRequest request) {
		System.out.println(request.getHeader("Authorication"));
		return DtoUtils.isSuccess(systemService.findAll());
	}

	@Override
	public Dto getMenu() {
		List<TbAuthority> findAll = systemService.findAll();
		return DtoUtils.returnSuccess(findAll);
	}

	@Override
	public TbAuthority getMenu3() {
		return systemService.findAll().get(0);
	}

	@Override
	public Dto<List<TbAuthority>> getMenu4() {
		return DtoUtils.returnSuccess(systemService.findAll());
	}
}
