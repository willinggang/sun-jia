/*
package com.sun.jia.leecode;

import com.sun.jia.leecode.mook.Dp;
import com.sun.jia.leecode.mook.Permute;
import com.sun.jia.leecode.sort.LeeCodeSort;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class LeeCodeApplicationTests {


    @Test
    void contextLoads() {
        int[] nums = new int[]{1, 1, 2};

        char[][] board = new char[][]{
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'}
        };


        int[][] heights = new int[][]{
                {1, 2, 2, 3, 5},
                {3, 2, 3, 4, 4},
                {2, 4, 5, 3, 1},
                {6, 7, 1, 4, 5},
                {5, 1, 1, 2, 4}
        };

        int[][] trangle = new int[][]{
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };
        Permute permute = new Permute();

        Dp dp = new Dp();
//        List<List<Integer>> list = permute.pacificAtlantic(heights);
//        permute.isCan(heights,1,3,3,4);
        dp.minPathSum(trangle);
        System.out.println("运行结束");
    }

}
*/
