package com.zhangbin.cloud.algorithm;

import java.util.Arrays;

/**
 * @version 1.0
 * @author: zb
 * @date: 2020/01/07/11:48
 * @description: 插入排序
 */
public class InsertSort {

    public static void main(String[] args) {
        int[] arr = new int[]{33,12,3,4,11,44,53};
        System.out.println(Arrays.toString(arr));
        int[] ints = insertSort(arr);
    }
    
    
    /**
      * @Description: 插入排序思想：
      * @Param: 
      * @return: 
      * @Author: zb
      * @Date: 2020/1/7
    */    
    public static int[] insertSort(int[] arr){
        int temp;
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = i+1; j < arr.length-1; j++) {
                if(arr[i]>arr[j]){
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
            System.out.println(Arrays.toString(arr));
        }
        return arr;
    }
}
