package baseball.domain;

import java.util.Objects;

public class Validator {

    public static final String INPUT_NULL_MESSAGE = "null 값을 입력하셨습니다!";

    public void validateNumbers(String numbers) {
        checkNull(numbers);
    }

    private void checkNull(String numbers) {
        if (Objects.isNull(numbers)) {
            throw new IllegalArgumentException(INPUT_NULL_MESSAGE);
        }
    }
}
