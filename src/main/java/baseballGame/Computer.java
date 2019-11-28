/*
 *  @Computer.java
 *
 *  기능: 1부터 9까지 서로 다른 수로 이뤄진 3자리 수를 생성
 *
 *  @Version: 0.2
 *
 *  @Date: 2019.11.28
 *
 *  @Author: pandahun
 */

package baseballGame;

import java.util.Random;

public class Computer {

    private static final int MAX_NUMBER = 9;

    private static final int ONE = 1;

    private static final int BALL_LENGTH = 3;

    private String number;

    public Computer(){
        Random random;

        while (number.length() < BALL_LENGTH){
            random = new Random();
            int temp = random.nextInt(MAX_NUMBER) + ONE;

            if(isDifferent(temp)){
                number +=String.valueOf(temp);
            }
        }
    }

    private boolean isDifferent(int temp){
        return !(number.contains(String.valueOf(temp)));
    }

    public String getNumber(){
        return number;
    }
}
