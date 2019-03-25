/*
 * UserInput.java    1.00 20190325
 *
 * Copyright (c) 2019 Hyeonyeong Baek.
 * All rights reserved.
 */
package com.school0bhy;

import java.util.Scanner;

/**
 * 사용자 입력 받기를 수행하기 위한 클래스
 *
 * @version     1.00 2019년 3월 25일
 * @author      school0bhy
 */
public class UserInput {

    /**
     * 사용자에게 정수값을 입력받아 이를 리턴
     * @return input
     */
    public static int getIntInput() {
        Scanner sc = new Scanner(System.in);
        int input;
        while (true) {  //정수값을 입력받을 때까지 반복
            try {
                input = Integer.parseInt(sc.nextLine());
                break;
            } catch (Exception e) {
                System.out.println("숫자만 입력가능합니다.");
            }
        }
        return input;
    }
}
