package controller;

import controller.domain.BaseballStatus;
import controller.domain.BaseballStatusImpl;
import input.InputCheck;

public class GameBoard {

    private static final int NOT_INITIALIZED = -1; // 아직 아무것도 받은 숫자가 없음
    private static final String RESTART = "1";
    private static final String STOP = "2";

    private RandomVendor vendor;
    private InputCheck checker;

    private int goal; // 맞춰야 하는 숫자
    private boolean terminal;

    public GameBoard(InputCheck checker, RandomVendor vendor) {
        this.goal = NOT_INITIALIZED;
        this.checker = checker;
        this.vendor = vendor;
        this.terminal = false;
    }

    public int getGoal() {
        return goal;
    }

    public void initGameBoard() {
        goal = vendor.roll();
        setTerminal(false);
    }

    private void setTerminal(boolean terminal) {
        this.terminal = terminal;
        checker.setTerminal(terminal);
    }

    public boolean isTerminal() {
        return terminal;
    }

    public boolean restart(String command) {

        checker.check(command);

        boolean select = false;

        if(command.equals(RESTART)) {
            select = true;
            initGameBoard();
        }

        return select;
    }

    public BaseballStatus predict(String guess) {

        checker.check(guess);

        BaseballStatus status = new BaseballStatusImpl();

        int strike = findStrike(Integer.parseInt(guess));
        int ball = findBall(Integer.parseInt(guess));

        status.setStrike(strike);
        status.setBall(ball);

        if(status.isCorrect()) {
            setTerminal(true);
        }

        return status;
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
