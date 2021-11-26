package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import static baseball.constant.ConstantNumber.*;

public class AnswerNumberGenerator {
    ArrayList<Integer> answerNumberList = new ArrayList<Integer>();

    public ArrayList<Integer> GetAnswerNumber() {
        while (answerNumberList.size() < USER_NUMBER_LENGTH) {
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
