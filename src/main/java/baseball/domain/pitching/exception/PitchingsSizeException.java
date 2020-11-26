package baseball.domain.pitching.exception;

import baseball.domain.pitching.Pitching;
import baseball.domain.pitching.Pitchings;
import java.util.List;
import java.util.stream.Collectors;

public final class PitchingsSizeException extends IllegalArgumentException {

    private static final String MESSAGE = "투구 개수는 " + Pitchings.SIZE + "개 이어야 합니다. (입력 값: '%s')";
    private static final String DELIMITER = "";

    public PitchingsSizeException(final String input) {
        super(String.format(MESSAGE, input));
    }

    public PitchingsSizeException(final List<Pitching> input) {
        super(String.format(MESSAGE, join(input)));
    }

    static String join(final List<Pitching> input) {
        return input.stream()
            .map(String::valueOf)
            .collect(Collectors.joining(DELIMITER));
    }
}
