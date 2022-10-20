package baseball;

import java.util.ArrayList;
import java.util.List;

public class Ball {
    public List<Integer>ball = new ArrayList<>();

    public Ball(){
    }

    public boolean contains(int x){
        return this.ball.contains(x);
    }

}
