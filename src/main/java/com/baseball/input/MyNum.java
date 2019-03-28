/*
 * @(#)MyNum.java          2019/03/28
 *
 * Copyright (c) 2019 Seungwoo Lee.
 * All rights reserved.
 *
 */

package com.baseball.input;

import java.util.Scanner;
import java.util.HashSet;

/**
 * 1부터 9까지 서로 다른 수로 이루어진 3자리 숫자를 입력하여 배열로 반환하는 클래스입니다.
 *
 * @version         1.00 2019년 3월 28일
 *
 * @author          이승우
 */
public class MyNum {

    /**
     * 입력받은 숫자의 각 자릿수를 담을 배열
     *
     * @see #getMyNum()
     * @see #numToArray()
     */
    private int[] num = new int[3];

    /**
     * 각 자릿수가 조건에 맞는지 검사하기 위한 Set
     *
     * @see #getMyNum()
     * @see #numToArray()
     * @see #checkCondition()
     * @see #check()
     */
    private HashSet<Integer> set = new HashSet<>();

    /**
     * 입력받은 숫자를 담을 변수
     *
     * @see #inputMyNum()
     * @see #numToArray()
     * @see #checkCondition()
     */
    private int number = 0;

    /**
     * 매번 set을 초기화하고 입력받은 숫자의 자릿수를 담은 배열 반환
     *
     * @return      조건을 만족하는 각각의 자릿수가 담겨진 배열
     * @see #check()
     * @see #set
     */
    public int[] getMyNum() {
        set.clear();
        check();

        return num;
    }

    /**
     * 숫자를 입력받음
     *
     * @see #number
     */
    private void inputMyNum() {
        Scanner input = new Scanner(System.in);
        number = input.nextInt();
    }

    /**
     * 입력받은 숫자의 가장 마지막 자릿수를 num 배열의 마지막 원소부터 채움
     * 입력받은 숫자를 10으로 나눈다
     * set에 num[i]을 추가
     * 위의 과정을 배열 num의 길이만큼 반복
     *
     * @see #number
     * @see #num
     * @see #set
     */
    private void numToArray() {
        for (int i = num.length - 1; i >= 0; i--) {
            num[i] = number % 10;
            number = number / 10;
            set.add(num[i]);
        }
    }

    /**
     * numToArray의 과정을 거치고도 number가 0이 아니라는 뜻은 3자리 숫자가 아니라는 것
     * set에 0이 포함된다는 것은 입력받은 숫자에 0이 있다는 것
     * set의 크기가 num 배열의 크기가 아니라는 것은 3자리 숫자가 아니거나 중복이 있다는 것
     * 위의 조건들을 만족하지 않으면 다시 입력을 받는다
     * set 초기화
     *
     * @see #number
     * @see #set
     */
    private void checkCondition() {
        if ((number != 0)
                || set.contains(0)
                || (set.size() != num.length)) {
            System.out.println("1부터 9까지 서로 다른 수로 이루어진 3자리 숫자로 다시 입력해주세요");
            set.clear();
        }
    }

    /**
     * 숫자를 입력받음
     * 입력받은 숫자의 자릿수를 배열에 받음
     * 조건에 맞는지 확인
     * set의 크기가 num 배열의 크기와 같을 때까지 반복
     *
     * @see #inputMyNum()
     * @see #numToArray()
     * @see #checkCondition()
     * @see #set
     */
    private void check() {
        while (set.size() != num.length) {
            inputMyNum();
            numToArray();
            checkCondition();
        }
    }
}
