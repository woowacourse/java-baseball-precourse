package com.codemcd.baseballgame;

import java.util.Random;

public class NumberBaseball {

    private int[] computerBaseballNumber;

    NumberBaseball() {
        System.out.println("숫자 야구 게임 시작!");

        computerBaseballNumber = new int[3];
    }

    private static int checkOverlapNumber(int[] checkNumberArray, int currentIndex) {
        for (int i = 0; i < currentIndex; ++i) {
            if (checkNumberArray[currentIndex] == checkNumberArray[i]) {
                return -1;
            }
        }

        return 1;
    }

    public void makeRandomNumber() {

        Random random = new Random();

        /*
         * for 문의 i 값을 증가시키는 조건은 현재 숫자가 이전의 숫자들과 비교했을 때
         * 중복이 없는 경우이다.
         */
        for (int i = 0; i < 3; i += checkOverlapNumber(computerBaseballNumber, i)) {
            computerBaseballNumber[i] = random.nextInt(9) + 1;
        }

        /* 기능 확인을 위해 잠시 추가해둠 */
        for (int i = 0; i < 3; ++i) {
            System.out.print(computerBaseballNumber[i]);
        }
        System.out.println();
    }
}
