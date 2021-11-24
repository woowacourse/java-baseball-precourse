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
        if(strike > 0 && ball > 0){
            System.out.println(ball + BALL + " " + strike + STRIKE);
        }else if(strike > 0){
            System.out.println(strike + STRIKE);
        }else if(ball > 0){
            System.out.println(ball + BALL);
        }else{
            System.out.println(NOTHING);
        }
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
