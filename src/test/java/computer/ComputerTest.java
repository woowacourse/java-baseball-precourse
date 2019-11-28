package computer;

import baseball.generator.BallGenerator;
import baseball.generator.ManualBallGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class ComputerTest {

    @DisplayName("새로운 게임 생성")
    @Test
    void newGame() {
        BallGenerator ballGenerator = new ManualBallGenerator();

        assertThat(Computer.newGame(ballGenerator)).isEqualTo(new Computer(Arrays.asList(1, 2, 3)));
    }
}