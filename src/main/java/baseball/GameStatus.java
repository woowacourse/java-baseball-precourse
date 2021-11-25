package baseball;

public class GameStatus {
    private int strike_num;
    private int ball_num;

    public GameStatus(int strike_num, int ball_num){
        this.strike_num=strike_num;
        this.ball_num=ball_num;
    }

    public int getBall_num() {
        return this.ball_num;
    }

    public void setBall_num(int ball_num){
        this.ball_num=ball_num;
    }

    public int getStrike_num(){
        return this.strike_num;
    }

    public void setStrike_num(){
        this.strike_num=strike_num;
    }
}
