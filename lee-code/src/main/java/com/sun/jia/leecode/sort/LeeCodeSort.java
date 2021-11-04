package com.sun.jia.leecode.sort;

public class LeeCodeSort {

    public static int[] sortedSquares(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        int[] result = new int[nums.length];
        int write = nums.length-1;
       while (left<=right){
           if (nums[left]*nums[left]>nums[right]*nums[right]){
               result[write] = nums[left]*nums[left];
               left++;
               write--;
           }else {
               result[write] = nums[right]*nums[right];
               write--;
               right --;
           }
       }
       return result;
    }

    public void rotate(int[] nums, int k) {
        int n = nums.length;
        int[] tNums = new int[n];
        for (int i = 0;i<n;i++){
            int ni = (i+k)%n;
            tNums[ni] = nums[i];
        }
        System.arraycopy(tNums,0,nums,0,n);
    }

    public static void moveZeroes(int[] nums) {
        int n = nums.length, left = 0, right = 0;
        while (right < n) {
            if (nums[right] != 0) {
                swap(nums, left, right);
                left++;
            }
            right++;
        }
    }

    public static void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

    public int[] twoSum(int[] numbers, int target) {
        int l = 0;
        int r = numbers.length-1;
        while (l<=r){
            if (numbers[l]+numbers[r]== target){
                return new int[]{l+1,r+1};
            }
            if (numbers[l]+numbers[r]>target){
                r--;
            }
            if (numbers[l]+numbers[r]<target){
                l++;
            }
        }

        return new int[]{-1,-1};
    }

}
