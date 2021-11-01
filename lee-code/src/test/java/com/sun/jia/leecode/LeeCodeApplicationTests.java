package com.sun.jia.leecode;

import com.sun.jia.leecode.sort.LeeCodeSort;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class LeeCodeApplicationTests {

    @Test
    void contextLoads() {
        int [] nums = new int[]{0,0,1};
        LeeCodeSort.moveZeroes(nums);
        System.out.println("运行结束");
    }

}
