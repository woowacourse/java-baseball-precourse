package utils;

import java.util.ArrayList;
import java.util.List;

public class NumberListGenerator {

    public static ArrayList<Integer> convertNumberList(String inputNumber){
        ArrayList<Integer> numberList = new ArrayList<>();
        for(char num : inputNumber.toCharArray()){
            numberList.add(Character.getNumericValue(num));
        }
        return numberList;
    }
}
