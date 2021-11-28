package baseball.domain.number;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class BaseBallNumbersTest {

    private BaseBallNumbers answerNumbers;

    @BeforeEach
    void beforeEach() {
        answerNumbers = BaseBallNumbers.createByIntegerNumbers(Arrays.asList(1, 2, 3));
    }

    @Test
    @DisplayName("4개 이상의 수가 입력될 경우 Exception이 발생해야 한다.")
    void createExceptionByOutOfInputSize() {
        // given
        List<Integer> input = Arrays.asList(1, 2, 3, 4);

        // when & then
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> BaseBallNumbers.createByIntegerNumbers(input))
            .withMessageMatching("3개 이상의 공이 입력될 수 없습니다.");
    }

    @Test
    @DisplayName("중복된 수가 입력될 경우 Exception이 발생해야 한다.")
    void createExceptionByDuplicatedNumbers() {
        // given
        List<Integer> input = Arrays.asList(1, 1, 2);

        // when & then
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> BaseBallNumbers.createByIntegerNumbers(input))
            .withMessageMatching("중복된 공이 입력될 수 없습니다.");
    }

    @Nested
    @DisplayName("[Strike 단일 계산 테스트]")
    class CaculateStrikeTest {

        @Test
        @DisplayName("스트라이크 수가 1개이면 스트라이크 수를 1개 반환할 수 있다.")
        void caculateOneStrike() {
            // given
            BaseBallNumbers input = BaseBallNumbers.createByIntegerNumbers(Arrays.asList(1, 4, 5));
            int expected = 1;

            // when
            int result = answerNumbers.calculateStrikeCounts(input);

            // then
            assertThat(result).isEqualTo(expected);
        }

        @Test
        @DisplayName("스트라이크 수가 2개이면 스트라이크 수를 2개 반환할 수 있다.")
        void calculateTwoStrike() {
            // given
            BaseBallNumbers input = BaseBallNumbers.createByIntegerNumbers(Arrays.asList(1, 2, 5));
            int expected = 2;

            // when
            int result = answerNumbers.calculateStrikeCounts(input);

            // then
            assertThat(result).isEqualTo(expected);
        }

        @Test
        @DisplayName("스트라이크 수가 3개이면 스트라이크 수를 3개 반환할 수 있다.")
        void calculateThreeStrike() {
            // given
            BaseBallNumbers input = BaseBallNumbers.createByIntegerNumbers(Arrays.asList(1, 2, 3));
            int expected = 3;

            // when
            int result = answerNumbers.calculateStrikeCounts(input);

            // then
            assertThat(result).isEqualTo(expected);
        }
    }

    @Nested
    @DisplayName("[Ball 단일 계산 테스트]")
    class CaculateBallTest {

        @Test
        @DisplayName("볼 수가 1개이면 볼 수를 1개 반환할 수 있다.")
        void caculateOneBall() {
            // given
            BaseBallNumbers input = BaseBallNumbers.createByIntegerNumbers(Arrays.asList(3, 4, 5));
            int expected = 1;

            // when
            int result = answerNumbers.calculateBallCounts(input);

            // then
            assertThat(result).isEqualTo(expected);
        }

        @Test
        @DisplayName("볼 수가 2개이면 볼 수를 2개 반환할 수 있다.")
        void calculateTwoBall() {
            // given
            BaseBallNumbers input = BaseBallNumbers.createByIntegerNumbers(Arrays.asList(2, 3, 4));
            int expected = 2;

            // when
            int result = answerNumbers.calculateBallCounts(input);

            // then
            assertThat(result).isEqualTo(expected);
        }

        @Test
        @DisplayName("볼 수가 3개이면 볼 수를 3개 반환할 수 있다.")
        void calculateThreeBall() {
            // given
            BaseBallNumbers input = BaseBallNumbers.createByIntegerNumbers(Arrays.asList(3, 1, 2));
            int expected = 3;

            // when
            int result = answerNumbers.calculateBallCounts(input);

            // then
            assertThat(result).isEqualTo(expected);
        }
    }
}