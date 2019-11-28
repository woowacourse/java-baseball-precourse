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
 * @version 1.2         최댓값 제한 fianl 상수 구현,
 *                      threeDigitNumbers -> digitNumbers 수정
 * @date 2019-11-28
 */
public class Opponent {
    private final int INF_MASK = 10;    // 마스크 크기 0 ~ 9
    private final int INF_DIGIT = 3;    // 최대 자릿수
    private boolean[] digitMasks;       // 수 마스킹용 array
    private int[] digitNumbers;    // 생각한 수 array

    public Opponent() {
        this.digitMasks = new boolean[INF_MASK];
        this.digitNumbers = new int[INF_DIGIT];
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
