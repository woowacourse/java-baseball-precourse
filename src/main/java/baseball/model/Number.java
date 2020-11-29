package baseball.model;

import java.util.ArrayList;

public class Number {
    private static final int MIN = 1;
    private static final int MAX = 9;
    private static final String INVALID_RANGE = "1~9 사이의 숫자가 아닙니다.";

    private final int number;

    private Number(int number){
        this.number = number;
    }

    public static Number valueOf(int number){
        if (number < MIN || MAX < number){
            throw new IllegalArgumentException(INVALID_RANGE);
        }
        return new Number(number);
    }

    @Override
    public boolean equals(Object obj){
        if (this == obj){
            return true;
        }
        if (obj == null){
            return false;
        }
        if (this.getClass() != obj.getClass()){
            return false;
        }
        Number paramObj = (Number) obj;
        return this.number == paramObj.number;
    }

    @Override
    public int hashCode(){
        return this.number;
    }
}
