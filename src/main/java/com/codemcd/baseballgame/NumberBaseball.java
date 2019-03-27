/*
 * @(#)NumberBaseball.java
 * v1.00
 * 2019/03/27
 */

package com.codemcd.baseballgame;

import java.util.Random;
import java.util.Scanner;

/**
 * 숫자 야구 게임에 필요한 모든 기능을 가지는 NumberBaseball 클래스
 *
 * @version v1.00
 * @author 박성범
 */
public class NumberBaseball {

    private static final int BASEBALL_NUMBER_LENGTH = 3;
    private static final int MAX_NUMBER_VALUE = 9;
    private static final int RESTART = 1;
    private static final int EXIT = 2;

    private int[] computerBaseballNumber;
    private int[] userBaseballNumber;

    /** ball 이 있는지 검사하기 위한 배열이다. */
    private boolean[] bCheckBall;
    private int strikeCount;
    private int ballCount;

    NumberBaseball() {

        System.out.println("숫자 야구 게임 시작!");

        computerBaseballNumber = new int[BASEBALL_NUMBER_LENGTH];
        userBaseballNumber = new int[BASEBALL_NUMBER_LENGTH];
        bCheckBall = new boolean[MAX_NUMBER_VALUE + 1];
    }

    public void initialize() {
        for (int i = 0; i < BASEBALL_NUMBER_LENGTH; ++i) {
            computerBaseballNumber[i] = 0;
            userBaseballNumber[i] = 0;
        }
    }

    /**
     * 파라미터로 받은 배열의 처음부터 현재 인덱스까지 중복이 있는지 검사한다.
     * @param checkNumberArray 중복이 있는지 검사할 숫자 배열
     * @param currentIndex     checkNumberArray 배열의 현재 인덱스
     * @return 중복이 있으면 -1, 중복이 없으면 1을 반환
     */
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

        /* for 문의 i 값을 증가시키는 조건은 현재까지 중복이 없는 경우이다. */
        for (int i = 0; i < BASEBALL_NUMBER_LENGTH;
                i += checkOverlapNumber(computerBaseballNumber, i)) {
            computerBaseballNumber[i] = random.nextInt(MAX_NUMBER_VALUE) + 1;
        }

        for(int i=0; i<3; ++i)
            System.out.println((computerBaseballNumber[i]));
    }

    /**
     * 전달받은 문자열의 모든 문자가 숫자 1 ~ 9 범위내에 있는지 검사한다.
     * @param str 검사할 문자열
     * @return 모든 문자가 1 ~ 9 범위 내에 있다면 true, 그렇지 않으면 false 를 반환한다.
     */
    private static boolean isNumeric(String str) {
        for (int i = 0; i < str.length(); ++i) {
            if (str.charAt(i) < '1' || str.charAt(i) > '9') {
                return false;
            }
        }
        return true;
    }

    public void inputUserNumber() {

        Scanner scanner = new Scanner(System.in);
        String inputBaseballNumber;

        /* 입력받은 문자열을 정수로 변환하여 저장하는 변수 */
        int stringToInteger;

        while (true) {
            System.out.print("숫자를 입력하세요.: ");
            inputBaseballNumber = scanner.nextLine();

            /* 입력받은 문자열이 1 ~ 9 범위 내의 숫자인지 검사한다. */
            if (isNumeric(inputBaseballNumber) == false) {
                System.out.println("<오류: 잘못된 입력입니다. 1 ~ 9 범위 내의 숫자를 입력해주세요.>");
                continue;
            }
            /* 입력받은 문자열이 3자리 숫자인지 검사한다. */
            if (inputBaseballNumber.length() > BASEBALL_NUMBER_LENGTH
                    || inputBaseballNumber.length() < BASEBALL_NUMBER_LENGTH) {
                System.out.println("<오류: 잘못된 입력입니다. 숫자 3자리를 입력해주세요.>");
                continue;
            }

            stringToInteger = Integer.parseInt(inputBaseballNumber);
            userBaseballNumber[0] = stringToInteger / 100;
            userBaseballNumber[1] = stringToInteger % 100 / 10;
            userBaseballNumber[2] = stringToInteger % 100 % 10;

            /* 입력받은 3자리 숫자 중 중복이 존재하는지 검사한다. */
            if (checkOverlapNumber(userBaseballNumber, 2) == 1
                    && checkOverlapNumber(userBaseballNumber, 1) == 1) {
                break;
            } else {
                System.out.println("<오류: 잘못된 입력입니다. 서로 다른 숫자 3자리를 입력해주세요.>");
            }

        }

    }

    private void initializeData() {

        strikeCount = 0;
        ballCount = 0;
        for (int i = 0; i < MAX_NUMBER_VALUE + 1; ++i) {
            bCheckBall[i] = false;
        }
    }

    private void calculateStrikeAndBallCount() {
        for (int i = 0; i < BASEBALL_NUMBER_LENGTH; ++i) {
            if (computerBaseballNumber[i] == userBaseballNumber[i]) {
                strikeCount++;
            } else {
                bCheckBall[userBaseballNumber[i]] = true;
            }
        }

        for (int i = 0; i < BASEBALL_NUMBER_LENGTH; ++i) {
            if (bCheckBall[computerBaseballNumber[i]] == true) {
                ballCount++;
            }
        }
    }

    /**
     * 컴퓨터가 뽑은 숫자와 유저가 입력한 숫자를 비교한다.
     * @return 3 스트라이크로 게임을 종료해야 하면 true, 그렇지 않으면 false 를 반환한다.
     */
    public boolean matchUserAndComputer() {
        initializeData();
        calculateStrikeAndBallCount();

        return (strikeCount == BASEBALL_NUMBER_LENGTH) ? true : false;
    }

    public void printMatchResult() {
        if (strikeCount == BASEBALL_NUMBER_LENGTH) {
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

        while (true) {
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            inputReGameFlag = scanner.nextLine();

            if (isNumeric(inputReGameFlag) == false || inputReGameFlag.length() == 0) {
                System.out.println("<오류: 잘못된 입력입니다. 올바른 숫자를 입력해주세요.>");
                continue;
            }

            reGameFlag = Integer.parseInt(inputReGameFlag);

            if (reGameFlag == RESTART) {
                return true;
            } else if (reGameFlag == EXIT) {
                return false;
            } else {
                System.out.println("<오류: 잘못된 입력입니다. 다시 입력해주세요!>");
                continue;
            }
        }
    }

}