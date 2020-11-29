/*
 * InputNumbers.java            0.9       2020-11-25
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
 * 값의 유효성을 판단하고 형 변환해주는 클래스
 *
 * @author 조연우
 * @version 1.0 2020년 11월 25일
 */
public class NumbersValidator {
    private static final int INVALID_NUMBER = 0;

    private final List<Integer> validNumbers = new ArrayList<>();

    public List<Integer> makeValidNumbers(String invalidNumbers) {
        addDeduplicatedNumbers(invalidNumbers);
        checkInvalidWithZero();
        checkValidWithLengthThree();
        return this.validNumbers;
    }

    private void addDeduplicatedNumbers(String invalidNumbers) {
        for (Character c : invalidNumbers.toCharArray()) {
            this.validNumbers.add(deduplicateNumber(Character.getNumericValue(c)));
        }
    }

    private int deduplicateNumber(int number) {
        if (this.validNumbers.contains(number)) {
            throw new IllegalArgumentException("서로 다른 세개의 숫자를 입력해야 합니다.");
        }
        return number;
    }

    private void checkInvalidWithZero() {
        if (this.validNumbers.stream().anyMatch(i -> i.equals(INVALID_NUMBER))) {
            throw new IllegalArgumentException("0은 입력할 수 없습니다.");
        }
    }

    private void checkValidWithLengthThree() {
        if (this.validNumbers.size() != NUMBER_LIST_SIZE) {
            throw new IllegalArgumentException("숫자는 3개를 입력해야 합니다.");
        }
    }

}
