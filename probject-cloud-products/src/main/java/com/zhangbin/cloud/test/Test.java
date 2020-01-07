package com.zhangbin.cloud.test;

import com.zhangbin.cloud.domain.Brand;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
//        heapOutOfMemory();
        stackOverFlowError();
        return;
    }

    /**
     * 堆溢出例子
     */
    private static void heapOutOfMemory() {
        System.out.println("HelloHeapOutOfMemory");
        List<Brand> brands = new ArrayList<>();
        int count = 0;
        while (true){
            brands.add(new Brand());
            System.out.println("counts:"+(++count));
        }
    }

    private static void stackOverFlowError(){
        System.out.println("stackOverFlowError");
        while(true){
            new Thread(){
                @Override
                public void run() {
                    int count = 0;
                    while(true){
                        System.out.println("counts:"+(++count));
                    }
                }
            }.start();
            //阻塞
        }
    }
}
