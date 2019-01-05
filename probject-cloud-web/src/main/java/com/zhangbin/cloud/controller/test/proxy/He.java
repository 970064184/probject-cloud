package com.zhangbin.cloud.controller.test.proxy;


/**真实角色
 * @author admin
 *
 */
public class He  implements Marry{
	
	@Override
	public void marry() {
		System.out.println("he and 嫦娥结婚了。。。。");
	}

	@Override
	public void honeymoon() {
		System.out.println("度蜜月啦。。。。");
	}
}
