/**
 * Copyright (c) 2019 Seungwan Park,
 * All rights reserved.
 */

package com.precourse;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 클래스 이름 : IntegerToArrayList.java
 *
 * @author Seungwan Park, github.com/toneyparky
 * @version 1.0
 * <p>
 * 날짜 : 2019.12.2 월요일
 */
public class IntegerToArrayList {
    /*
     * IntegerToArrayList 클래스에서는 플레이어의 입력 숫자를 ArrayList로 바꾸어준다.
     */

    private static final int DEVIDE_NUMBER = 10;

    private static ArrayList<Integer> numberList = new ArrayList<>();

    /**
     * n자릿수의 정수를 ArrayList로 바꾸는 메서드
     */
    public static ArrayList<Integer> integerToArrayList(int userNumber) {
        int numberLength = String.valueOf(userNumber).length();
        numberList.clear();

        for (int i = 0; i < numberLength; i++) {
            numberList.add(userNumber % DEVIDE_NUMBER);
            userNumber = userNumber / DEVIDE_NUMBER;
        }

        reverseArrayList();

        return numberList;
    }

    /**
     * ArrayList의 element들의 순서를 반전하는 메서드
     */
    public static void reverseArrayList() {
        Collections.reverse(numberList);
    }

}
