package com.zhangbin.cloud.domain.test;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel("测试类")
@Data
public class Test {
	
	@ApiModelProperty("id")
	private Long id;
	
	@ApiModelProperty(value="名称",required=true)
	private String name;
	
	@ApiModelProperty("年龄")
	private int age;
}
