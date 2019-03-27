package com.nekisse.baseball;

import java.util.ArrayList;
import java.util.List;

public class BaseballNumbers {
    private List<Number> threeNumber;

    public BaseballNumbers(List<Number> threeNumber) {
        if (threeNumber.size() != 3) {
            throw new IllegalArgumentException("중복되지 않은 3자리의 숫자여야 합니다.");
        }
        this.threeNumber = threeNumber;

    }



    public List<Number> getThreeNumber() {
        return threeNumber;
    }

    public Number getNumber(int index) {
        return threeNumber.get(index);
    }


    public static BaseballNumbers of(int... ints) {
        List<Number> test = new ArrayList<>();
        for (int anInt : ints) {
            test.add(Number.getNumber(anInt));
        }
        return new BaseballNumbers(test);
    }
}
