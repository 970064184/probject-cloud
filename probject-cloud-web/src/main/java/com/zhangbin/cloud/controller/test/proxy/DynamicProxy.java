package com.zhangbin.cloud.controller.test.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**动态代理模式
 * @author admin
 *
 */
public class DynamicProxy implements InvocationHandler{
	
	private Marry you;
	
	
	public DynamicProxy() {
		super();
	}

	public DynamicProxy(Marry you) {
		this.you = you;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("====布置会场====");
		method.invoke(you, args);
		System.out.println("====收拾会场====");
		return null;
	}
	
	public static void main(String[] args) {
		You you = new You();
		DynamicProxy p = new DynamicProxy(you);
		
		Marry proxy = (Marry) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(),new Class[] {Marry.class}, p);
		proxy.marry();
		
		He he = new He();
		DynamicProxy p2 = new DynamicProxy(he);
		
		Marry proxy2 = (Marry) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(),new Class[] {Marry.class}, p2);
		proxy2.marry();
	}
}
