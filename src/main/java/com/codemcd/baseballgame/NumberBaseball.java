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
            if (inputBaseballNumber.length() > 3 || inputBaseballNumber.length() < 3) {
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
        for (int i = 0; i < 10; ++i) {
            bCheckBall[i] = false;
        }
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
        initializeData();
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

        while (true) {
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            inputReGameFlag = scanner.nextLine();

            if (isNumeric(inputReGameFlag) == false || inputReGameFlag.length() == 0) {
                System.out.println("<오류: 잘못된 입력입니다. 올바른 숫자를 입력해주세요.>");
                continue;
            }

            reGameFlag = Integer.parseInt(inputReGameFlag);

            if (reGameFlag == 1) {
                return true;
            } else if (reGameFlag == 2) {
                return false;
            } else {
                System.out.println("<오류: 잘못된 입력입니다. 다시 입력해주세요!>");
                continue;
            }
        }
    }

}
