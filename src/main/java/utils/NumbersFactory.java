package utils;

import baseball.Numbers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class NumbersFactory {
    private static final int NUMBER_MAX = 9;
    private static final int NUMBER_MIN = 1;

    public static Numbers getRandomNumbers(int digits){
        List<Integer> numberList = new ArrayList<>();

        while(numberList.size()<digits){
            numberList.add(getRandWithoutDuplicate(numberList));
        }

        return new Numbers(numberList);
    }

    private static int getRandWithoutDuplicate(List<Integer> list){
        int rand;
        do{
            rand = RandomUtils.nextInt(NUMBER_MIN, NUMBER_MAX);
        }
        while(list.contains(rand));

        return rand;
    }

    public static Numbers parseStringToNumbers(String num){
        List numberList = Arrays.stream(num.split(""))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        return new Numbers(numberList);
    }
}
