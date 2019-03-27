/*
* Baseball
*
* Ver 1.0
*
* Mar 25 2019
*
* Copyright 2019 KKW
*/

package baseball;

import java.util.Scanner;
import java.util.InputMismatchException;


public class Baseball {
    public static void main(String[] args) {
        new Game();
    }
}


class Game {
    private Scanner scanner = new Scanner(System.in);
    private int[] myNumbers = new int[3];
    private int[] yourNumbers = {1, 2, 3, 4, 5, 6, 7, 8, 9};

    Game() {
        initGame();
    }

    private void initGame() {
        for (int i = 0; i < 8; i++) {
            final int j = (int) (Math.random() * (8 - i)) + 1;
            final int temp = yourNumbers[i];
            yourNumbers[i] = yourNumbers[j];
            yourNumbers[j] = temp;
        }
        numbersInput();
    }

    private void numbersInput() {
        int input = 0;

        System.out.println("숫자를 입력해주세요 : ");
        try {
            input = scanner.nextInt();
            myNumbers[0] = input / 100;
            myNumbers[1] = input % 100 / 10;
            myNumbers[2] = input % 10;
            if (input < 123 || input > 987
                    || myNumbers[0] == myNumbers[1]
                    || myNumbers[1] == myNumbers[2]
                    || myNumbers[2] == myNumbers[0]) {
                System.out.println("잘못된 입력입니다.");
                numbersInput();
            } else {
                play();
            }
        } catch (InputMismatchException e) {
            scanner.next();
            System.out.println("잘못된 입력입니다.");
            numbersInput();
        }
    }

    private void play() {
        int strike = 0;
        int ball = 0;

        for (int i = 0; i < 9; i++) {
            if (myNumbers[i / 3] == yourNumbers[i % 3]) {
                int temp = (i / 3 == i % 3) ? strike++ : ball++;
            }
        }
        if (strike + ball == 0) {
            System.out.println("낫싱");
            numbersInput();
        } else {
            String strikeString = (strike > 0) ? strike + " 스트라이크" : "";
            String space = (strike > 0 && ball > 0) ? " " : "";
            String ballString = (ball > 0) ? ball + "볼" : "";
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
        int input = 0;

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