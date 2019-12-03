/*
 * @(#)BaseballGame.java        0.8 2019/12/03
 *
 * Copyright (c) 2019 lxxjn0.
 */
package com.lxxjn0.baseball;

/**
 * 게임의 전체적인 진행을 담당. 컴퓨터와 사용자로부터 3자리 숫자를 저장하고 이를 통해 스트라이크와 볼,
 * 그리고 낫싱 여부를 구해서 출력. 위 결과를 통해 답과 일치 여부를 판단하고, 정답일 경우 게임을 종료,
 * 사용자로부터 재진행 여부를 입력을 받아서 결정하는 클래스.
 *
 * @author JUNYOUNG LEE (lxxjn0)
 * @version 0.8 2019/12/03
 */
public class BaseballGame {
    /**
     * 스트라이크 또는 볼이 0개인 경우를 판단하기 위한 상수
     */
    private static final int COUNT_ZERO = 0;

    /**
     * 사용자가 3개의 숫자를 맞췄는지 확인하기 위한 상수
     */
    private static final int CORRECT_ANSWER = 3;

    /**
     * 게임 시작 시 3자리 수를 생성할 Computer 클래스 객체
     */
    private Computer computer;

    /**
     * 사용자로부터의 3자리 수 입력과 게임 진행 여부 입력을 위한 User 클래스 객체
     */
    private User user;

    /**
     * 생성된 수와 사용자가 입력한 수를 통해 판정을 내리는 Referee 클래스 객체
     */
    private Referee referee;

    /**
     * 처음 게임을 시작하며, 게임 종료 시 사용자의 입력을 통해 게임을 다시 시작하거나 종료하는 메서드.
     */
    public void run() {
        do {
            playBaseball();
        } while (playBaseballAgain());
    }

    /**
     * 게임(3자리 수 생성부터 사용자 입력, 답과 일치하면 종료하는 기능까지)이 진행되는 메서드.
     */
    private void playBaseball() {
        computer = new Computer();
        user = new User();

        do {
            user.receiveInput();
            referee = new Referee(computer.getGeneratedNumber(),
                    user.getEnteredNumber());

            if (referee.judgeNothing()) {
                System.out.println("낫싱");
            } else {
                printStrikeNBall();
            }
        } while (!isCorrectAnswer());
    }

    /**
     * 스트라이크와 볼을 출력해주는 메서드.
     */
    private void printStrikeNBall() {
        if (referee.getStrikeNumber() == COUNT_ZERO) {
            System.out.printf("%d 볼\n", referee.getBallNumber());
        } else if (referee.getBallNumber() == COUNT_ZERO) {
            System.out.printf("%d 스트라이크\n", referee.getStrikeNumber());
        } else {
            System.out.printf("%d 스트라이크 %d볼\n", referee.getStrikeNumber(),
                    referee.getBallNumber());
        }
    }

    /**
     * 사용자가 입력한 3자리 수가 정답(생성된 수)과 일치하는지를 스트라이크 개수로 판단하는 메서드.
     *
     * @return 사용자가 입력한 3자리 수가 모두 일치한다면 true 반환.
     */
    private boolean isCorrectAnswer() {
        if (referee.getStrikeNumber() == CORRECT_ANSWER) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        }
        return false;
    }

    /**
     * 사용자로부터 입력을 받아 게임을 다시 시작 또는 종료 여부를 결정하는 메서드.
     *
     * @return 게임을 다시 시작할 경우 true 반환한다.
     */
    private boolean playBaseballAgain() {
        return user.receivePlayAgainInput();
    }
}