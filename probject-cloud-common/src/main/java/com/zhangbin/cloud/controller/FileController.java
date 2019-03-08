package com.zhangbin.cloud.controller;

import java.io.IOException;
import java.util.Map;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.zhangbin.cloud.common.CodeEnum;
import com.zhangbin.cloud.common.Dto;
import com.zhangbin.cloud.common.DtoUtils;
import com.zhangbin.cloud.exception.BusinessException;
import com.zhangbin.cloud.office.FileUtil;

@RestController
@RequestMapping("/file")
public class FileController {
	
	@PostMapping(value="/uploadFile",produces = MediaType.APPLICATION_JSON_UTF8_VALUE,consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public Dto<Map<String, Object>> uploadFile(@RequestParam("file")MultipartFile multipartFile,@RequestParam("path")String path){
		Map<String, Object> uploadFile;
		try {
			uploadFile = FileUtil.uploadFile(multipartFile, path);
		} catch (IOException e) {
			e.printStackTrace();
			throw new BusinessException(CodeEnum.COMMON_FILE_ERROR,e.getMessage());
		}
		return DtoUtils.returnSuccess(uploadFile);
	}
}
