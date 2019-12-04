/**
 * Copyright (c) 2019 Seungwan Park,
 * All rights reserved.
 */

package com.precourse;

import java.util.ArrayList;

/**
 * 클래스 이름 : ResultGenerator.java
 *
 * @author Seungwan Park, github.com/toneyparky
 * @version 1.0
 * <p>
 * 날짜 : 2019.12.2 월요일
 */
public class ResultGenerator {
    /*
     * ResultGenerator 클래스에서는 NumberComparer 클래스에서 만들어진 ball, strike의 수를 바탕으로 게임의 결과를 출력하고 종료 여부를 반환한다.
     */

    private static final int NUMBER_LENGTH = 3;
    private static final int ZERO_STRIKE = 0;
    private static final int ZERO_BALL = 0;

    private static ArrayList<Integer> resultList = new ArrayList<>();

    /**
     * 입력받은 ArrayList로 static변수를 초기화하고 게임의 결과를 구하는 함수를 호출하고 그 결과를 리턴하는 메서드
     */
    public static boolean resultGenerator(ArrayList<Integer> inputList) {
        resultList = inputList;
        return getResult();
    }

    /**
     * 볼과 스트라이크의 수를 바탕으로 결과를 출력하는 메서드
     */
    public static boolean getResult() {
        if (resultList.get(1) == NUMBER_LENGTH) {
            System.out.println(NUMBER_LENGTH + "개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        }

        if (resultList.get(1) != ZERO_STRIKE) {
            System.out.print(resultList.get(1) + " 스트라이크 ");
        }

        if (resultList.get(2) != ZERO_BALL) {
            System.out.print(resultList.get(2) + " 볼 ");
        }

        if (resultList.get(1) == ZERO_STRIKE && resultList.get(2) == ZERO_BALL) {
            System.out.print("낫싱");
        }
        System.out.print("\n");
        return false;
    }

}
