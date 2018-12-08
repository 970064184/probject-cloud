package com.zhangbin.cloud.controller.test.singleton;
	
/**
 * @author admin
 * 懒汉式
 * 延迟创建这个实例对象
 * 
 * 1.某个类只有一个实例--》构造器私有化
 * 2.必须自行创建这个实例--》含有个该类的静态变量来保存这个唯一的实例
 * 3.必须自行向整个系统提供这个实例-->对外提供获取该实例对象的方式
 */
public class Singleton4 {
	
	private static Singleton4 instance;
	
	private Singleton4() {}
	public synchronized static Singleton4 getInstance() {
		if(instance == null) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			instance =new Singleton4();
			/**
			 * com.zhangbin.cloud.controller.test.singleton.Singleton4@1ea9fc85
			   com.zhangbin.cloud.controller.test.singleton.Singleton4@23433a84
				所以要加锁，防止出现同步问题
				加synchronized同步方法，效率低
				com.zhangbin.cloud.controller.test.singleton.Singleton4@4241721e
				com.zhangbin.cloud.controller.test.singleton.Singleton4@4241721e
				所以要用双重检测锁实现
				加synchronized同步代码块方式，但不建议使用
			 */
		}
		return instance;
	}
}
