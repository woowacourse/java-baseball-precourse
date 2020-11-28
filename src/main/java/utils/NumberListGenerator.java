package utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class NumberListGenerator {
    private static final int NUMBER_MAX = 9;
    private static final int NUMBER_MIN = 1;

    public static ArrayList<Integer> makeTargetNumber(int digits){
        ArrayList<Integer> targetNumber = new ArrayList<>();

        while(targetNumber.size()<digits){
            targetNumber.add(getRandWithoutDuplicate(targetNumber));
        }
        
        return targetNumber;
    }

    private static int getRandWithoutDuplicate(List<Integer> list){
        int rand;

        do{
            rand = RandomUtils.nextInt(NUMBER_MIN, NUMBER_MAX);
        }
        while(list.contains(rand));

        return rand;
    }

    public static List<Integer> ConvertStringToList(String num){
        return Arrays.stream(num.split(""))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
