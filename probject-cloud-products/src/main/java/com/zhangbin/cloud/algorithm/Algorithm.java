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
        System.out.println("两个自然数最大公因数："+i);
        int i1 = countChikenProsiable();
        System.out.println("(方法一)买鸡的种类数："+i1);
        int i2 = countChikenProsiable();
        System.out.println("(方法二)买鸡的种类数："+i2);
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

    /**
      * @Description:（方法一） 问题描述：每只母鸡3元，每只公鸡4元，每只小鸡0.5元，如果花100元钱买100只鸡，请问有哪些可能？说明：每种鸡的数量都可以为零。
      * @Param: 
      * @return: 
      * @Author: zb
      * @Date: 2020/1/14
    */
    public static int countChikenProsiable(){
        int sum = 0;
        for (int i = 0; i < 100; i++) {//母鸡
            for (int j = 0; j < 100; j++) {//公鸡
                for (int k = 0; k < 100; k++) {//小鸡
                    double count = 3*i + 4*j+ 0.5 *k;
                    int m = i + j + k;
                    if(100 == count && 100 == m ){
                        sum  = sum + 1;
                    }
                }
            }
        }
        return sum;
    }

    /**
     * @Description:（方法二） 问题描述：每只母鸡3元，每只公鸡4元，每只小鸡0.5元，如果花100元钱买100只鸡，请问有哪些可能？说明：每种鸡的数量都可以为零。
     * @Param:
     * @return:
     * @Author: zb
     * @Date: 2020/1/14
     */
    public static int countChikenProsiable2(){
        int sum = 0;
        for (int i = 0; i <= 33; i++) {//母鸡
            for (int j = 0; j <= 25; j++) {//公鸡
                int k = 100 -i - j ;
                double count = 3*i + 4*j+ 0.5 *k;
                if(100 == count){
                        sum  = sum + 1;
                }
            }
        }
        return sum;
    }
}
