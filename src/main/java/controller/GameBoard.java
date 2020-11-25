package controller;

import controller.domain.BaseballStatus;
import controller.domain.BaseballStatusImpl;

public class GameBoard {

    private static final int NOT_INITIALIZED = -1; // 아직 아무것도 받은 숫자가 없음

    private int goal; // 맞춰야 하는 숫자

    public GameBoard() {
        this.goal = NOT_INITIALIZED;
    }

    public void setGoal(int goal) {
        this.goal = goal;
    }

    public BaseballStatus predict(int guess) {

        BaseballStatusImpl dto = new BaseballStatusImpl();

        int strike = findStrike(guess);
        int ball = findBall(guess);

        dto.setStrike(strike);
        dto.setBall(ball);

        return dto;
    }

    private int findBall(int guess) {

        int ball = 0;

        String goal = String.valueOf(this.goal);
        String gussStr = String.valueOf(guess);

        for(int i = 0; i < goal.length(); i++) {

            int idx = gussStr.indexOf(goal.charAt(i));

            if(idx != -1 && idx != i) {
                ball += 1;
            }
        }

        return ball;
    }

    private int findStrike(int guess) {

        int goalTemp = goal;

        int strike = 0;

        while(guess != 0) {

            int guessNum = guess % 10;
            int goalNum = goalTemp % 10;

            if(guessNum == goalNum) {
                strike += 1;
            }

            guess /= 10;
            goalTemp /= 10;
        }

        return strike;
    }
}
