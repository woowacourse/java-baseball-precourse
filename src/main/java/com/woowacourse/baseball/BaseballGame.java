/*
 *  클래스 이름 : BaseballGame.java
 *
 *  버전 정보 :
 *
 *  날짜 : 2019-03-27
 *
 *  저작권 : 이예지
 */

package com.woowacourse.baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class BaseballGame {

    public static void main(String[] args) {
        List<Integer> computerNumber = createRandomNumber();
        int playerNumber = inputPlayerNumber();

        System.out.println(computerNumber.toString());
        System.out.println("사용자가 입력한 수 : "+playerNumber);

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

    /* 2. 사용자의 수를 입력받는 기능 */
    static int inputPlayerNumber(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("숫자를 입력해주세요.");

        String s = scanner.nextLine();

        System.out.println("s는"+s);

        if (s.matches("[1-9]{3}")) {
            scanner.close();
            return Integer.parseInt(s);
        } else {
            System.out.println("올바르지 않은 형식입니다. 3개의 숫자를 입력해주세요.");
           // scanner.close();
            return inputPlayerNumber();
        }
    }



}