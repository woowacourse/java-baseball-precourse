package utils;

import java.util.ArrayList;
import java.util.Collections;

public class ConvertUtils {
    public static ArrayList<Integer> toDigitArrayList(Integer number){
        int temp=number;
        ArrayList<Integer> digitArrayList=new ArrayList<>();
        while(temp>0){
            digitArrayList.add(temp%10);
            temp/=10;
        }
        Collections.reverse(digitArrayList);
        return digitArrayList;
    }
}