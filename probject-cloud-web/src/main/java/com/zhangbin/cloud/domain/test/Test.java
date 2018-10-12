package com.zhangbin.cloud.domain.test;


import javax.persistence.Entity;
import javax.persistence.Id;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel("测试类")
@Data
@Entity
public class Test {
	
	@ApiModelProperty("id")
	@Id
	private Long id;
	
	@ApiModelProperty(value="名称",required=true)
	private String name;
	
	@ApiModelProperty("年龄")
	private int age;
}
