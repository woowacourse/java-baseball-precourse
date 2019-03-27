package indi.moon.firstweek;

import java.util.stream.Stream;

public class Config implements Configface {

    @Override
    public int[] makeNumArray(String num){
        int[] arrayNum = Stream.of(num.split("")).mapToInt(Integer::parseInt).toArray();

        return arrayNum;
    }
}
