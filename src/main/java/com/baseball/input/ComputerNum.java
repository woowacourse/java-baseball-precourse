/*
 * @(#)ComputerNum.java          2019/03/28
 *
 * Copyright (c) 2019 Seungwoo Lee.
 * All rights reserved.
 *
 */

package com.baseball.input;

import java.util.Random;
import java.util.HashSet;

/**
 * 1부터 9까지 서로 다른 수로 이루어진 3자리 숫자를 랜덤으로 생성하여 배열로 반환하는 클래스입니다.
 *
 * @version         1.00 2019년 3월 28일
 *
 * @author          이승우
 */
public class ComputerNum {

    /**
     * 컴퓨터 생성한 숫자의 각 자릿수를 담을 배열
     *
     * @see #getCNum()
     * @see #makeCNum()
     */
    private int[] num = new int[3];

    /**
     * 각 자릿수가 조건에 맞는지 검사하기 위한 Set
     *
     * @see #getCNum()
     * @see #makeCNum()
     * @see #check()
     */
    private HashSet<Integer> set = new HashSet<>();

    /**
     * 매번 set을 초기화하고 컴퓨터가 생성한 숫자의 자릿수를 담은 배열 반환
     *
     * @return      조건을 만족하는 각각의 자릿수가 담겨진 배열
     * @see #check()
     * @see #set
     */
    public int[] getCNum() {
        set.clear();
        check();

        return num;
    }

    /**
     * num 배열의 원소에 1~9의 숫자 중 랜덤으로 선택하여 삽입
     * set에 num[i] 추가
     *
     * @see #set
     */
    private void makeCNum() {
        Random rand = new Random();

        for (int i = 0; i < num.length; i++) {
            num[i] = rand.nextInt(9) + 1;
            set.add(num[i]);
        }
    }

    /**
     * set을 초기화하고 num 배열의 원소에 숫자 삽입
     * set의 크기가 num 배열의 길이와 같을 때까지 반복 (중복이 없도록 하기 위해)
     *
     * @see #makeCNum()
     * @see #set
     */
    private void check() {
        while (set.size() != num.length) {
            set.clear();
            makeCNum();
        }
    }
}
