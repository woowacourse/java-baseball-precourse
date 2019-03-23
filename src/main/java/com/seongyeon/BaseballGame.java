package com.seongyeon;

import java.util.Scanner;

/*
 * 날짜 2019-03-23
 */

public class BaseballGame {

    static final int START = 1;

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int input;
        int restart = 0;
        boolean isEnd;

        do {
            isEnd = false;
            Computer computer = new Computer();
            computer.makeNum();

            while (isEnd == false) {
                System.out.print("숫자를 입력해주세요 : ");
                input = scan.nextInt();
                isEnd = computer.checkNum(input);
            }

            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            restart = scan.nextInt();

        } while (restart == START);

    }
}