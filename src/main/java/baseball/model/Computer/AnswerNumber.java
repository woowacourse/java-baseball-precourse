package baseball.model.Computer;

import baseball.constant.Constant;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.LinkedHashSet;

public class AnswerNumber {
    private String answerNumber;

    public AnswerNumber() {
        getNewAnswerNumber();
    }

    public String getAnswerNumber() {
        return answerNumber;
    }

    public void getNewAnswerNumber() {
        LinkedHashSet<String> numberList = new LinkedHashSet<String>();

        while (numberList.size() < Constant.USER_NUMBER_LENGTH) {
            numberList.add(getStringRandomNumber());
        }
        this.answerNumber = String.join("", numberList);
    }

    public static String getStringRandomNumber() {
        return Integer.toString(Randoms.pickNumberInRange(Constant.MIN_RANGE_NUM, Constant.MAX_RANGE_NUM));
    }
}