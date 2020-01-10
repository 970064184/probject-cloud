package com.zhangbin.cloud.algorithm;

/**
 * @version 1.0
 * @author: zb
 * @date: 2020/01/10/14:22
 * @description:
 */
public class Algorithm {

    public static void main(String[] args) {
        int s = 6,m =9;
        int i = commonDvisor(s, m);
        System.out.println(i);
    }
    
    /**
      * @Description: 求两个自然数的最大公约数
      * @Param: 
      * @return: 
      * @Author: zb
      * @Date: 2020/1/10
    */    
    public static int commonDvisor(int s,int m){
        int result =-1;
        for (int i = 1; i <= s; i++) {
            if( (s % i ==0) && (m % i==0)){
                result = i;
            }
        }
        return result;
    }
}
