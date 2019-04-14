package com.zhangbin.cloud.test;

import java.io.IOException;
import java.net.Socket;
import java.util.Date;

import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

@Api(tags = "测试Controller的API")
@RestController
public class TestController {
	
	public static void main(String[] args) {
		//创建多个线程，模拟多个客户端连接服务端
		new Thread(()->{
			Socket socket;
			try {
				socket = new Socket("127.0.01", 3333);
				while(true) {
					socket.getOutputStream().write((new Date()+":hello world").getBytes());
					Thread.sleep(2000);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}).start(); 
	}
}
