package baseball.service;

import baseball.constant.Constants;
import utils.RandomUtils;

import java.util.ArrayList;
import java.util.List;

public class AnswerGenerator {

    private AnswerGenerator() {
    }

    public static List<Integer> generateAnswer() {
        List<Integer> answer = new ArrayList<>();

        while (answer.size() != Constants.ANSWER_LENGTH) {
            int number = RandomUtils.nextInt(Constants.VALUE_ONE, Constants.VALUE_NINE);
            addNumber(answer, number);
        }

        return answer;
    }

    private static void addNumber(List<Integer> answer, int number) {

        if (!answer.contains(number)) {
            answer.add(number);
        }

    }
}
