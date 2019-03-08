package com.zhangbin.cloud.common;

import java.util.Map;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel("分页查询请求参数")
@Data
public class PageBean {
	
	@ApiModelProperty(value="当前页码")
	private Integer page = 1;
	
	@ApiModelProperty(value ="每页数据量")
	private Integer limit = 10;
	
	@ApiModelProperty(value="其它查询参数")
	private Map<String, Object>search;
	
}
