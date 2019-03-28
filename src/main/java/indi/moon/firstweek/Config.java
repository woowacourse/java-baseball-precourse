package indi.moon.firstweek;

import java.util.stream.Stream;

public class Config implements Configface {
    public final String USER_NAME = "User";
    public final String COMPUTER_NAME = "Computer";
    @Override
    public int[] makeNumArray(String num){
        int[] arrayNum ={0,0,0,0};
        try {
            arrayNum = Stream.of(num.split("")).mapToInt(Integer::parseInt).toArray();
        }catch(Exception e){
            System.out.println("숫자 이외의 값을 입력하였습니다. \n규칙을 위반하여 1회 패널티를 부여합니다.");
        }
        return arrayNum;
    }

    public Boolean choosePre(){
        double random = Math.random();
        return (random>0.5 ? true : false);
    }
}
