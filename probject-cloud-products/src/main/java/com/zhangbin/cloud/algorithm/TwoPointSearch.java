package com.zhangbin.cloud.algorithm;

import java.util.Arrays;

/**
 * @version 1.0
 * @author: zb
 * @date: 2019/12/20/15:26
 * @description: 二分查找-两种方式：递归&非递归
 */
public class TwoPointSearch {

    public static void main(String[] args) {
        int[] nums = new int[]{-1,0,3,5,9,12,16};
        int target = 5;
        System.out.println(Arrays.toString(nums));
        int i = unTwoPointSearch(nums, target);
        System.out.println("非递归、非二分查找,下标为:"+i);
        int i1 = unTwoPointSearch1(nums, target);
        System.out.println("非递归、非二分查找，下标为："+i1);
        int i2 = recursionSearch(nums, target, 0, nums.length-1);
        System.out.println("递归二分查找，下标为："+i2);
        int i3 = unrecursionSearch(nums, target);
        System.out.println("非递归二分查找，下标为："+i3);

    }
    
    /**
      * @Description: 输入: nums = [-1,0,3,5,9,12], target = 9 输出: 4
      *      解释: 9 出现在 nums 中并且下标为 4，用递归与非递归方法
     *      二分非递归查找
      * @Param:
      * @return:
      * @Author: zb
      * @Date: 2019/12/20
    */
    public static int unrecursionSearch(int[] nums,int target){
        int min = 0 ;
        int max = nums.length-1;
        int mid = (max - min)/2 + min;
        while (min < max){
            if(nums[mid]>target){
                max = mid ;
            }else if (nums[mid]<target){
                min = mid+1;
            }else {
                return mid;
            }
        }
        return -1;
    }
    /**
      * @Description: 递归二分查找
      * @Param: 
      * @return: 
      * @Author: zb
      * @Date: 2019/12/20
    */    
    private static int recursionSearch(int[] nums, int target, int min,int max) {
        int mid = (max-min )/2+min ;
        if(nums[mid] > target){
            max = mid ;
            return recursionSearch(nums, target,min,max);
        }else if(nums[mid] < target){
            min = mid+1;
           return recursionSearch(nums, target,min,max);
        }else{
            return mid;
        }
    }

    /**
      * @Description: 非递归、非二分查找
      * @Param: 
      * @return: 
      * @Author: zb
      * @Date: 2019/12/20
    */    
    public static int unTwoPointSearch1(int[] nums,int target){
        /**先排序，再二分*/
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        int mid = nums[nums.length/2];
        if(mid> target){
            for (int i = 0; i < nums.length/2; i++) {
                if(target == nums[i]){
                    return i;
                }
            }
        }else{
            for (int i = nums.length/2; i < nums.length; i++) {
                if(target == nums[i]){
                    return i;
                }
            }
        }
        return -1;
    }
    /**
      * @Description: 非递归、非二分查找
      * @Param: 
      * @return: 
      * @Author: zb
      * @Date: 2019/12/20
    */    
    public static int unTwoPointSearch(int[] nums,int target){
        for (int i = 0; i < nums.length; i++) {
            if(target == nums[i]){
                return i;
            }
        }
        return -1;
    }
}
