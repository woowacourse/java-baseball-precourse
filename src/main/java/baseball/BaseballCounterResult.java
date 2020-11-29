package baseball;

public class BaseballCounterResult {
    private int strike = 0;
    private int ball = 0;

    public void increaseStrike(){
        strike++;
    }

    public void increaseBall(){
        ball++;
    }

    public int getStrike(){
        return strike;
    }

    public int getBall(){
        return ball;
    }
}
