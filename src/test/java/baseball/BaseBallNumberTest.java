package baseball;

import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class BaseBallNumberTest {

    @DisplayName("번호 생성")
    @ParameterizedTest
    @CsvSource(value = {"1", "9"})
    void test1(int number) {
        BaseBallNumber baseBallNumber = new BaseBallNumber(number);

        AssertionsForClassTypes.assertThat(baseBallNumber).isEqualTo(new BaseBallNumber(number));
    }

    @DisplayName("번호 생성시 유효성 체크")
    @ParameterizedTest
    @CsvSource(value = {"0", "10"})
    void test2(int number) {
        assertThatThrownBy(() -> new BaseBallNumber(number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(number + "는 올바르지 않은 숫자입니다.");
    }
}
