package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
        BaseballNumbers baseballNumbers = new BaseballNumbers("122");
        assertTrue(baseballNumbers.hasDuplicateNumber());
    }
}
