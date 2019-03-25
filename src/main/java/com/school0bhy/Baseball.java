/*
 * Baseball.java    1.00 20190326
 *
 * Copyright (c) 2019 Hyeonyeong Baek.
 * All rights reserved.
 */
package com.school0bhy;

import java.util.Random;

/**
 * 숫자야구 게임을 위한 클래스
 *
 * @version     1.00 2019년 3월 26일
 * @author      school0bhy
 */
public class Baseball {
    private final int SIZE;    //숫자야구에서 사용할 수열의 크기
    private final int FROM, TO;    //수열을 구성할 숫자의 범위를 표현
    private int[] goal;
    private int strike, ball;

    /**
     *  매개변수를 이용해 숫자야구 게임의 설정값을 초기화
     */
    public Baseball(int size, int from, int to) {
        SIZE = size;
        FROM = from;
        TO = to;
        goal = new int[SIZE];
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
     * nums 수열의 요소 중 tmp와 동일한 값이 있는지 확인
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
     * 숫자야구 게임을 시작하기 위한 메소드
     */
    public void play() {
        setGoal();
        while (true) {
            System.out.print("숫자를 입력해주세요 : ");
            int userInput = UserInput.getIntInput();
            if (!validate(userInput)) {
                System.out.println("1~9 범위이고 중복되는 숫자가 없는 3자리 수를 입력하세요");
                continue; //입력값 검증에 실패하여 재입력 요청
            }
            compare(userInput);
            System.out.println(getResultString());
            if (strike == SIZE) {
                System.out.println(SIZE+"개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            }
        }
    }

    /**
     * input의 유효성을 검증
     * @param userInput
     * @return true, false
     */
    private boolean validate(int userInput) {
        int[] tmp = new int[SIZE];
        for (int i = 0; i < SIZE; i++) {
            tmp[i] = userInput % 10;
            if ((tmp[i] < FROM) || (tmp[i] > TO)    //범위 체크
                    || checkDup(tmp, tmp[i], i)) {  //중복 체크
                return false;
            }
            userInput /= 10;
        }
        return (userInput == 0);
    }

    /**
     * input과 goal을 비교하여 스트라이크와 볼의 개수를 구함
     * @param userInput
     */
    private void compare(int userInput) {
        strike = 0;
        ball = 0;
        String user = Integer.toString(userInput);
        int index;
        for (int i = 0; i < SIZE; i++) {
            index = user.indexOf(Integer.toString(goal[i]));
            if (index == i) {
                strike++;
            }
            else if (index != -1) {
                ball++;
            }
        }
    }

    /**
     * strike와 ball 값으로 생성한 결과 문자열을 리턴
     * @return result
     */
    private String getResultString() {
        String result = "";
        if (strike > 0) {
            result = strike + "스트라이크 ";
        }
        if (ball > 0) {
            result += ball + "볼 ";
        }
        if ((strike == 0) && (ball == 0)){
            result = "낫싱";
        }
        return result;
    }
}
