package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BaseballNumberTest {

    @DisplayName("BaseballNumber 객체를 생성하는 기능을 테스트한다 ")
    @ParameterizedTest()
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9})
    void testInitBaseballNumber(int baseballNumberValue) {
        //when
        BaseballNumber baseballNumber = new BaseballNumber(baseballNumberValue);

        //then
        assertThat(baseballNumber).extracting("baseballNumber").isEqualTo(baseballNumberValue);
    }

    @DisplayName("BaseballNumber 객체가 정해진 범위내의 숫자가 아니라면 예외를 발생시킨다 ")
    @ParameterizedTest()
    @ValueSource(ints = {0, 10})
    void testInitBaseballNumberIfBaseballNumberValueIsNotSatisfiedValidationRange(int baseballNumberValue) {
        //when //then
        assertThatThrownBy(() -> new BaseballNumber(baseballNumberValue))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }
}
