package org.calc;


import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class StringCalculatorTest {


        @Test
        public void addEmptyString(){
                StringCalculator stringCalculator = new StringCalculator();
                Object[] add = stringCalculator.add("");
                assertEquals(0,add[0]);
        }

        @Test
        public void addSingleString(){
                StringCalculator stringCalculator = new StringCalculator();
                Object[] add1 = stringCalculator.add("3,3,5");
                Object[] add2 = stringCalculator.add("3,4,5");
                assertEquals(11,add1[0]);
                assertEquals(12,add2[0]);
        }


        @Test
        public void addMultipleString(){
                StringCalculator stringCalculator = new StringCalculator();
                Object[] add1 = stringCalculator.add("3,3,5","1,2,3,4,5");
                Object[] add2 = stringCalculator.add("3,4,5","");
                assertArrayEquals(new Object[] {11, 15},add1);
                assertArrayEquals(new Object[]{12, 0}, add2);
        }

        @Test
        public void addMultipleStringWithNewLineAsTheDelimiter(){
                StringCalculator stringCalculator = new StringCalculator();
                Object[] add1 = stringCalculator.add("3\n3,5","1\n2,3,4\n5");
                Object[] add2 = stringCalculator.add("3,4,5","3\n4");
                assertArrayEquals(new Object[] {11, 15},add1);
                assertArrayEquals(new Object[]{12, 7}, add2);
        }

        @Test
        public void addMultipleStringWithCustomDelimiter(){
                StringCalculator stringCalculator = new StringCalculator();
                Object[] add1 = stringCalculator.add("//:\n3:3:5");
                Object[] add2 = stringCalculator.add("//,\n3,4,5","//-\n3-4");
                assertArrayEquals(new Object[] {11},add1);
                assertArrayEquals(new Object[]{12, 7}, add2);
        }

        @Test
        public void addMultipleStringWithCustomDelimiterWithIgnoringMinusSignIfThatIsAPartOfTheDelimiter(){
                StringCalculator stringCalculator = new StringCalculator();
                Object[] add1 = stringCalculator.add("//:;-\n3:;-3:;-5");
                Object[] add2 = stringCalculator.add("//,-\n3,-4,-5","//-\n3-4");
                Object[] add3 = stringCalculator.add("//[***]\n1***2***3");
                Object[] add4 = stringCalculator.add("//[*][%]\n1*2%3");
                assertArrayEquals(new Object[] {11},add1);
                assertArrayEquals(new Object[]{12, 7}, add2);
                assertArrayEquals(new Object[]{6}, add3);
                assertArrayEquals(new Object[]{6}, add4);
        }


        @Test
        public void addNegativeNumbers(){
                StringCalculator stringCalculator = new StringCalculator();
                Object[] add1 = stringCalculator.add("//:;\n3:;-3:;-5");
                Object[] add2 = stringCalculator.add("//,\n3,4,-5","//.\n-3.-4");
                assertArrayEquals(new Object[] {"negatives not allowed [-3, -5]"},add1);
                assertArrayEquals(new Object[]{"negatives not allowed [-5]", "negatives not allowed [-3, -4]"}, add2);
        }

}
