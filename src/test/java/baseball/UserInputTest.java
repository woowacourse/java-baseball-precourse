package baseball;

import static org.junit.jupiter.api.Assertions.assertThrows;

import baseball.utils.GameValidator;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UserInputTest {

    @DisplayName("문자입력 예외를 테스트한다.")
    @Test
    void digitValidationTest() {
        String testcase = "av1";
        assertThrows(
            IllegalArgumentException.class,
            () -> GameValidator.validateNumber(testcase)
        );
    }

    @DisplayName("입력값 길이 예외를 테스트한다.")
    @Test
    void lengthValidationTest() {
        List<Integer> testcase = Arrays.asList(1, 4, 2, 3);
        assertThrows(
            IllegalArgumentException.class,
            () -> GameValidator.validateSize(testcase)
        );
    }

    @DisplayName("숫자중 중복값이 있는지 테스트한다.")
    @Test
    void duplicateTest() {
        List<Integer> testcase = Arrays.asList(1, 1, 3);
        assertThrows(
            IllegalArgumentException.class,
            () -> GameValidator.validateDuplicate(testcase)
        );
    }

    @DisplayName("숫자가 모두 범위안에 있는지 테스트한다.")
    @Test
    void rangeTest() {
        List<Integer> testcase = Arrays.asList(0, 1, 10);
        assertThrows(
            IllegalArgumentException.class,
            () -> GameValidator.validateRange(testcase)
        );
    }
}
