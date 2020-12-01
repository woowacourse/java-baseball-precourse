package baseball.service;

import utils.RandomUtils;

public class Number {

    private Number() {
    }

    public static final int NUMBER_LENGTH = 3;

    public static int[] checkValidation(int number) {
        int[] usedNum = new int[10];
        int numArr[] = new int[NUMBER_LENGTH];
        int numLength = 0;

        while (number > 0) {
            int idx = NUMBER_LENGTH - numLength - 1;
            numArr[idx] = (number % 10);
            if (usedNum[numArr[idx]] != 0) {
                throw new IllegalArgumentException();
            }
            usedNum[numArr[idx]] = 1;
            number /= 10;
            numLength++;
        }

        if (numLength != NUMBER_LENGTH || usedNum[0] != 0) {
            throw new IllegalArgumentException();
        }

        return numArr;
    }

    public static int[] makeNumber() {
        int usedNum[] = new int[10];
        int num[] = new int[NUMBER_LENGTH];

        int i = 0;
        while (i < NUMBER_LENGTH) {
            num[i] = RandomUtils.nextInt(1, 9);
            if (usedNum[num[i] - 1] == 0) {
                usedNum[num[i] - 1] += 1;
                i++;
            }
        }

        return num;
    }

    public static int[] compareNumber(int answer, int[] number, int idx) {
        int ballCnt = 0;
        int strikeCnt = 0;

        for (int i = 0; i < NUMBER_LENGTH; i++) {
            if (answer == number[i] && i == idx) {
                strikeCnt++;
            } else if (answer == number[i] && i != idx) {
                ballCnt++;
            }
        }

        return new int[]{strikeCnt, ballCnt};
    }

    public static int printHint(int[] answer, int[] number) {
        int strikeCnt = 0;
        int ballCnt = 0;

        for (int i = 0; i < NUMBER_LENGTH; i++) {
            int[] score = compareNumber(answer[i], number, i);
            strikeCnt += score[0];
            ballCnt += score[1];
        }

        if (strikeCnt == 0 && ballCnt == 0) {
            System.out.println("낫싱");
        } else if (strikeCnt == 0 && ballCnt != 0) {
            System.out.println(ballCnt + "볼");
        } else if (strikeCnt != 0 && ballCnt == 0) {
            System.out.println(strikeCnt + "스트라이크");
        } else {
            System.out.println(ballCnt + "볼 " + strikeCnt + "스트라이크");
        }

        return strikeCnt;
    }
}
