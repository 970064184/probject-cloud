package com.zhangbin.cloud.controller.test.singleton;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**测试反射和反序列化导致的漏洞及解决办法
 * @author admin
 *
 */
public class TestSingleton6 {

	public static void main(String[] args) throws Exception{
		Singleton6 s4 = Singleton6.getInstance();
		Singleton6 s5 = Singleton6.getInstance();
		System.out.println(s4 == s5);
		System.out.println(s4);
		System.out.println(s5);
		
		/*Class<Singleton6> clazz = (Class<Singleton6>) Class.forName("com.zhangbin.cloud.controller.test.singleton.Singleton6");
		Constructor<Singleton6> c = clazz.getDeclaredConstructor(null);
		c.setAccessible(true);
		Singleton6 s6 = c.newInstance();
		Singleton6 s7= c.newInstance();
		System.out.println(s6 == s7);
		System.out.println(s6);
		System.out.println(s7);*/
		/**
		 * true
			com.zhangbin.cloud.controller.test.singleton.Singleton6@762efe5d
			com.zhangbin.cloud.controller.test.singleton.Singleton6@762efe5d
			false
			com.zhangbin.cloud.controller.test.singleton.Singleton6@5d22bbb7
			com.zhangbin.cloud.controller.test.singleton.Singleton6@41a4555e

		 */
		
		FileOutputStream fos = new FileOutputStream("d:/a.txt");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(s4);
		oos.close();
		fos.close();
		
		 ObjectInputStream ois = new ObjectInputStream(new FileInputStream("d:/a.txt"));
		 Singleton6 s3 = (Singleton6) ois.readObject();
		 System.out.println(s3);
		 /**
		  * true
com.zhangbin.cloud.controller.test.singleton.Singleton6@762efe5d
com.zhangbin.cloud.controller.test.singleton.Singleton6@762efe5d
com.zhangbin.cloud.controller.test.singleton.Singleton6@2aafb23c

		  */
		/*new Thread(new Runnable() {
			
			@Override
			public void run() {
				Singleton5 s4 = Singleton5.getInstance();
				System.out.println("线程1"+Thread.currentThread().getName());
				System.out.println(s4);
			}
		}).start();
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("线程2"+Thread.currentThread().getName());
				Singleton5 s5 = Singleton5.getInstance();
				System.out.println(s5);
			}
		}).start();*/
	}

}
