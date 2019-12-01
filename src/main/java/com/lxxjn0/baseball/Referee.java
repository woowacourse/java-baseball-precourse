/*
 * @(#)Referee.java        0.2 2019/12/01
 *
 * Copyright (c) 2019 lxxjn0.
 */
package com.lxxjn0.baseball;

import java.util.ArrayList;

/**
 * 스트라이크와 볼의 개수를 확인하고 낫싱 여부를 판단하는 클래스.
 *
 * @version         0.1 2019/12/01
 * @author          JUNYOUNG LEE (lxxjn0)
 */
public class Referee {
    /** 입력해야 하는 수의 길이를 저장한 상수 */
    private static final int NUM_LEN = 3;
    /** 스트라이크와 볼의 개수로 낫싱을 판단할 때 사용할 상수 변수*/
    private static final int JUDGE_NOTHING = 0;
    /** 컴퓨터가 생성한 3자리 수를 저장할 ArrayList */
    private ArrayList<Integer> comNumList;
    /** 사용자가 입력한 3자리 수를 저장할 ArrayList*/
    private ArrayList<Integer> userNumList;

    /**
     * 같은 자리에 같은 숫자인지 판단하여 스트라이크의 개수를 측정하는 메서드.
     * @return 스트라이크의 개수를 반환한다.
     */
    public int countStrikeNum() {
        int countStrike = 0;

        for(int i = 0; i < NUM_LEN; i++) {
            if(comNumList.get(i).equals(userNumList.get(i))) {
                countStrike++;
            }
        }
        return countStrike;
    }

    /**
     * 다른 자리에 같은 숫자인지 판단하여 볼의 개수를 측정하는 메서드.
     * @return 볼의 개수를 반환한다.
     */
    public int countBallNum() {
        int countBall = 0;

        for(int i = 0; i < NUM_LEN; i++) {
            if(!comNumList.get(i).equals(userNumList.get(i))) {
                if(userNumList.contains(comNumList.get(i))) {
                    countBall++;
                }
            }
        }
        return countBall;
    }

    /**
     * comNumList setter
     * @param comNumList 컴퓨터가 생성한 3자리 수.
     */
    public void setComNumList(ArrayList<Integer> comNumList) {
        this.comNumList = comNumList;
    }

    /**
     * userNumList setter
     * @param userNumList 사용자가 입력한 3자리 수.
     */
    public void setUserNumList(ArrayList<Integer> userNumList) {
        this.userNumList = userNumList;
    }
}
