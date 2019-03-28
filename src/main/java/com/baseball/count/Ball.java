/*
 * @(#)Ball.java          2019/03/28
 *
 * Copyright (c) 2019 Seungwoo Lee.
 * All rights reserved.
 *
 */

package com.baseball.count;

/**
 * 컴퓨터의 숫자와 본인의 숫자를 비교하여 볼의 개수를 세고 반환하는 클래스입니다.
 *
 * @version         1.00 2019년 3월 28일
 *
 * @author          이승우
 */
public class Ball {

    /**
     * 컴퓨터의 숫자와 본인이 입력한 숫자를 비교한 볼의 개수
     *
     * @see #countBall(int[], int[])
     * @see #doMoreCount(int[], int[], int)
     */
    private int answer;

    /**
     * 매번 answer을 0으로 초기화하고 볼의 개수를 count하여 반환
     *
     * @param cNum 컴퓨터가 생성한 숫자를 자릿수로 나누어 담은 배열
     * @param myNum 입력받은 숫자를 자릿수로 나누어 담은 배열
     * @return 볼의 개수
     * @see #doCount(int[], int[])
     * @see #answer
     */
    public int countBall(int[] cNum, int[] myNum) {
        answer = 0;

        doCount(cNum, myNum);

        return answer;
    }

    /**
     * cNum 길이만큼 반복하고 반복시마다 idx 값 증가하여 doMoreCount 실행
     *
     * @param cNum 컴퓨터가 생성한 숫자를 자릿수로 나누어 담은 배열
     * @param myNum 입력받은 숫자를 자릿수로 나누어 담은 배열
     * @see #doMoreCount(int[], int[], int)
     */
    private void doCount(int[] cNum, int[] myNum) {
        int idx = 0;
        for (int i = 0; i < cNum.length; i++) {
            doMoreCount(cNum, myNum, idx++);
        }
    }

    /**
     * cNum의 배열 원소와 myNum의 배열 원소가 같고 인덱스가 다를 시 answer 증가
     *
     * @param cNum 입력받은 숫자를 자릿수로 나누어 담은 배열
     * @param myNum 입력받은 숫자를 자릿수로 나누어 담은 배열
     * @param index myNum의 배열 인덱스
     * @see #answer
     */
    private void doMoreCount(int[] cNum, int[] myNum, int index) {
        for (int i = 0; i < cNum.length; i++) {
            if ((cNum[i] == myNum[index]) && (i != index)) {
                answer++;
                break;
            }
        }
    }
}
