package baseball.domain.judge.exception;

import baseball.domain.judge.judgeRule.JudgeRule;

public final class JudgeNotExistException extends RuntimeException {

    private static final String MESSAGE = "존재하지 않는 판정입니다. (입력 값: '%s')";

    public JudgeNotExistException(final JudgeRule input) {
        super(String.format(MESSAGE, input.getClass().getName()));
    }
}
