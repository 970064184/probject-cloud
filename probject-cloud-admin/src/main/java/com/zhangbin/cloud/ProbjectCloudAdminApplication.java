package com.zhangbin.cloud;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableAdminServer
@SpringBootApplication
public class ProbjectCloudAdminApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProbjectCloudAdminApplication.class, args);
	}

}
