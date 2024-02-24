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
}
