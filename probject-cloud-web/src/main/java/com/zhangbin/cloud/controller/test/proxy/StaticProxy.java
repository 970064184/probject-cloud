package com.zhangbin.cloud.controller.test.proxy;

/**静态代理设计模式
 * @author admin
 *
 */
public class StaticProxy {
	
	public static void main(String[] args) {
		You you  = new You();
		WeddingCompany con = new WeddingCompany(you);
		con.marry();
		con.honeymoon();
		/*He he  = new He();
		WeddingCompany con1 = new WeddingCompany(he);
		con1.marry();*/
 	}
}


