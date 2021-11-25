package baseball.domain;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BaseballNumbersTest {

    @DisplayName("BaseballNumbers 생성 시 서로 다른 임의의 수 3개가 뽑힌다.")
    @Test
    void generateBaseballNumbers() {
        // given
        BaseballNumbers baseballNumbers = new BaseballNumbers();

        // when
        long numbersSize = baseballNumbers.getNumbers()
            .stream()
            .distinct()
            .count();

        // then
        assertThat(numbersSize).isEqualTo(3);
    }

    @DisplayName("getNumber()로 반환하는 list를 수정하면 UnsupportedOperationException을 던진다.")
    @Test
    void modifyBaseballNumbersThrowUnsupportedOperationException() {
        // given
        BaseballNumbers baseballNumbers = new BaseballNumbers();

        // when
        List<Integer> numbers = baseballNumbers.getNumbers();

        // then
        assertThatThrownBy(() -> numbers.add(1, 5))
            .isInstanceOf(UnsupportedOperationException.class);
    }
}