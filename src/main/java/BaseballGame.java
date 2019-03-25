/*
 * @(#)BaseballGame.java       0.5 2019/03/25
 */

import java.util.*;

/**
 * 숫자야구게임을 진행하는 클래스
 *
 * @author 이도원
 * @version 0.5 2019/03/25
 */
public class BaseballGame {

    /* 숫자야구게임의 숫자 자릿수 */
    private static final int DIGIT = 3;

    /* 숫자의 범위 */
    private static final int NUMBER_RANGE = 9;

    /* 숫자의 최소 값 */
    private static final int MIN_NUMBER = 1;

    /* 컴퓨터가 선택한 숫자의 문자열 */
    private String number;

    /* 플레이어가 입력한 숫자의 문자열 */
    private String inputNumber;

    /* 선택한 한자릿수 정수를 저장하는 Set */
    private HashSet<Integer> set = new HashSet<>();

    /**
     * BaseballGame 클래스의 생성자
     */
    public BaseballGame() {
    }

    /**
     * 숫자야구게임을 진행하는 메소드
     */
    public void start() {
        System.out.print("게임을 시작합니다!\n");
        selectNumber();
        inputNumber();
        printStrike(inputNumber);
        printBall(inputNumber);
    }

    /* 임의의 3자리의 수를 선택하는 메소드. */
    private void selectNumber() {
        Random random = new Random();
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

    /* 플레이어로부터 숫자를 입력받는 메소드 */
    private void inputNumber() {
        Scanner scanner = new Scanner(System.in);
        String inputString;

        /* 입력받은 수가 3자리 정수가 아니면 다시 입력받음 */
        do {
            System.out.print("숫자를 입력해주세요 : ");
            inputString = scanner.nextLine();
        } while (!isCorrectNumber(inputString));

        inputNumber = inputString;
    }

    /* 입력받은 문자열이 3자리의 정수로 이루어진 문자열인지 판단하는 메소드 */
    private boolean isCorrectNumber(String str) {
        int num = Integer.parseInt(str);

        return ((str.length() == DIGIT) && (num >= 0) && (num < Math.pow(10, DIGIT)));
    }

    /* 스트라이크의 갯수 출력하는 메소드 */
    private void printStrike(String str) {

        /* 스트라이크의 갯수 */
        int strikeCount = 0;

        for (int i = 0; i < DIGIT; i++) {

            /* 같은 자리에 있으면서 수가 같으면 스프라이크의 갯수 1 증가 */
            if (str.charAt(i) == number.charAt(i)) {
                strikeCount++;
            }
        }

        System.out.print(strikeCount + " 스트라이크 ");
    }

    /* 볼의 갯수 출력하는 메소드 */
    private void printBall(String str) {

        /* 볼의 갯수 */
        int ballCount = 0;

        for (int i = 0; i < DIGIT; i++) {

            /* 다른 자리에 있으면서 수가 같으면 볼의 갯수 1 증가 */
            if ((str.charAt(i) != number.charAt(i)) && (set.contains(str.charAt(i) - '0'))) {
                ballCount++;
            }
        }

        System.out.println(ballCount + " 볼");
    }
}