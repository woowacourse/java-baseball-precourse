package baseball.domain.judge.exception;

import baseball.domain.judge.Judge;
import baseball.domain.judge.Judgement;
import java.util.List;
import java.util.stream.Collectors;

public final class JudgeMultipleJudgementException extends RuntimeException {

    private static final String MESSAGE = "판정은 " + Judge.JUDGEMENT_BOUNDARY + "개 이어야 합니다. (입력 값: '%s')";
    private static final String DELIMITER = ", ";

    public JudgeMultipleJudgementException(final int input) {
        super(String.format(MESSAGE, input));
    }

    public JudgeMultipleJudgementException(final List<Judgement> input) {
        super(String.format(MESSAGE, join(input)));
    }

    private static String join(final List<Judgement> input) {
        return input.stream()
            .map(Judgement::name)
            .collect(Collectors.joining(DELIMITER));
    }
}
