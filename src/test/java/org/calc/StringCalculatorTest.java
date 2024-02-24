package org.calc;


import static org.junit.Assert.*;
import org.junit.Test;

import java.util.Arrays;

public class StringCalculatorTest {


        @Test
        public void addEmptyString(){
                StringCalculator stringCalculator = new StringCalculator();
                int[] add = stringCalculator.add("");
                assertEquals(0,add[0]);
        }

        @Test
        public void addSingleString(){
                StringCalculator stringCalculator = new StringCalculator();
                int[] add1 = stringCalculator.add("3,3,5");
                int[] add2 = stringCalculator.add("3,4,5");
                assertEquals(11,add1[0]);
                assertEquals(12,add2[0]);
        }


        @Test
        public void addMultipleString(){
                StringCalculator stringCalculator = new StringCalculator();
                int[] add1 = stringCalculator.add("3,3,5","1,2,3,4,5");
                int[] add2 = stringCalculator.add("3,4,5","");
                assertArrayEquals(new int [] {11, 15},add1);
                assertArrayEquals(new int[]{12, 0}, add2);
        }
}
