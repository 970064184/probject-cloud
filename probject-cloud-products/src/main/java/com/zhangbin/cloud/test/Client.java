package com.zhangbin.cloud.test;

/**
 * 客户端类
 * （相当于例子中的笔记本，只有USB接口）
 */
public class Client {

    public void test1(Target t){
        t.handleReq();
    }

    public static void main(String[] args) {
        Client c = new Client();
        Target adapter = new Adapter();
        c.test1(adapter);
        int i = 0;
        Integer a = 0;
    }
}
