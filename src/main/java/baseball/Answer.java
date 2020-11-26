/*
* @(#)Answer.java
*
*/

package baseball;

import utils.RandomUtils;

public class Answer {
    int[] answers = new int[Constants.MAX_LEN];
    boolean[] checkNumberDuplicated = new boolean[Constants.MAX_RANGE];
    int index = 0;

    /**
     * 생성자
     * Answer 객체 생성 시 서로 다른 1~9사이의 수로 이루어진 임의의 3가지 수를 생성한다.
     */
    public Answer(){
        while(index < Constants.MAX_LEN){
            int number = RandomUtils.nextInt(Constants.MIN_RANGE+1, Constants.MAX_RANGE-1);
            if(!checkNumberDuplicated[number]){
                checkNumberDuplicated[number] = true;
                answers[index++] = number;
            }
        }
    }

    public int[] getAnswers() {
        return answers;
    }
}
