package numbers;

import utils.RandomUtils;

import java.util.ArrayList;

public class BaseballNumber {
    private static final int NUMBER_LENGTH = 3;
    private final ArrayList<Integer> answerNumber;

    public BaseballNumber() {
        answerNumber = setAnswerNumber();
    }

    public ArrayList<Integer> setAnswerNumber(){
        ArrayList<Integer> randomNumberList = new ArrayList<>();
        while(randomNumberList.size() < NUMBER_LENGTH) {
            int number = RandomUtils.nextInt(1, 9);
            if(!randomNumberList.contains(number)) {
                randomNumberList.add(number);
            }
        }
        return randomNumberList;
    }
}
