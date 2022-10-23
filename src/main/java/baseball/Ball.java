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

    public boolean validate(String x) {
        if(validateLength(x)){
            throw new IllegalArgumentException("세 자리 숫자를 입력하세요.");
        }
        else return true;
    }

    public boolean validateLength(String x){
        return x.length()!=3;
    }



}
