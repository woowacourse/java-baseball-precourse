package computer;

import baseball.BaseBalls;
import baseball.generator.BallGenerator;
import baseball.generator.ManualBallGenerator;
import computer.result.Result;
import computer.result.Results;
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

    @DisplayName("결과 리스트 가져오기")
    @Test
    void getResults() {
        //manual 은 1,2,3 을 생성
        Computer computer = Computer.newGame(new ManualBallGenerator());

        BaseBalls compares = new BaseBalls(Arrays.asList(1, 3, 4));

        assertThat(computer.getResults(compares)).isEqualTo(new Results(Arrays.asList(Result.STRIKE, Result.BALL, Result.NOTHING)));
    }
}