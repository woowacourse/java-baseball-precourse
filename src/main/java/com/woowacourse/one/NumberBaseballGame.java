package com.woowacourse.one;

/**
 * 기능 구현 목록
 * 1. 랜덤변수를 만드는 메소드
 * 2. 플레이어의 입력을 받는 메소드
 * 3. 스트라이크 횟수와 볼 횟수를 구하는 메소드
 * 4. 스트라이크 횟수와 볼 횟수를 출력하는 메소드
 * 5. 게임이 끝났을 때 새로 시작하거나 종료하는 메소드
 *
 * @author aegis1920
 * @className NumberBaseball
 * @date 2019.12.02
 * @version 1.0
 *
 */
public class NumberBaseballGame {

    /** 3자리의 숫자 야구 게임이므로 3자리수를 위한 DIGIT 상수 */
    private static final int DIGIT = 3;

    /**
     * 원소가 서로 다른 랜덤 배열을 만드는 메소드입니다. boolean배열을 체크해가면서 전에 있던 값은 넣지 않아 서로 다른 값이 들어가도록
     * 했습니다.
     *
     * @param randNumList
     */
    public static void makeRandNum(int[] randNumList) {

        int randNum = (int) (Math.random() * 9) + 1;

        boolean[] checkRandList = new boolean[10];

        for (int i = 0; i < DIGIT; i++) {

            while (checkRandList[randNum]) {
                randNum = (int) (Math.random() * 9) + 1;
            }

            checkRandList[randNum] = true;

            randNumList[i] = randNum;
        }

    }

    public static void main(String[] args){
        System.out.println("hello world");
    }
}
