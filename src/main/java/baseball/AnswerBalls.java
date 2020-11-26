/*
 * Class:   AnswerBalls.java
 *
 * Version: 1.0.0
 *
 * Date:    2020-11-26
 *
 * Author:  Dong Gun Lee
 *
 */

package baseball;

import utils.RandomUtils;
import java.util.ArrayList;

public class AnswerBalls {
    private ArrayList<Integer> answerBalls = new ArrayList<>();
    private final int START_NUM = 1;
    private final int END_NUM = 9;

    public AnswerBalls(){
        while (answerBalls.size() < 3){
            int newBall = RandomUtils.nextInt(START_NUM, END_NUM);
            if(!answerBalls.contains(newBall)) {
                answerBalls.add(newBall);
            }
        }
    }

    public ArrayList<Integer> getAnswerBalls() {
        return answerBalls;
    }
}
