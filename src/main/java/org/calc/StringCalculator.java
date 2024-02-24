package org.calc;

import org.apache.commons.lang3.StringUtils;
import org.calc.exception.NegativeNumberException;

import java.text.MessageFormat;
import java.util.ArrayList;

public class StringCalculator {

    public Object[] add(String... numbers){
        Object[] additionList =new Object[numbers.length];
        for(int i=0;i<numbers.length;i++){
            try{
                additionList[i] = getAddition(numbers[i]);
            }catch (NegativeNumberException e){
                additionList[i] = e.getMessage();
            }
        }
        return additionList;
    }

    private static int getAddition(String numbers) {
        int finalAddition=0;
        if(StringUtils.isEmpty(numbers)){
            return finalAddition;
        }
        String regex;
//        String[] dandlingChar= new String[]{".","*"};
        if(numbers.startsWith("//")){
            String[] split = numbers.split("\n");
            regex=split[0].substring(2);
            while(regex.contains("[") && regex.contains("]")){
                regex=removeSquareBracket(regex);
            }
            if(regex.equals(".") || regex.contains("*")){
                regex= regex.replaceAll("\\.", "\\\\.");
                regex= regex.replaceAll("\\*", "\\\\*");
            }
            numbers=split[1];
        }else{
            regex=",|\n";
        }
        ArrayList<Integer> negativeNumberList = new ArrayList<>();
        String[] numberList = numbers.split(regex);
        for(String number:numberList){
            if(!StringUtils.isEmpty(number)){
                int intNumber = Integer.parseInt(number);
                if(intNumber<0){
                    negativeNumberList.add(intNumber);
                }
                if(intNumber>1000){
                    intNumber=0;
                }
                finalAddition+=intNumber;
            }
        }
        if(!negativeNumberList.isEmpty()){
            throw new NegativeNumberException("negatives not allowed "+negativeNumberList);
        }
        return finalAddition;
    }

    static String removeSquareBracket(String str) {
        int startIdx = str.indexOf("[");
        int endIdx = str.indexOf("]");
        String content="";
        if(startIdx > 0){
            content = str.substring(0, startIdx);
            if(content.charAt(content.length()-1)!= '|'){
                content += "|";
            }
        }
        content += str.substring(startIdx + 1, endIdx);
        if(endIdx < str.length()-1){
            content += "|";
            content += str.substring(endIdx+1,str.length());
        }
        return content;
    }
}
