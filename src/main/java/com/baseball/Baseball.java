/*
* Copyright 2019 KKW
*
* Baseball Ver 1.0
*/


package com.baseball;

import java.util.Scanner;
import java.util.InputMismatchException;


public class Baseball {
    public static void main(String[] args) {
        new Game();
    }
}


class Game {
    private final Scanner scanner = new Scanner(System.in);
    private final int[] myNumbers = new int[3];
    private final int[] yourNumbers = {1, 2, 3, 4, 5, 6, 7, 8, 9};

    Game() {
        initGame();
    }

    /**
    * 1 ~ 9를 담은 배열을 Fisher-Yates 알고리즘으로 섞어서 앞의 3자리를 컴퓨터 숫자로 사용
    */
    private void initGame() {
        for (int i = 0; i < yourNumbers.length - 1; i++) {
            final int j = (int) (Math.random() * (yourNumbers.length - i)) + i;
            final int temp = yourNumbers[i];
            yourNumbers[i] = yourNumbers[j];
            yourNumbers[j] = temp;
        }
        numbersInput();
    }

    private void numbersInput() {
        final int input;

        System.out.println("숫자를 입력해주세요 : ");
        try {
            input = scanner.nextInt();
        } catch (InputMismatchException e) {
            scanner.next();
            System.out.println("잘못된 입력입니다.");
            numbersInput();
            return;
        }
        myNumbers[0] = input / 100;
        myNumbers[1] = input % 100 / 10;
        myNumbers[2] = input % 10;
        if (input < 123
                || input > 987
                || myNumbers[0] == myNumbers[1]
                || myNumbers[1] == myNumbers[2]
                || myNumbers[2] == myNumbers[0]) {
            System.out.println("잘못된 입력입니다.");
            numbersInput();
        } else {
            play();
        }
    }

    /**
     * 사용자가 택한 세 자리 수와 생성된 수를 각각 (1번쨰, 1번째), (1번쨰, 2번째), ..., (3번째, 3번째) 자리끼리
     * 총 9번 비교하여 해를 구한다.
     */
    private void play() {
        final int CYCLE = myNumbers.length;
        int strike = 0;
        int ball = 0;
        String strikeString;
        String space;
        String ballString;

        for (int i = 0; i < yourNumbers.length; i++) {
            if (myNumbers[i / CYCLE] == yourNumbers[i % CYCLE]) {
                int temp = (i / CYCLE == i % CYCLE) ? strike++ : ball++;
            }
        }
        if (strike + ball == 0) {
            System.out.println("낫싱");
            numbersInput();
        } else {
            strikeString = (strike > 0) ? strike + " 스트라이크" : "";
            space = (strike > 0 && ball > 0) ? " " : "";
            ballString = (ball > 0) ? ball + "볼" : "";
            System.out.println(strikeString + space + ballString);
            if (strike == 3) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                commandInput();
            } else {
                numbersInput();
            }
        }
    }

    private void commandInput() {
        final int input;

        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        try {
            input = scanner.nextInt();
            if (input == 1) {
                initGame();
            } else if (input != 2) {
                System.out.println("잘못된 입력입니다.");
                commandInput();
            }
        } catch (InputMismatchException e) {
            scanner.next();
            System.out.println("잘못된 입력입니다.");
            commandInput();
        }
    }
}