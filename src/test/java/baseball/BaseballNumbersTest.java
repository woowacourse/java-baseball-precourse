package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import baseball.domain.BaseballNumbers;

public class BaseballNumbersTest {

    @Test
    @DisplayName("중복된 숫자가 없는 문자열 테스트")
    public void hasNotDuplicateNumberTest() {
        BaseballNumbers baseballNumbers = new BaseballNumbers("123");
        assertFalse(baseballNumbers.hasDuplicateNumber());
    }

    @Test
    @DisplayName("중복된 숫자가 있는 문자열 테스트")
    public void hasDuplicateNumberTest() {
        assertThatIllegalArgumentException().isThrownBy(() -> new BaseballNumbers("122"))
                .withMessage(BaseballNumbers.DUPLICATE_NUMBER_MESSAGE);
    }
}
