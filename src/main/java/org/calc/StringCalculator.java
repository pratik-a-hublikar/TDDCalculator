package org.calc;

import org.apache.commons.lang3.StringUtils;

public class StringCalculator {

    public int add(String numbers){
        int finalAddition=0;
        if(StringUtils.isEmpty(numbers)){
            return finalAddition;
        }
        String regex=",";
        String[] numberList = numbers.split(regex);
        for(String number:numberList){
            finalAddition+=Integer.parseInt(number);
        }
        return finalAddition;
    }
}
