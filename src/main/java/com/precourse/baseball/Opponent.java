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
 * @version 1.1         getter/setter methods 구현
 * @date 2019-11-28
 */
public class Opponent {
    private boolean[] digitMasks;
    private int[] threeDigitNumbers;

    public Opponent() {
        this.digitMasks = new boolean[10];
        this.threeDigitNumbers = new int[3];
    }

    public boolean[] getDigitMasks() {
        return this.digitMasks;
    }

    public int[] getThreeDigitNumbers() {
        return this.threeDigitNumbers;
    }

    public void setDigitMasks(boolean[] digitMasks) {
        for (int i = 0; i < digitMasks.length; i++) {
            this.digitMasks[i] = digitMasks[i];
        }
    }

    public void setThreeDigitNumbers(int[] threeDigitNumbers) {
        for (int i = 0; i < threeDigitNumbers.length; i++) {
            this.threeDigitNumbers[i] = threeDigitNumbers[i];
        }
    }
}
