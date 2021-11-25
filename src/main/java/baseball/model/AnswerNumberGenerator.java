package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;

public class AnswerNumberGenerator {
    private final static int MIN_RANGE_NUM = 1;
    private final static int MAX_RANGE_NUM = 9;
    private final static int MAX_NUMBER_SIZE = 3;

    ArrayList<Integer> answerNumberList = new ArrayList<Integer>();

    public ArrayList<Integer> GetAnswerNumber() {
        while (answerNumberList.size() < MAX_NUMBER_SIZE) {
            isNumberInList(Randoms.pickNumberInRange(MIN_RANGE_NUM, MAX_RANGE_NUM), answerNumberList);
        }
        return answerNumberList;
    }

    public void isNumberInList(int number, ArrayList<Integer> list) {
        if (list.contains(number)) {

        }
        list.add(number);
    }
}
