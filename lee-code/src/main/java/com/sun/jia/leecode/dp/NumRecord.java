package com.sun.jia.leecode.dp;

public class NumRecord {


    /**
     * dp[i] = dp[i-1]+dp[i-2]
     *
     * @param str
     */
    public int getNumRecord(String str) {
        int length = str.length();
        int[] dp = new int[length + 1];
        dp[0] = 1;

        for (int index = 1; index <= length; index++) {

            if (str.charAt(index - 1) != '0') {
                dp[index] += dp[index - 1];
            }

            if (index >= 2 && (str.charAt(index - 2) == '1' || str.charAt(index - 2) == '2' && str.charAt(index - 1) <= '6')) {
                dp[index] += dp[index - 2];
            }

        }
        return dp[length];
    }
}
