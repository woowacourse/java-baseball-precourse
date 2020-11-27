package baseball;

import java.util.ArrayList;

public class Player {
    private Baseball baseball;
    public Player(Baseball baseball){
        this.baseball = baseball;
    }

    public ArrayList<Integer> getBaseballs(){
        return baseball.getBaseballs();
    }
}
