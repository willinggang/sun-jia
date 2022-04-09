package com.sun.jia.leecode.dp;

public class LeeCodeDp {

    /**
     *
     * dp[i][j] 在数据里面前i个元素的值等于j
     * 1-当第i个元素大于j是
     * dp[i][j] = dp[i-1][j]
     * 2-当第i个元素小于j时
     *
     * @param nums
     */
    public int findTargetSumWays(int[] nums,int target){
        int length = nums.length;
        int sum = 0;
        for (int num:nums){
            sum+=num;
        }
        if (sum<target||((sum-target) & 1)!=0){
            return 0;
        }
        int capacity = (sum-target)>>1;
        int[][] dp = new int[length+1][capacity+1];
        dp[0][0]= 0;
        for (int i=1;i<=length;i++){
            for (int j = 0;j<=capacity;j++){
                if (nums[i]>j){
                    dp[i][j]= dp[i-1][j];
                }else {
                    dp[i][j] = dp[i-1][j]+dp[i-1][j-nums[i]];
                }
            }
        }
        return dp[length][capacity];
    }

    /*
    *
    *
    * dp[i] 表示前i个元素组成的最长的斐波那契数
    *
    *
    *   如果nums[1]-nums[0]==num[2]
    *
    *
    *
    *
    * */
    public int  findMaxF(int[] nums){
        if (nums== null){
            return 0;
        }
        int[] dp = new int[nums.length+1];
        int maxLength=0;
        if (nums[2]==nums[1]+nums[0]){
            dp[3] =1;
        }else {
            dp[3] = 0;
        }
        for (int i =4;i<=nums.length;i++){
            if (nums[i-1] == nums[i-2] + nums[i-3]){
                dp[i+1] = dp[i]+1;
            }else {
                dp[i+1] =0;
            }
            maxLength = Math.max(maxLength,dp[i+1]);
        }
        return maxLength;
    }


    /*
    *套娃
    *
    * dp[i] 表示第i个是否可以与前面的组成套娃
    *   如果可以
    *    dp[i]= true
    *   如果不可以
    *
    * */

    /*
    * dp[lenth][0] = 1;
    * 最长回文子串
    *  假设dp[i][j] 第i到j最长回文子串的长度
    *  if（s.charAt[i-1]==s.charAt[j-1]）
    *    dp[i][j] = dp[i+1][j-1]+2
    *  else
    *    dp[i][j]= dp[i+1]dp[j-1]
    *
    * */


    /*
    * 带交易金额的股票   int[] nums   fee 交易
    *
    *  dp[i][j] 第次交易第j天买入的利润
    *  dp[i][j] =
    *
    * */


    /*
    *
    * 最大子序列的和
    * dp[i][j] 表示i到j元素之和
    *  如果第 i 个数为正数则 dp[i]
    *
    * */



    /*
    * 给定一个整数数组 n u m s ，找到一个具有最大和的连续子数组（子数组最少包含一个元 素），返回其最大和。
    *
    * dp[i] 前i个数组成的最大连续子数列的和
    *
    *   dp[0] = nums[0];
    *   dp[i]= max(dp[i-1],0)+nums[i]
    *
    *  max = max(dp[i],max)
    *
    *
    * */


}
