package baseball;

import java.util.ArrayList;
import java.util.List;

public class Ball {
    public List<String>ball = new ArrayList<>();

    public Ball(){
    }

    public boolean contains(String x){
        return this.ball.contains(x);
    }

    public boolean validate(String x){
        return x.length()==3;
    }

    public void lengthcheck(boolean x){

    }


}
