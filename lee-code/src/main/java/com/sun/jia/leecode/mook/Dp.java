package com.sun.jia.leecode.mook;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Dp {

    private Map<Integer, Integer> csMap;

    public int climbStairs(int n) {
     /*   csMap = new HashMap<>();
        return csDfs(n);*/

        int[] memo = new int[n + 1];
        memo[0] = 1;
        memo[1] = 1;
        for (int i = 3; i <= n; i++) {
            memo[i] = memo[i - 1] + memo[i - 2];
        }
        return memo[n];
    }

    public int csDfs(int n) {
        Integer val = csMap.get(n);
        if (val != null) {
            return val;
        }
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        val = csDfs(n - 1) + csDfs(n - 2);
        csMap.put(n, val);
        return val;
    }


    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) {
            return 0;
        }
        if (triangle.size() == 1) {
            return triangle.get(0).get(0);
        }
        /*return dfsTriangle(0, 0, 0, triangle);*/
        int m = triangle.size();
        int[][] dp = new int[m + 1][m + 1];
        dp[0][0] = triangle.get(0).get(0);
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + triangle.get(i).get(j);
                } else if (j == triangle.get(i).size() - 1) {
                    dp[i][j] = dp[i - 1][j - 1] + triangle.get(i).get(j);
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j] + triangle.get(i).get(j), dp[i - 1][j - 1] + triangle.get(i).get(j));
                }
                if (i == m - 1) {
                    min = Math.min(min, dp[i][j]);
                }
            }
        }
        return min;
    }

    /**
     * @param level    要访问的层数
     * @param pos      要访问的位置
     * @param total    最短路径和
     * @param triangle 三角数组
     * @return
     */
    private int dfsTriangle(int level, int pos, int total, List<List<Integer>> triangle) {
        if (level == triangle.size() - 1) {
            return total + triangle.get(level).get(pos);
        }
        int newTotal = total + triangle.get(level).get(pos);
        return Math.min(dfsTriangle(level + 1, pos, newTotal, triangle), dfsTriangle(level + 1, pos + 1, newTotal, triangle));
    }

    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0;i<=m;i++){
            dp[i][0] = Integer.MAX_VALUE;
        }
        for (int i = 0;i<=n;i++){
            dp[0][i] = Integer.MAX_VALUE;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
//                if (i == 1) {
//                    dp[i][j] = dp[i][j - 1] + grid[i - 1][j - 1];
//                } else if (j == 1) {
//                    dp[i][j] = dp[i - 1][j] + grid[i - 1][j - 1];
//                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i - 1][j - 1];
//                }

            }
        }
        return dp[m][n];
    }


    public boolean isPm(int num){
        if (num<0){
            return false;
        }
        char[] numCArray = String.valueOf(num).toCharArray();
        for (int i =0;i<numCArray.length/2;i++){
            if (numCArray[i]!=numCArray[numCArray.length-i-1]){
                return false;
            }
        }
        return true;
    }

}
