/*
 * Baseball.java    1.00 20190325
 *
 * Copyright (c) 2019 Hyeonyeong Baek.
 * All rights reserved.
 */
package com.school0bhy;

import java.util.Random;

/**
 * 숫자야구 게임을 위한 클래스
 *
 * @version     1.00 2019년 3월 25일
 * @author      school0bhy
 */
public class Baseball {
    private final int SIZE;    //숫자야구에서 사용할 수열의 크기
    private final int FROM, TO;    //수열을 구성할 숫자의 범위를 표현
    private int[] goal;

    /**
     *  매개변수를 이용해 숫자야구 게임의 설정값을
     */
    public Baseball(int size, int from, int to) {
        SIZE = size;
        FROM = from;
        TO = to;
        goal = new int[SIZE];
        setGoal();
    }

    /**
     * 랜덤넘버로 구성된 수열을 생성
     */
    private void setGoal() {
        Random random = new Random();
        for (int i = 0; i < SIZE; i++) {
            goal[i] = random.nextInt(TO + 1 - FROM) + FROM;
            if (!checkDup(goal[i], i)) {
                i--;
            }
        }
    }

    /**
     * 수열의 1번째 요소부터 index-1번째 요소를 tmp와 비교하여
     * 수열 내에 tmp와 동일한 값이 있는지 확인
     * @param tmp, index
     * @return true, false
     */
    private boolean checkDup(int tmp, int index) {
        for (int i = 0; i < index; i++) {
            if (goal[i] == tmp) {
                return false;
            }
        }
        return true;
    }
}
