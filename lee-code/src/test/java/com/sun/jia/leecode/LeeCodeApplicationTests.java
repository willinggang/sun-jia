package com.sun.jia.leecode;

import com.sun.jia.leecode.mook.Permute;
import com.sun.jia.leecode.sort.LeeCodeSort;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class LeeCodeApplicationTests {


    @Test
    void contextLoads() {
        int [] nums = new int[]{1,1,2};
        Permute permute = new Permute();
        List<List<Integer>> list = permute.combinationSum3(3, 9);
        System.out.println("运行结束");
    }

}
