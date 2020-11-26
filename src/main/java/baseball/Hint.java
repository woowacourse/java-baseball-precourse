package baseball;

public class Hint {
    private int strike, ball;

    public Hint(int strike, int ball){
        this.strike = strike;
        this.ball = ball;
    }

    public void compareAnswerAndPlayerNumber(int[] answer, int[] playerAnswer){
        for(int i = 0; i < Constants.MAX_LEN; i++){
            countStrike(answer[i], playerAnswer[i]);
            countBall(answer, playerAnswer[i], i);
        }
    }

    private void countStrike(int answer, int playerAnswer){
        if(answer == playerAnswer){
            this.strike++;
        }
    }

    private void countBall(int[] answer, int playerAnswer, int digits){
        for(int i = 0; i < Constants.MAX_LEN; i++){
            if(i != digits && answer[i] == playerAnswer){
                this.ball++;
            }
        }
    }
}
