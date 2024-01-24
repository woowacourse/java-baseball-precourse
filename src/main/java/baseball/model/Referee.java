package baseball.model;

import java.util.List;
import java.util.Objects;

public class Referee {

    private Referee() {
    }

    public static Result call(Number answer, Number number) {
        List<Integer> answerDigits = answer.fetchDigits();
        List<Integer> numberDigits = number.fetchDigits();

        int strikeCount = 0;
        int ballCount = 0;

        for (int i = 0; i < answerDigits.size(); i++) {
            if (Objects.equals(answerDigits.get(i), numberDigits.get(i))) {
                strikeCount += 1;
                continue;
            }

            if (answerDigits.contains(numberDigits.get(i))) {
                ballCount += 1;
            }
        }

        return new Result(strikeCount, ballCount);
    }
}
