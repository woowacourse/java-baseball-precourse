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
     *  매개변수를 이용해 숫자야구 게임의 설정값을 초기화
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
            if (checkDup(goal, goal[i], i)) {    //중복된 랜덤값이 생성된 경우
                i--;
            }
        }
    }

    /**
     * nums 수열의 1번째 요소부터 index-1번째 요소를 tmp와 비교하여
     * 수열 내에 tmp와 동일한 값이 있는지 확인
     * @param nums, tmp, index
     * @return true, false
     */
    private boolean checkDup(int[] nums, int tmp, int index) {
        for (int i = 0; i < index; i++) {
            if (nums[i] == tmp) {
                return true;   //중복 발견한 경우
            }
        }
        return false;    //중복 값이 없는 경우
    }

    /**
     * 숫자야구 게임을 시작하기 위한 메소드로,
     * 사용자로부터 값을 입력받아 검증하고 그 결과를 출력
     */
    public void play(){
        while (true) {
            System.out.print("숫자를 입력해주세요 : ");
            int user = UserInput.getIntInput();
            if (!validate(user)) {
                System.out.println("1~9 범위이고 중복되는 숫자가 없는 3자리 수를 입력하세요");
                continue;
            }
            break;
        }
    }

    /**
     * 필드값을 이용하여 input이 올바른 범위에 있음과
     * input을 구성하는 숫자에 중복이 없음을 검증
     * @param input
     * @return true, false
     */
    private boolean validate(int input){
        int[] tmp = new int[SIZE];
        for (int i = 0; i < SIZE; i++) {
            tmp[i] = input % 10;
            if ((tmp[i] < FROM) || (tmp[i] > TO)
                    || checkDup(tmp, tmp[i], i)) {
                return false;
            }
            input /= 10;
        }
        return (input == 0);
    }
}
