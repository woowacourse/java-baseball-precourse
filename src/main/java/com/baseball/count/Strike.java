/*
 * @(#)Strike.java          2019/03/28
 *
 * Copyright (c) 2019 Seungwoo Lee.
 * All rights reserved.
 *
 */

package com.baseball.count;

/**
 * 컴퓨터의 숫자와 본인의 숫자를 비교하여 스트라이크의 숫자를 세고 반환하는 클래스입니다.
 *
 * @version         1.00 2019년 3월 28일
 *
 * @author          이승우
 */
public class Strike {

    /**
     * 컴퓨터의 숫자와 본인이 입력한 숫자를 비교한 스트라이크의 개수
     *
     * @see #countStrike(int[], int[])
     * @see #doCount(int[], int[])
     */
    private int answer;

    /**
     * 매번 answer을 0으로 초기화하고 스트라이크의 개수를 count하여 반환
     *
     * @param cNum 컴퓨터가 생성한 숫자를 자릿수로 나누어 담은 배열
     * @param myNum 입력받은 숫자를 자릿수로 나누어 담은 배열
     * @return 스트라이크의 개수
     * @see #doCount(int[], int[])
     * @see #answer
     */
    public int countStrike(int[] cNum, int[] myNum) {
        answer = 0;

        doCount(cNum, myNum);

        return answer;
    }

    /**
     * 컴퓨터와 입력받은 숫자의 각 자릿수를 담은 cNum과 myNum의 동일한 인덱스의 원소 값이 같으면 answer 증가
     *
     * @param cNum 입력받은 숫자를 자릿수로 나누어 담은 배열
     * @param myNum 입력받은 숫자를 자릿수로 나누어 담은 배열
     * @see #answer
     */
    private void doCount(int[] cNum, int[] myNum) {
        for (int i = 0; i < cNum.length; i++) {
            if (cNum[i] == myNum[i]) {
                answer++;
            }
        }
    }

}