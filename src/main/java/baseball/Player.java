package baseball;

public class Player {

    private int strike;
    private int ball;
    private int[] playerInput;

    public void init(){
        this.strike = 0;
        this.ball = 0;
        this.playerInput = new int[3];
    }

    private void addStrike(){
        strike++;
    }

    private void addBall(){
        ball++;
    }

    public void checkBallOrStrike(int ansNum, int ansNumIdx){
        for(int i=0; i< playerInput.length; i++){
            if(ansNum==playerInput[i]){
                if(ansNumIdx==i){
                    addStrike();
                    return;
                }
                addBall();
                return;
            }
        }
    }


    public void setPlayerInput(int[] playerInput) {
        this.playerInput = playerInput;
    }

    public int getStrike() {

        return strike;
    }

    public int getBall() {

        return ball;
    }
}
