package utils;

import baseball.Numbers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class NumbersFactory {

    public static Numbers createNumbers(String num) throws IllegalArgumentException {
        InputValidator.checkValidNumbers(num, Numbers.DIGITS);

        List numberList = Arrays.stream(num.split(""))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        return new Numbers(numberList);
    }

    public static Numbers createRandomNumbers() {
        List<Integer> numberList = new ArrayList<>();

        while (numberList.size()< Numbers.DIGITS){
            numberList.add(getRandWithoutDuplicate(numberList));
        }

        return new Numbers(numberList);
    }

    private static int getRandWithoutDuplicate(List<Integer> list) {
        int rand;

        do {
            rand = RandomUtils.nextInt(Numbers.MIN, Numbers.MAX);
        } while (list.contains(rand));

        return rand;
    }
}
