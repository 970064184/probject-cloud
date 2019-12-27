package com.zhangbin.cloud.algorithm;

/**
 * @version 1.0
 * @author: zb
 * @date: 2019/12/24/17:12
 * @description: 算法练习
 */
public class KMPPractice {

    /**
      * @Description: 字符串匹配问题：
      * 有一个字符串str1="你 你和 你好 好您好你好"，和一个子串str2="你好"，判断str1是否包含有str2，如果存在，及返回第一次出现的位置，如果没有，就返回-1
      * 要求用最快的速度来完成匹配
     *
     * 思路：
     * 慢匹配的思路：
     *      - 一个个字符循环去匹配
     *  快匹配：
     *      - KMP算法（部分匹配表）
      * @Param:
      * @return: 
      * @Author: zb
      * @Date: 2019/12/24
    */

    public static void main(String[] args) {
        String str1 = "你 你和 你好 好您好你好";
        String str2 = "你好";
        int match = match(str1, str2);
        System.out.println(match);
    }
    
    /**
      * @Description: 哈哈哈，用jdk自带的方法
      * @Param: 
      * @return: 
      * @Author: zb
      * @Date: 2019/12/24
    */    
    public static int match(String str1,String str2){
       /* if(str1.contains(str2)){
            return str1.indexOf(str2);
        }
        return -1;*/
       return str1.indexOf(str2);
    }
}
