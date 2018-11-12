package com.zhangbin.cloud;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.zhangbin.cloud.service.SystemService;
@RunWith(SpringRunner.class)
@SpringBootTest // 指定spring-boot的启动类 
public class ProbjectCloudWebApplicationTests {
	
	@Autowired
	private SystemService systemService;
	
	@Test
	public void contextLoads() {
	}
	
	@Test
	public void test1() {
		System.out.println(systemService.findAll());
	}
}
