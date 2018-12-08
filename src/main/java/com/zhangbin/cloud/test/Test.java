package com.zhangbin.cloud.test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**selenium模拟点击
 * @author admin
 *
 */
public class Test {
	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");// chromedriver服务地址
		// 实例化webdriver的对象，启动谷歌浏览器
		WebDriver driver = new ChromeDriver();

		// 通过对象driver调用具体的get方法来打开网页
		driver.get("https://www.baidu.com/");
		driver.manage().window().maximize();

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("scrollBy(0, 100)");

		// Click on the Search button
		driver.findElement(By.linkText("学术")).click();
		Thread.sleep(2000);

		/*
		 * //获取当前的窗口 String currentWindow = driver.getWindowHandle();
		 * 
		 * //获取所有的窗口 Set<String> handles = driver.getWindowHandles();
		 * 
		 * //遍历窗口 Iterator<String> iterator = handles.iterator(); while
		 * (iterator.hasNext()) { if (currentWindow == iterator.next()) continue;
		 * //跳转到弹出的窗口 WebDriver driver2 = driver.switchTo().window(iterator.next());
		 * driver2.getTitle();
		 * 
		 * }
		 */

		List<WebElement> list = driver.findElements(By.tagName("a"));
		System.out.println("元素有：" + list.size());
		for (int i = 0; i < list.size(); i++) {
			list.get(i).click();
			Thread.sleep(2000);
		}
		// 等待加载完页面
		try {
			driver.manage().timeouts().wait(1);
			driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);// 等待界面加载完
		} catch (InterruptedException e2) {

			e2.printStackTrace();
		}
		// 退出浏览器
		// driver.quit();
	}
}