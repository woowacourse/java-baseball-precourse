package baseball.model;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class UserNumberTest {
    PlayerNumber userNumber;

    @ParameterizedTest
    @ValueSource(strings = {"31","311","3io","i",""," "})
    public void ExceptionTest(String input) {
        assertThatThrownBy(() -> {
            userNumber = new PlayerNumber();
        })
                .isInstanceOf(IllegalArgumentException.class);
    }
}