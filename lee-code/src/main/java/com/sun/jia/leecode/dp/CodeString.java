package com.sun.jia.leecode.dp;

public class CodeString {

    /**
     * 获取获取子字符串在字符串中的个数
     *
     * @param content 字符串内容
     * @param subStr  子字符串
     */
    public int getSubStringNum(String content, String subStr) {
        int parentLength = content.length();
        int subLength = subStr.length();
        int dp[][] = new int[subLength + 1][parentLength + 1];

        for (int j = 0; j < parentLength; j++) {
            dp[0][j] = 1;
        }

        for (int i=1;i<=subLength;i++){
            for (int j =1;j<=parentLength;j++){
                if (content.charAt(j-1)==subStr.charAt(i-1)){
                    dp[i][j] = dp[i-1][j-1]+dp[i][j-1];
                }else {
                    dp[i][j] = dp[i][j-1];
                }
            }
        }
        return dp[subLength][parentLength];
    }
}
