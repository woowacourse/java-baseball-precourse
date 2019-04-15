/*
 * @(#)Computer.java        0.3 2019/03/26
 *
 *
 */

package baseballgame;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 기능 목록 2 - 컴퓨터가 1부터 9까지 서로 다른 수로 이루어진 3자리의 수를 생성 하는 클래스입니다.
 *
 * @version         0.4 2019년 3월 26일
 * @author          반선호
 */
class Computer {
    private static final int MAX_NUM = 9;
    private static final int ONE = 1;
    private static final int BALL_LEN = 3;

    private List<Integer> computer = new ArrayList<>(BALL_LEN);

    /**
     * Computer 생성자이며 서로 다른 수로 이루어진 3자리의 수를 만들어 낸다.
     */
    Computer(){
        Random random;
        int temp;

        while(computer.size() < BALL_LEN){
            random = new Random();
            temp = random.nextInt(MAX_NUM) + ONE;
            if(!computer.contains(temp)){
                computer.add(temp);
            }
        }
    }
}
