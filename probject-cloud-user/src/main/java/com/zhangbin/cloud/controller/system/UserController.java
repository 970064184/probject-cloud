package com.zhangbin.cloud.controller.system;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.zhangbin.cloud.common.CodeEnum;
import com.zhangbin.cloud.common.Dto;
import com.zhangbin.cloud.common.DtoUtils;
import com.zhangbin.cloud.common.PageBean;
import com.zhangbin.cloud.common.PageData;
import com.zhangbin.cloud.controller.system.resData.AllUserResp;
import com.zhangbin.cloud.controller.system.resData.ImportUser;
import com.zhangbin.cloud.exception.BusinessException;
import com.zhangbin.cloud.feign.resData.AddUserReq;
import com.zhangbin.cloud.office.ExcelUtil;
import com.zhangbin.cloud.service.UserService;
import com.zhangbin.cloud.utils.ValidatorUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "用户相关接口API")
@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@ApiOperation(value="添加用户",notes="添加用户")
	@PostMapping(value="/addUser",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Dto<Long> addUser(@RequestBody @Valid AddUserReq addUserReq){
		Long userId = userService.addUser(addUserReq);
		return DtoUtils.returnSuccess(userId);
	}
	
	@ApiOperation(value="分页查询所有用户",notes="用户列表数据")
	@PostMapping(value="/findAllUserByPage",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Dto<PageData<AllUserResp>> findAllUserByPage(@RequestBody PageBean pageBean){
		PageData<AllUserResp> data = userService.findAllUserByPage(pageBean);
		return DtoUtils.returnSuccess(data);
	}
	
	@ApiOperation(value="删除用户",notes="删除用户")
	@GetMapping(value="/delUser/{userId}")
	public Dto<Object> delUser(@PathVariable("userId")Long userId){
		userService.delUser(userId);
		return DtoUtils.returnError(CodeEnum.SUCCESS);
	}
	
	@ApiOperation(value="批量导入用户",notes="批量导入用户")
	@PostMapping(value="/importUser",produces = MediaType.APPLICATION_JSON_UTF8_VALUE,consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public Dto<Object> importUser(@RequestParam("file")MultipartFile multipartFile){
		try {
			List<ImportUser> importUser = ExcelUtil.convertSheetToList(multipartFile.getInputStream(), ImportUser.class, 1);
			if(!CollectionUtils.isEmpty(importUser)) {
				ValidatorUtil.validationData(importUser);
				userService.saveListUser(importUser);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new BusinessException(CodeEnum.USER_IMPORT_ERROR,e.getMessage());
		}
		return DtoUtils.returnError(CodeEnum.SUCCESS);
	}
	
}
