package baseball;

public class Status {
    private boolean gameOver;
    private int strike;
    private int ball;


    public Status() {
        gameOver = false;
        strike = 0;
        ball = 0;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    public void check(Baseballs answerBalls, Baseballs guessingBalls) {

    }
}
