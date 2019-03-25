/*
 * @(#)BaseballGame.java       0.9 2019/03/25
 */

import java.util.*;

/**
 * 숫자야구게임을 진행하는 클래스
 *
 * @author 이도원
 * @version 0.9 2019/03/25
 */
public class BaseballGame {

    /* 숫자야구게임의 숫자 자릿수 */
    private static final int DIGIT = 3;

    /* 숫자의 범위 */
    private static final int NUMBER_RANGE = 9;

    /* 숫자의 최소 값 */
    private static final int MIN_NUMBER = 1;

    /* 게임을 재시작하는 값 */
    private static final int RESTART = 1;

    /* 게임을 종료하는 값 */
    private static final int QUIT = 2;

    /* 컴퓨터가 선택한 숫자의 문자열 */
    private String number;

    /* 선택한 한자릿수 정수를 저장하는 Set */
    private HashSet<Integer> set;

    /**
     * BaseballGame 클래스의 생성자
     */
    public BaseballGame() {
    }

    /**
     * 게임을 시작시키는 메소드
     */
    public void turnOn() {

        /* 플레이어가 원할 경우에 게임을 재시작 */
        do {
            start();
        } while (isRestart());
    }

    /* 숫자야구게임을 시작하는 메소드 */
    private void start() {
        System.out.print("게임을 시작합니다!\n");

        /* 먼저 컴퓨터가 숫자를 선택한다 */
        selectNumber();

        /* 숫자가 선택된 후, 게임이 진행된다. */
        progress();
    }

    /* 임의의 3자리의 수를 선택하는 메소드. */
    private void selectNumber() {
        Random random = new Random();
        set = new HashSet<>();
        number = "";

        /* 임의의 한자릿수 정수가 3개 선택될 때까지 반복 */
        while (number.length() < DIGIT) {

            /* 1~9 사이의 임의의 한자릿수 정수 생성 */
            int randomNumber = random.nextInt(NUMBER_RANGE) + MIN_NUMBER;

            if (!set.contains(randomNumber)) {

                /* 생성된 한자릿수 정수가 이미 생성된 정수와 같지 않은 경우에 실행 */
                number += randomNumber;
                set.add(randomNumber);
            }
        }
    }

    /* 숫자야구게임을 진행하는 메소드 */
    private void progress() {
        while (true) {

            /* 플레이어가 입력한 수를 저장 */
            String inputNumber = inputNumber();

            /* 스트라이크의 갯수를 결정 */
            int strike = getStrike(inputNumber);

            /* 볼의 갯수를 결정 */
            int ball = getBall(inputNumber);

            /* 스트라이크와 볼의 갯수를 출력 */
            printResult(strike, ball);

            if (isSuccess(strike)) {

                /* 3개의 숫자를 모두 맞혔을 경우에 게임종료 메시지 출력하고 종료 */
                printSuccessGame();
                break;
            }
        }
    }

    /* 플레이어로부터 숫자를 입력받는 메소드 */
    private String inputNumber() {
        Scanner scanner = new Scanner(System.in);

        /* 플레이어가 입력한 숫자의 문자열 */
        String inputString;

        /* 입력받은 수가 3자리 정수가 아니면 다시 입력받음 */
        do {
            System.out.print("숫자를 입력해주세요 : ");
            inputString = scanner.nextLine();
        } while (!isCorrectNumber(inputString));

        return inputString;
    }

    /* 입력받은 문자열이 3자리의 정수로 이루어진 문자열인지 판단하는 메소드 */
    private boolean isCorrectNumber(String str) {
        int num = Integer.parseInt(str);

        return ((str.length() == DIGIT) && (num >= 0) && (num < Math.pow(10, DIGIT)));
    }

    /**
     * 스트라이크의 갯수를 구하는 메소드
     *
     * @param str 스트라이크의 갯수를 얻고자 하는 숫자의 문자열
     * @return 스트라이크의 갯수
     */
    private int getStrike(String str) {

        /* 스트라이크의 갯수 */
        int strikeCount = 0;

        for (int i = 0; i < DIGIT; i++) {

            /* 같은 자리에 있으면서 수가 같으면 스프라이크의 갯수 1 증가 */
            if (str.charAt(i) == number.charAt(i)) {
                strikeCount++;
            }
        }

        return strikeCount;
    }

    /**
     * 볼의 갯수를 구하는 메소드
     *
     * @param str 볼의 갯수를 얻고자 하는 숫자의 문자열
     * @return 볼의 갯수
     */
    private int getBall(String str) {

        /* 볼의 갯수 */
        int ballCount = 0;

        for (int i = 0; i < DIGIT; i++) {

            /* 다른 자리에 있으면서 수가 같으면 볼의 갯수 1 증가 */
            if ((str.charAt(i) != number.charAt(i)) && (set.contains(str.charAt(i) - '0'))) {
                ballCount++;
            }
        }

        return ballCount;
    }

    /* 스트라이크, 볼의 갯수에 대한 결과를 출력하는 메소드 */
    private void printResult(int strikeCount, int ballCount) {
        if (strikeCount != 0) {
            System.out.print(strikeCount + " 스트라이크 ");
        }

        if (ballCount != 0) {
            System.out.print(ballCount + " 볼");
        }

        if (strikeCount == 0 && ballCount == 0) {

            /* 입력한 수와 같은 수가 없는 경우에 실행 */
            System.out.print("Nothing");
        }

        System.out.println();
    }

    /* 3개의 숫자를 모두 맞혔는지 여부를 판단하는 메소드 */
    private boolean isSuccess(int strikeCount) {
        return (strikeCount == DIGIT);
    }

    /* 게임종료 메시지를 출력하는 메소드 */
    private void printSuccessGame() {
        System.out.println(DIGIT + "개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    /* 플레이어로부터 게임을 재시작할지 입력받는 메소드 */
    private int inputRestart() {
        Scanner sc = new Scanner(System.in);
        int answer;

        do {
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            answer = sc.nextInt();
        } while (!(answer == RESTART || answer == QUIT));

        return answer;
    }

    /* 게임을 재시작할지 여부를 확인하는 메소드 */
    private boolean isRestart() {
        return (inputRestart() == RESTART);
    }
}