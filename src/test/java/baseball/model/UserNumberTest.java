package baseball.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class UserNumberTest {
    UserNumber userNumber;

    @ParameterizedTest
    @ValueSource(strings = {"31","311","3io","i",""," "})
    public void ExceptionTest(String input) {
        assertThatThrownBy(() -> {
            userNumber = new UserNumber(input);
        })
                .isInstanceOf(IllegalArgumentException.class);
    }
}