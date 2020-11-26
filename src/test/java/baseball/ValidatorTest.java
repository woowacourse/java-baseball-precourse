package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import baseball.domain.Validator;

public class ValidatorTest {

    @Test
    @DisplayName("입력 값이 null일 경우 IllegalArgumentException 발생")
    public void inputNullValidationTest() {
        Validator validator = new Validator();
         assertThatIllegalArgumentException().isThrownBy(() -> validator.validateNumbers(null))
                 .withMessage(Validator.INPUT_NULL_MESSAGE);
    }
}
