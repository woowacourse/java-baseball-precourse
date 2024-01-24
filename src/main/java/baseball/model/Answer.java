package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;


public class Answer extends Number {

    public Answer() {
        super();
        Integer answer = makeAnswer();
        this.setValue(answer);
    }

    private Integer makeAnswer() {
        List<Integer> answerDigits = new ArrayList<>();

        while (answerDigits.size() != DIGIT_NUMBER_CONDITION) {
            int digit = Randoms.pickNumberInRange(1, 9);
            addIfNotContained(answerDigits, digit);
        }

        StringBuilder stringBuilder = new StringBuilder();

        for (Integer integer : answerDigits) {
            stringBuilder.append(integer);
        }

        return Integer.parseInt(stringBuilder.toString());
    }

    private void addIfNotContained(List<Integer> answerDigits, int digit) {
        if (!answerDigits.contains(digit)) {
            answerDigits.add(digit);
        }
    }
}
