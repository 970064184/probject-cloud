package com.zhangbin.cloud;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
public class ProbjectCloudProductsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProbjectCloudProductsApplication.class, args);
	}

	/**
	 * 分页插件
	 */
	@Bean
	@Profile({"dev","test"})// 设置 dev test 环境开启
	public PaginationInterceptor paginationInterceptor() {
		PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
		// paginationInterceptor.setLimit(你的最大单页限制数量，默认 500 条，小于 0 如 -1 不受限制);
		return paginationInterceptor;
	}
}
