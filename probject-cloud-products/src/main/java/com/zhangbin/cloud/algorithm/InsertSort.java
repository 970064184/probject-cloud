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
        System.out.println(Arrays.toString(ints));
    }
    
    
    /**
      * @Description: 插入排序思想：第0个和第1个对比，如果0>1,交换位置，然后第2位置和此时的第0位置对比，0>2 ，那就第0,1位置后移，把2插入到0位置。。。。
      * @Param: 
      * @return: 
      * @Author: zb
      * @Date: 2020/1/7
    */    
    public static int[] insertSort(int[] arr){
        int tmp  = 0;
        for (int i = 1; i < arr.length; i++) {
            tmp = arr[i];
            int j = i;
            while(j>0 && arr[j] >= tmp){
                arr[j] = arr[j-1];
                j--;
            }
            arr[j] = tmp;
        }
        return arr;
    }
}
