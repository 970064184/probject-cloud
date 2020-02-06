package com.zhangbin.cloud.algorithm;

import java.util.Arrays;

/**
 * @version 1.0
 * @author: zb
 * @date: 2020/01/07/11:47
 * @description: 冒泡排序
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = new int[]{12,32,34,1,3,88,23};
        int[] ints = bubbleSort(arr);
    }
    
    /**
      * @Description: 冒泡排序：整个算法是从最下面的记录开始，对每两个相邻的关键字进行比较，把关键字较小的记录放到关键字较大的记录的上面，经过一趟排序后，关键字最小的记录到达最上面，接着再在剩下的记录中找关键字次小的记录，把它放在第二个位置上，依次类推，一直到所有记录有序为止
      * @Param: 
      * @return: 
      * @Author: zb
      * @Date: 2020/1/7
    */    
    public static int[] bubbleSort(int[] arr){
        int temp;
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = arr.length-1; j >i ; j--) {
                if(arr[j] < arr[j-1]){
                    temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                }
            }
            System.out.println(Arrays.toString(arr));
        }
        return arr;
    }
}
