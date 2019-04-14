package com.teco;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 난수 3자리를 저장하는 클래스
 *
 * @author 김성훈
 * @version 1.0
 */
public class RandomNumbers {
    private static final int RANDOM_NUMBER_SIZE = 3;

    private final Set<Integer> randomNumbers;

    RandomNumbers(Set<Integer> randomNumbers) {
        if (randomNumbers.size() != RANDOM_NUMBER_SIZE) {
            throw new IllegalArgumentException("중복된 숫자는 입력할 수 없습니다.");
        }
        this.randomNumbers = randomNumbers;
    }

    Map<Integer, Integer> setRandomNumbersToMap() {
        Map<Integer, Integer> randomNumbersMap = new HashMap<>();
        int numberPosition = 1;
        for (Integer randomNumber : randomNumbers) {
            randomNumbersMap.put(numberPosition++, randomNumber);
        }
        return randomNumbersMap;
    }
}
