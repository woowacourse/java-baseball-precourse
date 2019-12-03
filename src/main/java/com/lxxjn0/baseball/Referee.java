/*
 * @(#)Referee.java        0.7 2019/12/03
 *
 * Copyright (c) 2019 lxxjn0.
 */
package com.lxxjn0.baseball;

import java.util.ArrayList;

/**
 * 스트라이크와 볼의 개수를 확인하고 낫싱 여부를 판단하는 클래스.
 *
 * @author JUNYOUNG LEE (lxxjn0)
 * @version 0.7 2019/12/03
 */
public class Referee {
    /** 생성된 수와 입력된 수의 길이에 해당하는 상수 */
    private static final int NUM_LEN = 3;
    /** 스트라이크와 볼의 개수로 낫싱을 판단할 때 사용할 상수 */
    private static final int COUNT_ZERO = 0;
    /** 컴퓨터가 생성한 3자리 수를 저장할 ArrayList */
    private ArrayList<Integer> generatedNumber;
    /** 사용자가 입력한 3자리 수를 저장할 ArrayList */
    private ArrayList<Integer> enteredNumber;
    /** 스트라이크의 개수를 저장할 변수 */
    private int strikeNumber;
    /** 볼의 개수를 저장할 변수 */
    private int ballNumber;

    /**
     * 컴퓨터가 생성한 3자리 수와 사용자가 입력한 3자리 수를 매개변수로 받아와 저장하는 Referee 생성자.
     * generatedNumber와 enteredNumber를 매개변수로 받아오면서 바로 스트라이크와 볼의 개수를 저장.
     *
     * @param generatedNumber  컴퓨터가 생성한 3자리 수
     * @param enteredNumber 사용자가 입력한 3자리 수
     */
    public Referee(ArrayList<Integer> generatedNumber,
                   ArrayList<Integer> enteredNumber) {
        this.generatedNumber = generatedNumber;
        this.enteredNumber = enteredNumber;

        countStrikes();
        countBalls();
    }

    /**
     * 같은 자리에 같은 숫자인지 판단하여 스트라이크의 개수를 저장하는 메서드.
     */
    private void countStrikes() {
        for (int i = 0; i < NUM_LEN; i++) {
            if (isStrike(i)) {
                strikeNumber++;
            }
        }
    }

    /**
     * position 위치에 enteredNumber와 generatedNumber의 숫자가 같은지를 판단하는 메서드.
     *
     * @param position 스트라이크인지 여부를 확인하려는 enteredNumber, generatedNumber의 위치.
     * @return position 위치 enteredNumber가 스트라이크이면 true 반환.
     */
    private boolean isStrike(int position) {
        return enteredNumber.get(position).equals(generatedNumber.get(position));
    }

    /**
     * 다른 자리에 같은 숫자인지 판단하여 볼의 개수를 저장하는 메서드.
     */
    private void countBalls() {
        for (int i = 0; i < NUM_LEN; i++) {
            if (isBall(i)) {
                ballNumber++;
            }
        }
    }

    /**
     * position 위치에 enteredNumber의 숫자가
     * 다른 자리의 generatedNumber의 숫자와 같은지를 판단하는 메서드.
     *
     * @param position 볼인지 여부를 확인하려는 enteredNumber의 위치 position
     * @return position 위치의 enteredNumber 숫자가 볼이면 true 반환.
     */
    private boolean isBall(int position) {
        if (!isStrike(position)) {
            return generatedNumber.contains(enteredNumber.get(position));
        }
        return false;
    }

    /**
     * 스트라이크와 볼의 개수를 통해 낫싱인지 여부를 판단하는 메서드.
     *
     * @return 낫싱일 경우 true 반환.
     */
    public boolean judgeNothing() {
        return ((strikeNumber == COUNT_ZERO) && (ballNumber == COUNT_ZERO));
    }

    /**
     * strikeNumber getter
     *
     * @return 스트라이크의 개수를 반환.
     */
    public int getStrikeNumber() {
        return strikeNumber;
    }

    /**
     * ballNumber getter
     *
     * @return 볼의 개수를 반환.
     */
    public int getBallNumber() {
        return ballNumber;
    }
}
