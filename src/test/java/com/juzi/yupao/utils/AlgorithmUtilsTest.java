package com.juzi.yupao.utils;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AlgorithmUtilsTest {


    @Test
    void testMinDistance() {
        List<String> tagList1 = Arrays.asList("Java","大一","男");
        List<String> tagList2 = Arrays.asList("Java","大二","女");
        List<String> tagList3 = Arrays.asList("Python","大二","女");

        int score1 = AlgorithmUtils.minDistance(tagList1, tagList2);
        int score2 = AlgorithmUtils.minDistance(tagList1, tagList3);

        System.out.println("score1 = " + score1);
        System.out.println("score2 = " + score2);
    }
}