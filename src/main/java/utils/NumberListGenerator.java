package utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class NumberListGenerator {
    private static final int MAX_NUMBER = 9;
    private static final int MIN_NUMBER = 1;

    public static ArrayList<Integer> makeTargetNumList(int digits){
        ArrayList<Integer> list = new ArrayList<>();

        while(list.size()<digits){
            list.add(getRandWithoutDuplicate(list));
        }
        
        return list;
    }

    private static int getRandWithoutDuplicate(List<Integer> list){
        int rand;

        do{
            rand = RandomUtils.nextInt(MIN_NUMBER, MAX_NUMBER);
        }
        while(list.contains(rand));

        return rand;
    }

    public static List<Integer> ConvertStringToList(String num){
        return Arrays.stream(num.split("")).map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
