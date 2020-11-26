package domain.number;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class BaseballNumbersTest {

    private static Stream<Arguments> getInputBaseballNumbers() {
        return Stream.of(Arguments.of(Arrays.asList(1, 2, 3)),
                Arguments.of(Arrays.asList(3, 6, 9)),
                Arguments.of(Arrays.asList(6, 7, 3)));
    }

    @DisplayName("BaseballNumbers를 자동 생성하면, 중복되지 않은 3개의 랜덤 숫자가 뽑힘")
    @Test
    public void BaseballNumbers_자동_생성_중복_없는_랜덤_3개_숫자_반환() {
        BaseballNumbers baseballNumbers = BaseballNumbers.generateRandomBaseballNumbers();
        int distinctNumberCounts = (int) baseballNumbers.getBaseballNumbers()
                .stream()
                .distinct()
                .count();

        assertThat(distinctNumberCounts).isEqualTo(3);
    }

    @DisplayName("BaseballNumbers를 입력 문자열을 통해 정상적으로 수동 생성함")
    @ParameterizedTest
    @MethodSource("getInputBaseballNumbers")
    public void BaseballNumbers_수동_생성(List<Integer> inputBaseballNumbers) {
        BaseballNumbers baseballNumbers = BaseballNumbers.generateInputBaseballNumbers(inputBaseballNumbers);
        List<Integer> generatedBaseballNumbers = baseballNumbers.getBaseballNumbers();
        assertThat(generatedBaseballNumbers).hasSameElementsAs(inputBaseballNumbers);
    }
}
