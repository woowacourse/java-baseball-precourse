package indi.moon.firstweek;

import java.util.stream.Stream;

public class Config implements Configface {
    public final String USER_NAME = "User";
    public final String COMPUTER_NAME = "Computer";
    @Override
    public int[] makeNumArray(String num){
        int[] arrayNum = Stream.of(num.split("")).mapToInt(Integer::parseInt).toArray();

        return arrayNum;
    }

    public Boolean choosePre(){
        double random = Math.random();
        return (random>0.5 ? true : false);
    }
}
