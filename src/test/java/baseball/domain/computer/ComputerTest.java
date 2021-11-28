package baseball.domain.computer;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.domain.number.BaseBallNumbers;
import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
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
}