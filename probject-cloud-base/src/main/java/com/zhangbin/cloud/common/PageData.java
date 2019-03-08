package com.zhangbin.cloud.common;

import java.util.List;

import org.springframework.data.domain.Page;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel("分页查询返回统一格式")
@Data
public class PageData<T> {
	
	@ApiModelProperty(value="数据总数")
	private Long count;
	
	@ApiModelProperty(value="数据列表")
	private List<T> data;

	public PageData(Page<T> page) {
		this.count = page.getTotalElements();
		this.data = page.getContent();
	}

	public PageData() {
	}

	public PageData(Long count, List<T> data) {
		this.count = count;
		this.data = data;
	}
	
}
