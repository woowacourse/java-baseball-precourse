package baseball;


import java.util.ArrayList;

public class Player {
    Baseball baseball;
    public Player(Baseball baseball){
        this.baseball = baseball;
    }

    public ArrayList<Integer> getBaseballs(){
        return baseball.getBaseballs();
    }
}
