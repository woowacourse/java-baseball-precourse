package baseball.domain.pitching.exception;

public final class PitchingsInputNotDigitException extends IllegalArgumentException {

    private static final String MESSAGE = "숫자만 입력 가능합니다. (입력 값: '%s')";

    public PitchingsInputNotDigitException(final String input) {
        super(String.format(MESSAGE, input));
    }
}
