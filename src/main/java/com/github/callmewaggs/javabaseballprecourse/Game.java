package com.github.callmewaggs.javabaseballprecourse;

import java.util.Scanner;

public class Game {
    private Computer computer;
    private User user;
    private Score score;

    public Game() {
        computer = new Computer();
        user = new User();
        score = new Score();
    }

    public void gameStart() {
        computer.generateRandomBall();

        while (true) {
            score.init();
            user.generateInputBall();

            score.calculateWinning(computer.getNumbers(), user.getNumbers());
            score.printScore();

            if (score.isWin()) {
                if (gameAgain()) {
                    computer.generateRandomBall();
                    score.init();
                } else {
                    break;
                }
            }
        }
    }

    private boolean gameAgain() {
        while (true) {
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            Scanner scan = new Scanner(System.in);
            int flag = scan.nextInt();

            if (flag == 1)
                return true;
            else if (flag == 2)
                return false;
            else {
                System.out.println("다시 입력해 주세요.");
            }
        }
    }
}
