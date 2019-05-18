package com.teco;

import java.util.Map;

/**
 * 난수 하나의 정보를 담는 클래스
 *
 * @author 김성훈
 * @version 1.0
 */
public class RandomNumber {
    private static final int NUMBER_MIN = 1;
    private static final int NUMBER_MAX = 9;

    private final int randomNumber;

    RandomNumber(int randomNumber) {
        if (randomNumber < NUMBER_MIN || randomNumber > NUMBER_MAX) {
            throw new IllegalArgumentException("각 자리 수의 범위는 1에서 9사이입니다.");
        }
        this.randomNumber = randomNumber;
    }

    int getRandomNumber() {
        return this.randomNumber;
    }
}
