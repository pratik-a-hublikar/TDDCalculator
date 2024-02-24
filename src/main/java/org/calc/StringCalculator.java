package org.calc;

import org.apache.commons.lang3.StringUtils;

public class StringCalculator {

    public int[] add(String... numbers){
        int[] additionList =new int[numbers.length];
        for(int i=0;i<numbers.length;i++){
            additionList[i]= getAddition(numbers[i]);

        }
        return additionList;
    }

    private static int getAddition(String numbers) {
        int finalAddition=0;
        if(StringUtils.isEmpty(numbers)){
            return finalAddition;
        }
        String regex;
        if(numbers.startsWith("//")){
            String[] split = numbers.split("\n");
            regex=split[0].substring(2);
            numbers=split[1];
        }else{
            regex=",|\n";
        }
        String[] numberList = numbers.split(regex);
        for(String number:numberList){
            finalAddition+=Integer.parseInt(number);
        }
        return finalAddition;
    }
}
