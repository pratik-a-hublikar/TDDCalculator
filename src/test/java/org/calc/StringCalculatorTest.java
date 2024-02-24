package org.calc;


import static org.junit.Assert.*;
import org.junit.Test;

public class StringCalculatorTest {


        @Test
        public void addEmptyString(){
                StringCalculator stringCalculator = new StringCalculator();
                int add = stringCalculator.add("");
                assertEquals(0,add);
        }

        @Test
        public void addSingleString(){
                StringCalculator stringCalculator = new StringCalculator();
                int add1 = stringCalculator.add("3,3,5");
                int add2 = stringCalculator.add("3,4,5");
                assertEquals(11,add1);
                assertEquals(12,add2);

        }
}
