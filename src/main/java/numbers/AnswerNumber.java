package numbers;

import utils.RandomUtils;

import java.util.ArrayList;

public class AnswerNumber {
    private static final int NUMBER_LENGTH = 3;
    private final ArrayList<Integer> answerNumber;

    public AnswerNumber(ArrayList<Integer> answerNumber) {
        this.answerNumber = answerNumber;
    }

    public static AnswerNumber creatAnswerNumber() { //객체를 생성하는 메소드
        return new AnswerNumber(makeAnswerNumber());
    }

    private static ArrayList<Integer> makeAnswerNumber() {
        ArrayList<Integer> randomNumberList = new ArrayList<>();

        while (randomNumberList.size() < NUMBER_LENGTH) {
            int number = RandomUtils.nextInt(1, 9);
            if (!randomNumberList.contains(number)) {
                randomNumberList.add(number);
            }
        }
        return randomNumberList;
    }

    public ArrayList<Integer> getAnswerNumber() {
        return answerNumber;
    }
}