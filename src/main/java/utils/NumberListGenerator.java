package utils;

import java.util.ArrayList;
import java.util.List;

public class NumberListGenerator {
    private static final int MAX_NUM = 9;
    private static final int MIN_NUM = 1;

    public static ArrayList<Integer> makeTargetNumList(int NUM_DIGIT){
        ArrayList<Integer> newTargetNumber = new ArrayList<>();

        for(int i=0; i<NUM_DIGIT; i++){
            int rand = getRandWithoutDuplicate(newTargetNumber);
            newTargetNumber.add(rand);
        }

        return newTargetNumber;
    }

    private static int getRandWithoutDuplicate(List<Integer> targetNumList){
        int rand;

        do{
            rand = RandomUtils.nextInt(MIN_NUM, MAX_NUM);
        }
        while(targetNumList.contains(rand));

        return rand;
    }

    public static ArrayList<Integer> stringToList(String stringNumber){
        ArrayList<Integer> numberList = new ArrayList<>();

        for(char num : stringNumber.toCharArray()){
            numberList.add(Character.getNumericValue(num));
        }

        return numberList;
    }
}
