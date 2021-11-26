package baseball.model;

import baseball.constant.Constant;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;

public class AnswerNumber {
    private String answerNumber;

    public AnswerNumber() {
        getNewAnswerNumber();
    }

    public String getAnswerNumber() {
        return answerNumber;
    }

    public void getNewAnswerNumber() {
        ArrayList<String> answerNumberList = new ArrayList<String>();

        while (answerNumberList.size() < Constant.USER_NUMBER_LENGTH) {
            isNumberInList(getStringRandomNumber(), answerNumberList);
        }
        this.answerNumber = String.join("", answerNumberList);
    }

    public static void isNumberInList(String number, ArrayList<String> list) {
        if (!list.contains(number)) {
            list.add(number);
        }

    }

    public static String getStringRandomNumber() {
        return Integer.toString(Randoms.pickNumberInRange(Constant.MIN_RANGE_NUM, Constant.MAX_RANGE_NUM));
    }
}
