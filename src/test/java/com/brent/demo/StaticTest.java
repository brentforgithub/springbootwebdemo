package com.brent.demo;

import org.junit.Test;

public class StaticTest {

    @Test
    public void longTest(){
        long multiplier = 0x5DEECE66DL;
        long addend = 0xBL;
        long mask = (1L << 48) - 1;
        System.out.println(multiplier);
        System.out.println(addend);
        System.out.println(mask);
    }
}
