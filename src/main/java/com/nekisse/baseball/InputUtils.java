package com.nekisse.baseball;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputUtils {

    static BaseballNumbers convertInputToBaseBallNumbersAndDuplicateNumberCheck(String inputNumber) {
        List<Number> userBaseBallNumbers = new ArrayList<>();
        Set<Number> duplicateNumbers = new HashSet<>();
        String[] split = inputNumber.split("");
        if (split.length != 3) {
            throw new IllegalArgumentException("3자리의 숫자여야 합니다.");
        }
        getBaseBallNumber(userBaseBallNumbers,duplicateNumbers, split);
        duplicateNumberChecking(userBaseBallNumbers, duplicateNumbers);
        return new BaseballNumbers(userBaseBallNumbers);
    }

    private static void getBaseBallNumber(List<Number> userBaseBallNumbers, Set<Number> duplicateNumbers, String[] split) {
        for (String number : split) {
            duplicateNumbers.add(Number.getNumber(Integer.parseInt(number)));
            userBaseBallNumbers.add(Number.getNumber(Integer.parseInt(number)));
        }
    }

    private static void duplicateNumberChecking(List<Number> userBaseBallNumbers, Set<Number> duplicateNumbers) {
        if (duplicateNumbers.size() != userBaseBallNumbers.size()) {
            throw new IllegalArgumentException("중복은 불가능 합니다.");
        }
    }
}
