package com.zhangbin.cloud.algorithm;

import java.util.Arrays;

/**
 * @version 1.0
 * @author: zb
 * @date: 2020/01/07/11:48
 * @description: 选择排序
 */
public class SelectSort {

    public static void main(String[] args) {
        int[] arr = new int[]{33,12,3,4,11,44,53};
        System.out.println(Arrays.toString(arr));
//        int[] ints = selectSort(arr);
        SelectionSort(arr,arr.length);
    }


    /**
     * @Description: 选择排序思想：
     * @Param:
     * @return:
     * @Author: zb
     * @Date: 2020/1/7
     */
    public static int[] selectSort(int[] arr){
        int temp;
        for (int i = 0; i < arr.length-1; i++) {
            int k = i;
            for (int j = i+1; j < arr.length-1; j++) {
                if(arr[k] > arr[j] ){
                    k = j;
                }
            }
            temp = arr[i];
            arr[i] = arr[k];
            arr[k] = temp;
//            temp = arr[k];
//            arr[k] = arr[i];
//            arr[i] = temp;
            System.out.println(Arrays.toString(arr));//6次
        }
        return arr;
    }

    public static void SelectionSort(int a[], int size)
    {
        for(int i = 0;i < size-1;i++){
            //每次循环后将第i小的元素放好
            int tempMin = i;
            //记录第i个到底size-1个元素中，最小的元素的下标
            for(int j = i+1;j < size;j++){
                if(a[j] < a[tempMin])
                    tempMin = j;
            }
            //下面将第i小的元素放在第i个位置上，并将原来第i个位置的元素挪到后面
            int tmp = a[i];
            a[i] = a[tempMin];
            a[tempMin] = tmp;
            System.out.println(Arrays.toString(a));
        }
    }
}
