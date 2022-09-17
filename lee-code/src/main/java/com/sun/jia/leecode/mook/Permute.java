/*
package com.sun.jia.leecode.mook;

import org.springframework.util.StringUtils;

import java.util.*;

*/
/**
 * 全排列
 *//*

public class Permute {


    */
/*给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案*//*

    public List<List<Integer>> permute(int[] nums) {
        permuteList = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return permuteList;
        }
        used = new int[nums.length];
        List<Integer> p = new ArrayList<>();
        generatePermutation(nums, 0, p);

        return permuteList;
    }

    */
/**
     * @param nums  原始数组
     * @param index 已经保存的数量
     * @param p     已经排列好的
     *//*

    private void generatePermutation(int[] nums, int index, List<Integer> p) {

        if (index == nums.length) {
            permuteList.add(new ArrayList<>(p));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i] == 0) {
                p.add(nums[i]);
                used[i] = 1;
                generatePermutation(nums, index + 1, p);
                used[i] = 0;
                p.remove(p.size() - 1);
            }
        }
    }

    List<List<Integer>> permuteList;
    int[] used;
    List<Integer> generateStrList;

    */
/*给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列*//*

    public List<List<Integer>> permuteUnique(int[] nums) {
        permuteList = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return permuteList;
        }
        used = new int[nums.length];
        generateStrList = new ArrayList<>();
        List<Integer> p = new ArrayList<>();
        generateUniquePermutation(nums, 0, p);

        return permuteList;
    }


    private void generateUniquePermutation(int[] nums, int index, List<Integer> p) {
        if (index == nums.length) {
            if (!generateStrList.contains(p.hashCode())) {
                permuteList.add(new ArrayList<>(p));
                generateStrList.add(p.hashCode());
            }
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i] == 0) {
                p.add(nums[i]);
                used[i] = 1;
                generateUniquePermutation(nums, index + 1, p);
                used[i] = 0;
                p.remove(p.size() - 1);
            }
        }
    }
*/
/*找出所有相加之和为 n 的 k 个数的组合，且满足下列条件：

只使用数字1到9
每个数字 最多使用一次 
返回 所有可能的有效组合的列表 。该列表不能包含相同的组合两次，组合可以以任何顺序返回。
*//*


    List<List<Integer>> res;

    private void combination(int n, int k, int index, List<Integer> p) {
        if (n < 0 || (n == 0 && k != 0)) {
            return;
        }

        if (n == 0) {
            res.add(new ArrayList<>(p));
            return;
        }

        for (int i = index + 1; i <= 9; i++) {
            p.add(i);
            combination(n - i, k - 1, i, p);
            p.remove(p.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        res = new ArrayList<>();
        if (k > n) {
            return res;
        }
        List<Integer> p = new ArrayList<>();
        combination(n, k, 0, p);
        return res;
    }

    public void subsets(int[] nums, int index, List<Integer> p) {
        if (p.size() > nums.length) {
            return;
        }

        res.add(new ArrayList<>(p));

        for (int i = index; i < nums.length; i++) {
            p.add(nums[i]);
            subsets(nums, i + 1, p);
            p.remove(p.size() - 1);
        }
    }

    public List<List<Integer>> subsets(int[] nums) {
        res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        List<Integer> p = new ArrayList<>();
        subsets(nums, 0, p);
        return res;
    }

    */
/*记录已经遍历的足迹*//*

    boolean[][] land;
    Integer[][] step = new Integer[][]{{0, -1}, {1, 0}, {0, 1}, {-1, 0}};

    */
