/*
 * Opponent.java                     1.0   2019-11-28
 *
 * Copyright (c) 2019 Hyungju An.
 * All rights reserved.
 * Contact me for more information. a301dks@naver.com
 */
package com.precourse.baseball;

/**
 * 상대방(컴퓨터) 클래스입니다.
 * 1부터 9까지 서로 다른 수로 이루어진 3자리의 수를 랜덤하게 만들고
 * 플레이어가 예측에 틀릴 경우 힌트를 줍니다.
 *
 * @author HyungjuAn
 * @version 1.3        랜덤으로 서로 다른 세자리의 수를 만드는 기능 구현
 * @date 2019-11-28
 */
public class Opponent {
    private final int ZERO = 0;
    private final int TEN = 10;
    private final int MAX_MASK = 10;    // 마스크 크기 0 ~ 9
    private final int MAX_DIGIT = 3;    // 최대 자릿수
    private boolean[] digitMasks;       // 수 마스킹용 array
    private int[] digitNumbers;         // 생각한 수 array

    public Opponent() {
        this.digitMasks = new boolean[MAX_MASK];
        this.digitNumbers = new int[MAX_DIGIT];
    }

    public void setRandomNumbers() {
        setDigitMasks(new boolean[MAX_MASK]);                 // digitMasks 초기화

        for (int i = 0; i < MAX_DIGIT; i++) {
            digitNumbers[i] = (int) (Math.random() * TEN);    // 0 ~ 9 까지
            digitMasks[digitNumbers[i]] = true;
        }

        if (!isValidNumbers() || isDuplicate()) {
            setRandomNumbers();                               // 만든 세자리의 수가 유효하지 않는 경우
        }
    }

    public boolean isValidNumbers() {
        boolean result = true;

        for (int i = 0; i < MAX_DIGIT; i++) {
            if (digitNumbers[i] == ZERO) {
                result = false;
                break;
            }
        }

        return result;
    }

    public boolean isDuplicate() {
        boolean result = false;
        int count = 0;

        for (int i = 0; i < MAX_MASK; i++) {
            if (digitMasks[i]) {
                count++;
            }
        }
        if (count < MAX_DIGIT) {
            result = true;
        }

        return result;
    }

    /* Getter Methods */
    public boolean[] getDigitMasks() {
        return this.digitMasks;
    }

    public int[] getDigitNumbers() {
        return this.digitNumbers;
    }

    /* Setter Methods */
    public void setDigitMasks(boolean[] digitMasks) {
        for (int i = 0; i < digitMasks.length; i++) {
            this.digitMasks[i] = digitMasks[i];
        }
    }

    public void setDigitNumbers(int[] digitNumbers) {
        for (int i = 0; i < digitNumbers.length; i++) {
            this.digitNumbers[i] = digitNumbers[i];
        }
    }
}
