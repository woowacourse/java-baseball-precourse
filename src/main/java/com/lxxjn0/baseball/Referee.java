/*
 * @(#)Referee.java        0.4 2019/12/02
 *
 * Copyright (c) 2019 lxxjn0.
 */
package com.lxxjn0.baseball;

import java.util.ArrayList;

/**
 * 스트라이크와 볼의 개수를 확인하고 낫싱 여부를 판단하는 클래스.
 *
 * @version         0.4 2019/12/02
 * @author          JUNYOUNG LEE (lxxjn0)
 */
public class Referee {
    /** 입력해야 하는 수의 길이를 저장한 상수 */
    private static final int NUM_LEN = 3;
    /** 스트라이크와 볼의 개수로 낫싱을 판단할 때 사용할 상수 */
    private static final int COUNT_ZERO = 0;
    /** 컴퓨터가 생성한 3자리 수를 저장할 ArrayList */
    private ArrayList<Integer> comNumList;
    /** 사용자가 입력한 3자리 수를 저장할 ArrayList*/
    private ArrayList<Integer> userNumList;
    /** 스트라이크의 개수를 저장할 변수 */
    private int countStrike;
    /** 볼의 개수를 저장할 변수 */
    private int countBall;

    /**
     * 컴퓨터가 생성한 3자리 수와 사용자가 입력한 3자리 수를 매개변수로 받아와 저장하는 Referee 생성자.
     * comNumList와 userNumList를 매개변수로 받아오면서 바로 스트라이크와 볼의 개수를 저장.
     * @param comNumList 컴퓨터가 생성한 3자리 수
     * @param userNumList 사용자가 입력한 3자리 수
     */
    public Referee(ArrayList<Integer> comNumList, ArrayList<Integer> userNumList) {
        this.comNumList = comNumList;
        this.userNumList = userNumList;

        countStrikeNum();;
        countBallNum();
    }

    /**
     * 같은 자리에 같은 숫자인지 판단하여 스트라이크의 개수를 저장하는 메서드.
     */
    private void countStrikeNum() {
        for(int i = 0; i < NUM_LEN; i++) {
            if(isStrike(i)) {
                countStrike++;
            }
        }
    }

    /**
     * index 위치의 userNumList의 숫자가 같은 자리의 comNumList의 숫자와 같은지를 판단하는 메서드.
     * @param index 스트라이크인지 여부를 확인하려는 numList의 위치 index.
     * @return index의 위치 userNumList가 스트라이크이면 true를 반환.
     */
    private boolean isStrike(int index) {
        return (userNumList.get(index).equals(comNumList.get(index)));
    }

    /**
     * 다른 자리에 같은 숫자인지 판단하여 볼의 개수를 저장하는 메서드.
     * @return 볼의 개수를 반환한다.
     */
    private void countBallNum() {
        for(int i = 0; i < NUM_LEN; i++) {
            if(isBall(i)) {
                countBall++;
            }
        }
    }

    /**
     * index 위치의 userNumList의 숫자가 다른 자리의 comNumList의 숫자와 같은지를 판단하는 메서드.
     * @param index 볼인지 여부를 확인하려는 numList의 위치 index
     * @return index 위치의 userNumList 숫자가 볼이면 true를 반환.
     */
    private boolean isBall(int index) {
        boolean isBallCheck = false;

        if(!isStrike(index)) {
            isBallCheck = (comNumList.contains(userNumList.get(index)));
        }
        return isBallCheck;
    }

    /**
     * 스트라이크와 볼의 개수를 통해 낫싱인지 여부를 판단하는 메서드.
     * @return 낫싱일 경우 true를 반환.
     */
    public boolean judgeNothing() {
        return (countStrike == COUNT_ZERO && countBall == COUNT_ZERO);
    }

    /**
     * countStrike getter
     * @return 스트라이크의 개수를 반환.
     */
    public int getCountStrike() {
        return countStrike;
    }

    /**
     * countBall getter
     * @return 볼의 개수를 반환.
     */
    public int getCountBall() {
        return countBall;
    }
}
