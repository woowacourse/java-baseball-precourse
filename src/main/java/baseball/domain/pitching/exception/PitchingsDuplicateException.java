package baseball.domain.pitching.exception;

import baseball.domain.pitching.Pitching;
import java.util.List;

public final class PitchingsDuplicateException extends IllegalArgumentException {

    private static final String MESSAGE = "중복된 투구 값이 존재합니다. (입력 값: '%s')";

    public PitchingsDuplicateException(final List<Pitching> input) {
        super(String.format(MESSAGE, PitchingsSizeException.join(input)));
    }
}
