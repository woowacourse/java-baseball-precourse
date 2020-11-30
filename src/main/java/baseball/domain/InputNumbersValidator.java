/*
 * InputNumbers.java            1.0       2020-11-25
 *
 * Copyright (c) 2020 Yeonwoo Cho
 * ComputerScience, ProgrammingLanguage, Java, Seoul, KOREA
 * All rights reserved
 */

package baseball.domain;

import java.util.ArrayList;
import java.util.List;

import static baseball.domain.RandomNumbers.NUMBER_LIST_SIZE;

/**
 * 인풋 값의 유효성을 판단하고 형 변환해주는 클래스
 *
 * @author 조연우
 * @version 1.0 2020년 11월 25일
 */
public class InputNumbersValidator {
    private static final int INVALID_NUMBER = 0;

    public List<Integer> makeInputNumbers(String inputData) {
        final List<Integer> inputNumbers = addDistinctNumbers(inputData);
        checkInvalidWithZero(inputNumbers);
        checkValidWithLengthThree(inputNumbers);
        return inputNumbers;
    }

    private List<Integer> addDistinctNumbers(String inputData) {
        final List<Integer> inputNumbers = new ArrayList<>();
        for (Character c : inputData.toCharArray()) {
            inputNumbers.add(checkDistinctNumber(inputNumbers, Character.getNumericValue(c)));
        }
        return inputNumbers;
    }

    private int checkDistinctNumber(List<Integer> inputNumbers, int convertNumber) {
        if (inputNumbers.contains(convertNumber)) {
            throw new IllegalArgumentException("서로 다른 세개의 숫자를 입력해야 합니다.");
        }
        return convertNumber;
    }

    private void checkInvalidWithZero(List<Integer> inputNumbers) {
        if (inputNumbers.stream().anyMatch(i -> i.equals(INVALID_NUMBER))) {
            throw new IllegalArgumentException("0은 입력할 수 없습니다.");
        }
    }

    private void checkValidWithLengthThree(List<Integer> inputNumbers) {
        if (inputNumbers.size() != NUMBER_LIST_SIZE) {
            throw new IllegalArgumentException("숫자는 3개를 입력해야 합니다.");
        }
    }
}
