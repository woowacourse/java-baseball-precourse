/*
 *  @Computer.java
 *
 *  기능: 1부터 9까지 서로 다른 수로 이뤄진 3자리 수를 생성
 *
 *  @Version: 0.1
 *
 *  @Date: 2019.11.27
 *
 *  @Author: pandahun
 */

package baseballGame;

import java.util.Random;

public class Computer {

    private static final int MAX_NUMBER = 9;

    private static final int ONE = 1;

    private static final int BALL_LENGTH = 3;

    String number;

    public Computer(){
        Random random;

        while (number.length() < 3){
            random = new Random();
            int temp = random.nextInt(MAX_NUMBER) + ONE;

            if(isDifferent(temp)){
                number +=String.valueOf(temp);
            }
        }
    }

    public boolean isDifferent(int temp){
        return !(number.contains(String.valueOf(temp)));
    }
}
