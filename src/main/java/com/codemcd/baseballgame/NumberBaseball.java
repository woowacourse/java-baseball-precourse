package com.codemcd.baseballgame;

import java.util.Random;
import java.util.Scanner;

public class NumberBaseball {

    private int[] computerBaseballNumber;
    private int[] userBaseballNumber;
    private boolean[] bCheckBall;
    private int strikeCount;
    private int ballCount;

    NumberBaseball() {
        System.out.println("숫자 야구 게임 시작!");

        computerBaseballNumber = new int[3];
        userBaseballNumber = new int[3];
        bCheckBall = new boolean[10];
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

    public void inputUserNumber() {

        Scanner scanner = new Scanner(System.in);
        String inputBaseballNumber;

        /* 입력받은 문자열을 정수로 변환하여 저장하는 변수 */
        int stringToInteger;

        System.out.print("숫자를 입력하세요.: ");
        inputBaseballNumber = scanner.nextLine();

        stringToInteger = Integer.parseInt(inputBaseballNumber);
        userBaseballNumber[0] = stringToInteger / 100;
        userBaseballNumber[1] = stringToInteger % 100 / 10;
        userBaseballNumber[2] = stringToInteger % 100 % 10;

        /* 기능 확인을 위해 잠시 추가해둠 */
        for (int i = 0; i < 3; ++i) {
            System.out.print(userBaseballNumber[i]);
        }
        System.out.println();
    }

    private void calculateStrikeAndBallCount() {
        for (int i = 0; i < 3; ++i) {
            if (computerBaseballNumber[i] == userBaseballNumber[i]) {
                strikeCount++;
            } else {
                bCheckBall[userBaseballNumber[i]] = true;
            }
        }

        for (int i = 0; i < 3; ++i) {
            if (bCheckBall[computerBaseballNumber[i]] == true) {
                ballCount++;
            }
        }
    }

    public boolean matchUserAndComputer() {
        calculateStrikeAndBallCount();

        return (strikeCount == 3) ? true : false;
    }

    public void printMatchResult() {
        if (strikeCount == 3) {
            System.out.println("3스트라이크");
            System.out.println("3개의 숫자를 모두 맞추셨습니다! 게임 종료");
        } else if (strikeCount == 0 && ballCount == 0) {
            System.out.println("낫싱");
        } else if (strikeCount > 0 && ballCount == 0) {
            System.out.println(strikeCount + "스트라이크");
        } else if (strikeCount == 0 && ballCount > 0) {
            System.out.println(ballCount + "볼");
        } else if (strikeCount > 0 && ballCount > 0) {
            System.out.println(strikeCount + "스트라이크" + " " + ballCount + "볼");
        }
    }

    public boolean isContinue() {

        Scanner scanner = new Scanner(System.in);
        String inputReGameFlag;
        int reGameFlag;

        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        inputReGameFlag = scanner.nextLine();

        reGameFlag = Integer.parseInt(inputReGameFlag);

        if (reGameFlag == 1) {
            return true;
        } else if (reGameFlag == 2) {
            return false;
        }

        return false;
    }

}
