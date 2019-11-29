/*
 * Player.java                     2.3.1   2019-11-29
 *
 * Copyright (c) 2019 Hyungju An.
 * All rights reserved.
 * Contact me for more information. a301dks@naver.com
 */
package com.precourse.baseball;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 플레이어 클래스입니다.
 * 1부터 9까지 서로 다른 수로 이루어진 3자리의 수를 랜덤하게 만들고
 * 상대 플레이어의 수를 예측할 수 있습니다.
 * 상대 플레이어가 예측에 틀릴 경우 힌트를 줍니다.
 *
 * @author HyungjuAn
 * @version 2.3.1        자릿수 체크하는 기능 추가
 * @date 2019-11-29
 */
public class Player {
    private final String BALL = "볼";
    private final String STRIKE = "스트라이크";
    private final String NOTHING = "낫싱";
    private final String SPACE = " ";

    private final int ZERO = 0;
    private final int TEN = 10;
    private final int MAX_MASK = 10;    // 마스크 크기 0 ~ 9
    private final int MAX_DIGIT = 3;    // 최대 자릿수

    private boolean[] digitMasks;       // 수 마스킹용 array
    private int[] digitNumbers;         // 생각한 수 array

    public Player() {
        this.digitMasks = new boolean[MAX_MASK];
        this.digitNumbers = new int[MAX_DIGIT];
    }

    public void readNumbers() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("숫자를 입력해주세요: ");
        char[] input = br.readLine().toCharArray();
        if (!isRightDigit(input)) {
            printWrongInputMessage();
            readNumbers();
            return;
        }

        for (int i = 0; i < MAX_DIGIT; i++) {
            digitNumbers[i] = Character.getNumericValue(input[i]);
        }

        if (!isValidNumbers() || isDuplicate()) {
            printWrongInputMessage();
            readNumbers();
            return;
        }
    }

    public boolean isRightDigit(char[] input) {
        boolean result = false;

        if (input.length == MAX_DIGIT) {
            result = true;
        }

        return result;
    }

    public void printWrongInputMessage() {
        System.out.println("ERROR! 1부터 9까지의 서로 다른 수로 이루어진 " + MAX_DIGIT + "자리의 수를 입력해주세요.");
    }

    public String giveHintAboutNumbers(int[] numbers) {
        StringBuilder hint = new StringBuilder();
        int strikeCount = ZERO;
        int ballCount = ZERO;

        for (int i = 0; i < MAX_DIGIT; i++) {
            if (digitNumbers[i] == numbers[i]) {
                strikeCount++;
            } else if ((digitNumbers[i] != numbers[i]) && digitMasks[numbers[i]]) {
                ballCount++;
            }
        }

        if (strikeCount + ballCount == ZERO) {
            hint.append(NOTHING);
        } else if (strikeCount == ZERO) {
            hint.append(ballCount).append(BALL);
        } else if (ballCount == ZERO) {
            hint.append(strikeCount).append(SPACE).append(STRIKE);
        } else {
            hint.append(strikeCount).append(SPACE).append(STRIKE).append(SPACE).append(ballCount).append(BALL);
        }

        return hint.toString();
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
        int count = ZERO;

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
