/**
 * Copyright (c) 2019 Seungwan Park,
 * All rights reserved.
 */

package com.precourse;

import java.util.ArrayList;

/**
 * 클래스 이름 : NumberComparer.java
 *
 * @author Seungwan Park, github.com/toneyparky
 * @version 1.0
 * <p>
 * 날짜 : 2019.12.2 월요일
 */
public class NumberComparer {
    /*
     * NumberComparer 클래스에서는 맞춰야할 숫자와 플레이어의 숫자를 비교하여 볼, 스트라이크 판정을 내린다.
     */

    private static final int NUMBER_LENGTH = 3;

    private static ArrayList<Integer> guessingNumberList = new ArrayList<>();
    private static ArrayList<Integer> userNumberList = new ArrayList<>();
    private static ArrayList<Integer> ballStrikeList = new ArrayList<>();

    /**
     * 입력받은 ArrayList들을 이용하여 static 변수들을 초기화하는 생성자
     */
    public NumberComparer(ArrayList<Integer> guessingNumberList, ArrayList<Integer> userNumberList) {
        this.guessingNumberList = guessingNumberList;
        this.userNumberList = userNumberList;
    }

    /**
     * 숫자를 비교하는 로직이 진행되는 메서드
     */
    public static ArrayList<Integer> numberComparer() {
        ballStrikeList.clear();
        ballStrikeList.add(compareBall());
        ballStrikeList.add(compareStrike());
        generateFinalCount();
        return ballStrikeList;
    }

    /**
     * 두 list에 겹치는 수의 개수를 카운트한다. 그리고 ballStrikeList에 insert하는 메서드
     */
    public static int compareBall() {
        int counter = 0;
        for (int eachUserNumber : userNumberList) {
            if (guessingNumberList.contains(eachUserNumber)) {
                counter++;
            }
        }

        return counter;
    }

    /**
     * 두 list의 같은 index에 있는 동일한 수를 카운트한다. 그리고 ballStrikeList에 insert하는 메서드
     */
    public static int compareStrike() {
        int counter = 0;
        for (int i = 0; i < NUMBER_LENGTH; i++) {
            if (guessingNumberList.get(i) == userNumberList.get(i)) {
                counter++;
            }
        }

        return counter;
    }

    /**
     * ball에서 strike를 빼고 이를 ballStrikeList에 insert하여 최종 ball의 카운트를 구하는 메서드
     */
    public static void generateFinalCount() {
        ballStrikeList.add(ballStrikeList.get(0) - ballStrikeList.get(1));
    }

}