/*已经达到边界*//*



    private void isIslands(char[][] grid, int x, int y) {
        land[x][y] = true;
        for (int i = 0; i < 4; i++) {
            x = step[i][0] + x;
            y = step[i][1] + y;
            if (inArea(grid, x, y) && !land[x][y] && grid[x][y] == '1') {
                isIslands(grid, x, y);
            }
        }

    }

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int res = 0;
        int m = grid.length;
        int n = grid[0].length;
        land = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (land[i][j] || grid[i][j] == '0') {
                    continue;
                }
                isIslands(grid, i, j);
                res++;
            }
        }
        return res;
    }


    private int[][] pos = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

    private int bn;
    private int bm;

    public void solve(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }
        bn = board.length;
        bm = board[0].length;

        List<List<Integer>> p = new ArrayList<>();

        for (int i = 0; i < bn; i++) {
            for (int j = 0; j < bm; j++) {
                boolean ret = true;
                if (board[i][j] != 'X') {
                    ret = board(board, i, j, p);
                }
                if (!ret) {
                    for (List<Integer> pp : p) {
                        board[pp.get(0)][pp.get(1)] = 'O';
                    }
                }
                p.clear();
            }
        }

    }


    */
/**
     * @param board
     * @param x
     * @param y
     * @param p
     *//*

    private boolean board(char[][] board, int x, int y, List<List<Integer>> p) {
        if (board[x][y] == 'X') {
            return true;
        }
        if (!inArea(board, x, y)) {
            return false;
        }

        board[x][y] = 'X';
        p.add(Arrays.asList(x, y));
        boolean ret = true;
        for (int i = 0; i < 4; i++) {
            int newX = x + pos[i][0];
            int newY = y + pos[i][1];
            ret = board(board, newX, newY, p);
            if (!ret) {
                break;
            }
        }
        */
/*if (!ret) {
            board[x][y] = 'O';
            p.remove(p.size() - 1);
            return ret;
        }*//*


        return ret;
    }

    private boolean inArea(char[][] grid, int x, int y) {
        int n = grid.length;
        int m = grid[0].length;
        return x > 0 && x < n - 1 && y > 0 && y < m - 1;
    }


    */
/*太平洋大西洋水流问题*//*

    List<List<Integer>> paPos;


    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        paPos = new ArrayList<>();
        if (heights == null || heights.length == 0) {
            return paPos;
        }
        int an = heights.length;
        int am = heights[0].length;
        for (int i = 0; i < an; i++) {
            for (int j = 0; j < am; j++) {
                if ((i == 0 && j == am - 1) || (i == an - 1 && j == 0)) {
                    paPos.add(buildPos(i, j));
                } else {
                    if ((isCan(heights, i, j, 0, heights[i][j]) || isCan(heights, i, j, 2, heights[i][j]))
                            && (isCan(heights, i, j, 1, heights[i][j]) || isCan(heights, i, j, 3, heights[i][j]))) {
                        paPos.add(buildPos(i, j));
                    }
                }
            }
        }
        return paPos;

    }

    public boolean isCan(int[][] heights, int x, int y, int type, int posV) {
        if (!inPaArea(heights,x,y)){
            return true;
        }
        if (heights[x][y] > posV) {
            return false;
        }

        int newx = x;
        int newy = y;
        if (type == 0) {
            newx = x;
            newy = y - 1;
        } else if (type == 1) {
            newx = x;
            newy = y + 1;
        } else if (type == 2) {
            newx = x - 1;
            newy = y;
        } else if (type == 3) {
            newx = x + 1;
            newy = y;
        }
        return isCan(heights, newx, newy, type, heights[x][y]);
    }


    private boolean inPaArea(int[][] grid, int x, int y) {
        int n = grid.length;
        int m = grid[0].length;
        return x >= 0 && x < n && y >= 0 && y < m;
    }


    public List<Integer> buildPos(int x, int y) {
        return Arrays.asList(x, y);
    }

    HashMap<Long,Long> cache = new HashMap<Long, Long>();
    public long fib(long n){

        if (n==0){
            return 0;
        }
        if (n==1){
            return 1;
        }
        if (cache.get(n)!=null){
            return cache.get(n);
        }
        long ret = fib(n-1)+ fib(n-2);
        cache.put(n,ret);
        return ret;
    }
}
*/
