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
            int[] result = {0,0}; //[0]은 strike, [1]은 ball

            System.out.print("숫자를 입력해주세요 : ");
            myNum = getMyNumbers();

            checkResult(randomMum, myNum, result);

            getResult(result);

            if (result[0] == 3) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            }

            break;
        }

        return false;
    }

    /**
     * 결과 출력 메소드
     * @param result
     */
    private void getResult(int[] result) {
        if (result[0] + result[1] == 0){
            System.out.println("낫싱");
            return;
        }

        if (result[0] != 0){
            System.out.print(result[0] + " 스트라이크 ");
        }

        if (result[1] != 0){
            System.out.print(result[1] + "볼");
        }

        System.out.println();
    }

    /**
     * 결과 확인 메소드
     * @param randomNum
     * @param myNum
     * @param result
     * @return
     */
    private void checkResult(int[] randomNum, int[] myNum, int[] result) {
        for (int i = 0; i < randomNum.length; i++) {
            if (randomNum[i] == myNum[i]) { //strike 체크
                result[0]++;
                continue;
            }

            if (isContains(randomNum[i], myNum)) { //ball 체크
                result[1]++;
            }
        }
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
