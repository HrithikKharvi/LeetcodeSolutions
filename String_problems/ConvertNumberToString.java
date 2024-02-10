package com.example;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ConvertNumberToString {
    public static final String[] smalls = new String[]{"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine",
                                            "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
    public static final String[] tens = new String[]{"", "ten", "twenty", "thirty", "fourty", "fifty", "sixty", "seventy", "eighty", "ninety"};
    public static final String[] bigs = new String[]{"", "thousand", "lakh"};

    public static final String hundred = "hundred";
    public static final String crore = "crore";

    public static String translateNumber(int num){
        LinkedList<String> list = new LinkedList<>();
        int count = 0;

        while(num > 0){
            if(count == 0){
                if(num % 1000 != 0){
                    String currentString = convertToString(num % 1000) + " " +bigs[count];
                    list.addFirst(currentString);
                }
                count++;
                num = num / 1000;
            }else if(count >= 3){
                String currentString = translateNumber(num % 100) + " " + crore;
                list.addFirst(currentString);
                break;
            }else{
                if(num % 100 != 0){
                    String currentString = convertToString(num % 100) + " " + bigs[count];
                    list.addFirst(currentString);
                }

                count++;
                num = num / 100;
            }
        }

        return convertListToString(list);
    }

    public static String convertToString(int num){
        LinkedList<String> list = new LinkedList<>();

        if(num >= 100){
            list.addFirst(smalls[num/100]);
            list.addLast(hundred);
            num = num % 100;
        }

        if(num >= 10 && num <= 19){
            list.addLast(smalls[num]);
        }else{
            list.addLast(tens[num/10]);
            num %= 10;
        }

        if(num >= 1 && num <= 9){
            list.addLast(smalls[num]);
        }

        return convertListToString(list);
    }

    public static String convertListToString(LinkedList<String> list){
        StringBuilder sb = new StringBuilder();

        while(list.size() > 1){
            sb.append(list.pop()).append(" ");
        }
        sb.append(list.pop());

        return sb.toString();
    }

}
