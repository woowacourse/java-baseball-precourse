package utils;

import baseball.util.Validator;
import jdk.jfr.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import static baseball.util.Validator.REQUIRE_NUMBER_COUNT;

class ValidatorTest {

    @ParameterizedTest
    @ValueSource(strings = {"123", "987", "574"})
    public void isValidLength(String input) {
        boolean result = input.length() == REQUIRE_NUMBER_COUNT;
        Assertions.assertTrue(result);
    }

    @ParameterizedTest
    @ValueSource(strings = {"120", "901", "001", "000", "320", "1111", "1234", "0126"})
    public void isValidLength_fail(String input) {
        boolean result = input.length() == REQUIRE_NUMBER_COUNT && !input.contains("0");
        Assertions.assertFalse(result);
    }

    @ParameterizedTest
    @ValueSource(strings = {"112", "110", "122", "221", "333", "999", "1234", "0126"})
    public void hasDuplicateTest_fail(String input) {

        //when
        int count = (int) Arrays.stream(input.split(""))
                .distinct()
                .count();
        int REQUEIR_COUNT = REQUIRE_NUMBER_COUNT;

        //then
        assertTrue(count != REQUEIR_COUNT);
    }

    @ParameterizedTest
    @ValueSource(strings = {"123", "345", "643", "865", "543", "875", "326", "127"})
    public void hasDuplicateTest(String input) {

        //when
        int count = (int) Arrays.stream(input.split(""))
                .distinct()
                .count();
        int REQUEIR_COUNT = REQUIRE_NUMBER_COUNT;

        //then
        assertTrue(count == REQUEIR_COUNT);
    }


    @ParameterizedTest
    @ValueSource(strings = {"123", "432", "652", "841", "937"})
    @Description("사용자 입력값에 대한 유효성 체크 테스트, fail()로 가면 실패")
    public void validateTest(String input) {

        try {
            Validator.validateInput(input);
        } catch (Exception e) {
            fail();
        }

    }

    @ParameterizedTest
    @ValueSource(strings = {"一二三", "怎么了", "1123", "4456", "0789", "12r", "r232", "11111", "123123"})
    @Description("사용자 입력값에 대한 유효성 체크 테스트,IllegalArgumentException 발생")
    public void validateTest_Faile(String input) {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Validator.validateInput(input);
        });
    }


    @ParameterizedTest
    @ValueSource(strings = {"-1", "3", "1000", "01", "r", "dfa", "测试"})
    @Description("validateReStart 예외발생 테스트")
    public void validateReStartTest(String input) {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Validator.validateRestart(input);
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "2"})
    @Description("validateReStart 발생x")
    public void validateReStartTest_success(String input) {

        Validator.validateRestart(input);

    }

}