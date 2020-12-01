package baseball.domain.number;

import baseball.domain.exception.BaseballNumberCountsException;
import baseball.domain.exception.BaseballNumberRangeException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BaseballNumbersTest {
    private static Stream<Arguments> getCorrectInputBaseballNumbers() {
        return Stream.of(Arguments.of(Arrays.asList(1, 2, 3)),
                Arguments.of(Arrays.asList(3, 6, 9)),
                Arguments.of(Arrays.asList(6, 7, 3)));
    }

    private static Stream<Arguments> getDuplicatedInputBaseballNumbers() {
        return Stream.of(Arguments.of(Arrays.asList(1, 2, 1)),
                Arguments.of(Arrays.asList(2, 2, 2)));
    }

    private static Stream<Arguments> getOutOfRangeInputBaseballNumbers() {
        return Stream.of(Arguments.of(Arrays.asList(1, 2, 0)),
                Arguments.of(Arrays.asList(3, 6, 10)),
                Arguments.of(Arrays.asList(-1, 7, 3)));
    }

    private static Stream<Arguments> getBaseballNumbersForStrike() {
        return Stream.of(Arguments.of(Arrays.asList(1, 2, 3), Arrays.asList(1, 2, 3), 3),
                Arguments.of(Arrays.asList(3, 7, 9), Arrays.asList(1, 2, 3), 0),
                Arguments.of(Arrays.asList(9, 1, 6), Arrays.asList(3, 7, 6), 1));
    }

    private static Stream<Arguments> getBaseballNumbersForBall() {
        return Stream.of(Arguments.of(Arrays.asList(3, 7, 6), Arrays.asList(3, 6, 7), 2),
                Arguments.of(Arrays.asList(1, 5, 3), Arrays.asList(3, 1, 5), 3),
                Arguments.of(Arrays.asList(9, 8, 7), Arrays.asList(9, 8, 7), 0));
    }

    @DisplayName("BaseballNumbers를 자동 생성하면, 중복되지 않은 3개의 랜덤 숫자가 뽑힘")
    @Test
    public void BaseballNumbers_자동_생성_중복_없는_랜덤_3개_숫자_반환() {
        BaseballNumbers baseballNumbers = BaseballNumbers.generateRandomBaseballNumbers();
        int strikeCounts = baseballNumbers.calculateStrikeCounts(baseballNumbers);
        assertThat(strikeCounts).isEqualTo(3);
    }

    @DisplayName("BaseballNumbers를 입력 숫자들을 통해 정상적으로 수동 생성")
    @ParameterizedTest
    @MethodSource("getCorrectInputBaseballNumbers")
    public void BaseballNumbers_수동_생성(List<Integer> inputBaseballNumbers) {
        BaseballNumbers baseballNumbers = BaseballNumbers.generateInputBaseballNumbers(inputBaseballNumbers);
        BaseballNumbers sameBaseballNumbers = BaseballNumbers.generateInputBaseballNumbers(inputBaseballNumbers);
        int strikeCounts = baseballNumbers.calculateStrikeCounts(sameBaseballNumbers);
        assertThat(strikeCounts).isEqualTo(3);
    }

    @DisplayName("입력 숫자들에 중복이 존재하면, BaseballNumbers 생성 실패")
    @ParameterizedTest
    @MethodSource("getDuplicatedInputBaseballNumbers")
    public void BaseballNumbers_숫자가_중복_있으면_예외_발생(List<Integer> inputBaseballNumbers) {
        assertThatThrownBy(() -> {
            BaseballNumbers.generateInputBaseballNumbers(inputBaseballNumbers);
        }).isInstanceOf(BaseballNumberCountsException.class);
    }

    @DisplayName("입력 숫자들에 1~9 범위가 아닌 숫자가 존재하면, BaseballNumbers 생성 실패")
    @ParameterizedTest
    @MethodSource("getOutOfRangeInputBaseballNumbers")
    public void BaseballNumbers_잘못된_범위_숫자_예외_발생(List<Integer> inputBaseballNumbers) {
        assertThatThrownBy(() -> {
            BaseballNumbers.generateInputBaseballNumbers(inputBaseballNumbers);
        }).isInstanceOf(BaseballNumberRangeException.class);
    }

    @DisplayName("두 개의 BaseballNumbers를 비교하고, 스트라이크 개수를 정상 계산")
    @ParameterizedTest
    @MethodSource("getBaseballNumbersForStrike")
    public void 스트라이크_개수_파악(List<Integer> firstNumbers, List<Integer> secondNumbers, int strikeCounts) {
        BaseballNumbers firstBaseballNumbers = BaseballNumbers.generateInputBaseballNumbers(firstNumbers);
        BaseballNumbers secondBaseballNumbers = BaseballNumbers.generateInputBaseballNumbers(secondNumbers);
        int testStrikeCounts = firstBaseballNumbers.calculateStrikeCounts(secondBaseballNumbers);
        assertThat(testStrikeCounts).isEqualTo(strikeCounts);
    }

    @DisplayName("두 개의 BaseballNumbers를 비교하고, 볼 개수를 정상 계산")
    @ParameterizedTest
    @MethodSource("getBaseballNumbersForBall")
    public void 볼_개수_파악(List<Integer> firstNumbers, List<Integer> secondNumbers, int ballCounts) {
        BaseballNumbers firstBaseballNumbers = BaseballNumbers.generateInputBaseballNumbers(firstNumbers);
        BaseballNumbers secondBaseballNumbers = BaseballNumbers.generateInputBaseballNumbers(secondNumbers);
        int testBallCounts = firstBaseballNumbers.calculateBallCounts(secondBaseballNumbers);
        assertThat(testBallCounts).isEqualTo(ballCounts);
    }
}
