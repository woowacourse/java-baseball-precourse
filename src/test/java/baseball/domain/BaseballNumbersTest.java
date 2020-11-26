package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BaseballNumbersTest {

    @DisplayName("BaseballNumbers 일급객체를 생성하는 기능을 테스트한다 ")
    @Test
    void testInitBaseballNumbers() {
        //given
        List<BaseballNumber> baseballNumbersValue = Arrays.asList(1, 2, 3).stream()
                .map(BaseballNumber::new)
                .collect(Collectors.toList());

        //when
        BaseballNumbers baseballNumbers = new BaseballNumbers(baseballNumbersValue);

        //then
        assertThat(baseballNumbers).extracting("baseballNumbers")
                .usingRecursiveComparison()
                .isEqualTo(baseballNumbersValue);
    }

    @DisplayName("BaseballNumbers의 BaseballNumber가 중복되면 예외를 발생시킨다 ")
    @Test
    void testInitBaseballNumbersIfDuplicatedBaseballNumber() {
        //given
        List<BaseballNumber> baseballNumbersValue = Arrays.asList(1, 1, 2).stream()
                .map(BaseballNumber::new)
                .collect(Collectors.toList());

        //when //then
        assertThatThrownBy(() -> new BaseballNumbers(baseballNumbersValue))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("BaseballNumbers의 길이가 정해진 BaseballNumbers의 길이보다 짧으면 예외를 발생시킨다 ")
    @Test
    void testInitBaseballNumbersIfShorterThanBaseballNumbersLength() {
        //given
        List<BaseballNumber> baseballNumbersValue = Arrays.asList(1, 2).stream()
                .map(BaseballNumber::new)
                .collect(Collectors.toList());

        //when //then
        assertThatThrownBy(() -> new BaseballNumbers(baseballNumbersValue))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("BaseballNumbers의 길이가 정해진 BaseballNumbers의 길이보다 길면 예외를 발생시킨다 ")
    @Test
    void testInitBaseballNumbersIfLongerThanBaseballNumbersLength() {
        //given
        List<BaseballNumber> baseballNumbersValue = Arrays.asList(1, 2).stream()
                .map(BaseballNumber::new)
                .collect(Collectors.toList());

        //when //then
        assertThatThrownBy(() -> new BaseballNumbers(baseballNumbersValue))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("정답 BaseballNumbers를 생성하는 기능을 테스트한다 ")
    @Test
    void testCreateAnswerBaseballNumbers() {
        //given
        List<BaseballNumber> baseballNumbersValue = Arrays.asList(1, 2, 3).stream()
                .map(BaseballNumber::new)
                .collect(Collectors.toList());

        //when
        BaseballNumbers baseballNumbers = BaseballNumbers.createAnswerBaseballNumbers(() -> baseballNumbersValue);

        //then
        assertThat(baseballNumbers).extracting("baseballNumbers")
                .usingRecursiveComparison()
                .isEqualTo(baseballNumbersValue);
    }
}
