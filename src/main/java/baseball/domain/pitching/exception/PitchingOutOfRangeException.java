package baseball.domain.pitching.exception;

import baseball.domain.pitching.Pitching;

public final class PitchingOutOfRangeException extends IllegalArgumentException {

    private static final String MESSAGE =
        "투구 값은 최소 " + Pitching.MIN_VALUE + ", 최대 " + Pitching.MAX_VALUE + " 이어야 합니다. (입력 값: '%s')";

    public PitchingOutOfRangeException(final int input) {
        super(String.format(MESSAGE, input));
    }
}
