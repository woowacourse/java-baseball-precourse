package baseball.domain;

public class ScoreBoard {
    private int strike = 0;
    private int ball = 0;
    private int numbersToGuess = 0;

    public ScoreBoard(int strike, int ball, int numbersToGuess){
        this.strike = strike;
        this.ball = ball;
        this.numbersToGuess = numbersToGuess;
    }

    public int getStrike(){
        return this.strike;
    }

    public int getBall(){
        return this.ball;
    }

    public int getNumbersToGuess(){
        return this.numbersToGuess;
    }
}
