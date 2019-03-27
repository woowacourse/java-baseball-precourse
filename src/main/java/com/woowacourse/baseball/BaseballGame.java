package com.woowacourse.baseball;

/*
 *  클래스 이름 : BaseballGame.java
 *
 *  버전 정보 :
 *
 *  날짜 : 2019-03-27
 *
 *  저작권 : 이예지
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BaseballGame {

    public static void main(String[] args) {
        List<Integer> computerNumber = createRandomNumber();

        System.out.println(computerNumber.toString());
    }

    /* 1. 컴퓨터의 수(정답)를 선택하는 기능. */
    static List<Integer> createRandomNumber(){

        List<Integer> computerNumber = new ArrayList<>();
        Random r = new Random();
        int number;

        for (int i = 0; i < 3; ++i) {
            number = (r.nextInt(8) + 1);

            if (computerNumber.contains(number)) {
                i--;
                continue;
            }

            System.out.println("컴퓨터의 숫자 "+i+"번째 수 : " + number);

            computerNumber.add(number);
        }

        return computerNumber;
    }


}