package com.zhangbin.cloud.controller.test.thread;

import java.text.SimpleDateFormat;
import java.util.Date;

/**倒计时
 * @author admin
 *
 */
public class TestSleep{

	public static void main(String[] args) throws InterruptedException {
		Date endTime = new Date(System.currentTimeMillis()+10*1000);
		long end = endTime.getTime();
		while(true) {
			System.out.println(new SimpleDateFormat("mm:ss").format(endTime));
			//构建下一秒时间
			endTime = new Date(endTime.getTime()-1000);
			//等待一秒
			Thread.sleep(1000);
			if(end-10000 >endTime.getTime()) {
				break;
			}
		}
	}

}
