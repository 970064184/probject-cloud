package com.zhangbin.cloud;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.stream.IntStream;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProbjectCloudProductsApplicationTest {

    static int data = 0;
    @Test
    public void contextLoads() {
        System.out.println("  ---test");
    }

    @Test
    public void test(){

        System.out.println("测试线程的安全性");
            // 类的成员变量
// main方法内代码
            IntStream.range(0, 2).forEach((i) -> {
                new Thread(() -> {
                    try {
                        Thread.sleep(20);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    IntStream.range(0, 100).forEach(y -> {
                        data++;
                    });
                }).start();
            });
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("data :"+data);
    }

}