package com.baseball;

import java.util.Random;
import java.util.Scanner;

public class BaseballGame {

    public void run() {
        while (round());
    }

    private boolean round() {
        int[] randomMum = getRandomNumbers();

        for(int a : randomMum) {
            System.out.print(a);
        }

        System.out.println();

        while (true) {
            int[] myNum;

            System.out.print("숫자를 입력해주세요 : ");
            myNum = getMyNumbers();

            for(int b : myNum) {
                System.out.print(b);
            }

            break;
        }

        return false;
    }

    /**
     * 내가 입력하는 숫자 메소드
     * @return
     */
    private int[] getMyNumbers() {
        int[] myNumber = new int[3];
        Scanner scan = new Scanner(System.in);

        for (int i = 0; i < myNumber.length; i++) {
            myNumber[i] = scan.nextInt();
        }

        return myNumber;
    }

    /**
     * 컴퓨터 숫자 메소드
     * @return
     */
    private int[] getRandomNumbers() {
        int value = 0;
        int[] randomNum = new int[3];
        Random random = new Random();

        for (int i = 0; i < randomNum.length; i++) {
            value = random.nextInt(9) + 1;

            if (isContains(value, randomNum)) {
                i--;
            } else {
                randomNum[i] = value;
            }
        }

        return randomNum;
    }

    /**
     * 배열 속 해당 value가 있는지 체크
     * @param value
     * @param array
     * @return
     */
    private boolean isContains(int value, int[] array) {
        for (int n : array) {
            if (n == value) {
                return true;
            }
        }

        return false;
    }
}
