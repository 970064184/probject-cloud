package com.zhangbin.cloud.controller.test.singleton;

import java.io.Serializable;

/**
 * @author admin
 * 懒汉式
 * 延迟创建这个实例对象
 * 
 * 1.某个类只有一个实例--》构造器私有化
 * 2.必须自行创建这个实例--》含有个该类的静态变量来保存这个唯一的实例
 * 3.必须自行向整个系统提供这个实例-->对外提供获取该实例对象的方式
 */
public class Singleton6 implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static Singleton6 instance;
	
	private Singleton6() {
		if(instance !=null) {//防止反射漏洞
			throw new RuntimeException();
		}
	}
	public synchronized static Singleton6 getInstance() {
		if(instance == null) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			instance =new Singleton6();
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
	/**
	 * 反序列化漏洞解决：
	 * 反序列化时，如果定义了readResolve()则直接返回此方法指定的对象。而不需要单独再创建新对象
	 * @return
	 */
	private Object readResolve(){
		return instance;
	}
}
