package baseball.domain.computer;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertAll;

import baseball.domain.number.BaseBallNumbers;
import baseball.exception.computer.ComputerEndStateRefreshException;
import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

class ComputerTest {

    @RepeatedTest(10)
    @DisplayName("3개의 answer numbers를 가진 초기 Computer를 생성할 수 있다.")
    void createWithAnswerNumbersByRandomGenerater() {
        // when
        Computer result = Computer.init();

        // then
        assertThat(result).isInstanceOf(Computer.class);
    }

    @Test
    @DisplayName("baseball game 결과를 반환할 수 있다.")
    void calculateBaseBallGameTest() {
        // given
        Computer computer = Computer.from(BaseBallNumbers.createByIntegerNumbers(Arrays.asList(1, 2, 3)), GameState.init());
        BaseBallNumbers inputNumbers = BaseBallNumbers.createByIntegerNumbers(Arrays.asList(3, 2, 1));
        GameResult expected = GameResult.from(1, 2);

        // when
        GameResult result = computer.calculateBaseBallGame(inputNumbers);

        // then
        assertThat(result).isEqualTo(expected);
    }

    @Nested
    @DisplayName("[Computer refresh 테스트]")
    class RefreshComputerTest {

        private BaseBallNumbers baseBallNumbers;

        @BeforeEach
        void beforeEach() {
            baseBallNumbers = BaseBallNumbers.createByIntegerNumbers(Arrays.asList(1, 2, 3));
        }

        @Test
        @DisplayName("이미 종료된 Computer가 Refresh할 경우 Exception이 발생해야 한다.")
        void refreshExceptionByEndState() {
            // given
            Computer computer = Computer.from(baseBallNumbers, GameState.END);

            // when & then
            assertThatExceptionOfType(ComputerEndStateRefreshException.class)
                .isThrownBy(() -> computer.refresh())
                .withMessageMatching("종료된 게임은 리프레시할 수 없습니다.");
        }

        @Test
        @DisplayName("Restart 상태라면 새로운 Computer를 반환해야 한다.")
        void refreshByRestartState() {
            // given
            Computer input = Computer.from(baseBallNumbers, GameState.RESTART);

            // when
            Computer result = input.refresh();

            // then
            assertAll(
                () -> assertThat(result).isInstanceOf(Computer.class),
                () -> assertThat(result).isNotEqualTo(input)
            );
        }

        @Test
        @DisplayName("RUNNING 상태라면 그대로 현재 주소를 반환해야 한다.")
        void refreshByRunningState() {
            // given
            Computer input = Computer.from(baseBallNumbers, GameState.RUNNING);

            // when
            Computer result = input.refresh();

            // then
            assertThat(result).isSameAs(input);
        }
    }
}