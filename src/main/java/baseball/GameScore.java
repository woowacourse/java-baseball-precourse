package baseball;

import static util.GameConstant.*;

class GameScore {

    private int strike;
    private int ball;

    public GameScore() {
        this.strike = 0;
        this.ball = 0;
    }

    public void addStrike(){
        strike++;
    }

    public void addBall(){
        ball++;
    }

    public void printResult(){
        StringBuilder resultBuilder = new StringBuilder();
        if(ball > 0){
            resultBuilder.append(ball + BALL);
        }
        if(strike > 0){
            resultBuilder.append(strike + STRIKE);
        }
        if(strike == 0 && ball == 0){
            resultBuilder.append(NOTHING);
        }
        System.out.println(resultBuilder.toString());
        resetScore();
    }

    public int getStrike() {
        return strike;
    }

    public void resetScore(){
        strike = 0;
        ball = 0;
    }
}
