package com.github.callmewaggs.javabaseballprecourse;

import java.util.Scanner;

public class Game {
    private Computer computer;
    private User user;
    private Score score;
    private boolean play;

    public Game() {
        computer = new Computer();
        user = new User();
        score = new Score();
        play = true;
    }

    public void gameStart() {
        computer.generateRandomBall();

        while (play) {
            score.init();
            user.generateInputBall();

            score.calculateWinning(computer.getNumbers(), user.getNumbers());
            score.printScore();

            if (score.isWin()) {
                askGameAgain();
            }
        }
    }

    private void askGameAgain() {
        int flag;
        while (true) {
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            Scanner scan = new Scanner(System.in);
            flag = scan.nextInt();

            if (!(flag == 1 || flag == 2))
                System.out.println("다시 입력해 주세요.");
            else
                break;
        }

        if (flag == 1) {
            computer.generateRandomBall();
            score.init();
        } else {
            play = false;
        }
    }
}
