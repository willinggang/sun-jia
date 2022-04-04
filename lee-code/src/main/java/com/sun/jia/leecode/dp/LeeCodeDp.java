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

    public 
}
