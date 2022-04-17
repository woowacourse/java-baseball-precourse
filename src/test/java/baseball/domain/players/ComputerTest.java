package baseball.domain.players;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class ComputerTest {

    private Computer computer;

    @BeforeEach
    void setUp() {

        //given // when
        computer = new Computer();
        computer.computerNumberSetup();
    }

    @Test
    @DisplayName("컴퓨터의_숫자는_3자리이다")
    void 컴퓨터의_숫자는_3자리이다() {

        // then
        assertThat(computer.getComputerNumbers().size()).isEqualTo(3);
    }

    @DisplayName("컴퓨터의_숫자는_모두 양수다")
    @ParameterizedTest
    @ValueSource(ints = {0 ,1, 2})
    void 컴퓨터의_숫자는_모두_양수다(int input) {

        // then
        assertThat(computer.getComputerNumbers().get(input)).isPositive();
    }
}