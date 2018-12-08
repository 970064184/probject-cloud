package com.zhangbin.cloud.controller.test.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


/**实现Callable接口
 * @author admin
 *
 */
public class Callable1 {

	public static void main(String[] args) throws Exception, Exception {
		//创建线程
		ExecutorService ser = Executors.newFixedThreadPool(1);
		Race tortoise = new Race();
		//获取值
		Future<Integer> result  = ser.submit(tortoise);
		Integer num = result.get();
		System.out.println(num);
		ser.shutdown();
	}

}
class Race implements Callable<Integer>{

	@Override
	public Integer call() throws Exception {
		return 1000;
	}
	
}