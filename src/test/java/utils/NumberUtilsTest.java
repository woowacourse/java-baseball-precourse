package utils;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author yhh1056
 * @since 2020/11/27
 */
class NumberUtilsTest {

    @Test
    @DisplayName("숫자가 맞는지 검증")
    void isNumeric() {
        String number1 = "123";
        String number2 = "12345";
        String number3 = "-123";

        assertTrue(NumberUtils.isNumeric(number1));
        assertTrue(NumberUtils.isNumeric(number2));
        assertTrue(NumberUtils.isNumeric(number3));
    }

    @Test
    @DisplayName("유효하지 않은 값을 입력한 경우")
    void isInvalidNumeric() {
        String notNumber = "일이삼";
        String notInteger = "1111111111111111";

        assertThrows(IllegalArgumentException.class,
            () -> NumberUtils.isNumeric(notNumber));
        assertThrows(IllegalArgumentException.class,
            () -> NumberUtils.isNumeric(notInteger));
    }
}
