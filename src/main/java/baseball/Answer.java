package baseball;

import utils.RandomUtils;

public class Answer {
    int[] answers = new int[Constants.MAX_LEN];
    boolean[] checkNumberDuplicated = new boolean[Constants.MAX_RANGE];
    int index = 0;

    public Answer(){
        while(index < Constants.MAX_LEN){
            int number = RandomUtils.nextInt(Constants.MIN_RANGE, Constants.MAX_RANGE-1);
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
