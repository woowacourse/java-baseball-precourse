package domain.game;

import domain.number.BaseballNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class BaseballGameMachineTest {

    @DisplayName("게임을 플레이하면 결과를 반환함 : 3스트라이크")
    @Test
    public void play_3스트라이크_결과_반환() {
        BaseballNumbers userBaseballNumbers = BaseballNumbers.generateInputBaseballNumbers(Arrays.asList(1, 2, 3));
        BaseballGameMachine baseballGameMachine = new BaseballGameMachine(userBaseballNumbers);
        GameResult gameResult = baseballGameMachine.play(userBaseballNumbers);
        assertThat(gameResult.isFullScore()).isTrue();
        assertThat(gameResult.isOnlyStrike()).isTrue();
    }

    @DisplayName("게임을 플레이하면 결과를 반환함 : 낫싱")
    @Test
    public void play_낫싱_결과_반환() {
        BaseballNumbers userBaseballNumbers = BaseballNumbers.generateInputBaseballNumbers(Arrays.asList(1, 2, 3));
        BaseballGameMachine baseballGameMachine = new BaseballGameMachine(
                BaseballNumbers.generateInputBaseballNumbers(Arrays.asList(4, 5, 6)));
        GameResult gameResult = baseballGameMachine.play(userBaseballNumbers);
        assertThat(gameResult.isNothing()).isTrue();
    }

    @DisplayName("게임을 플레이하면 결과를 반환함 : 3볼")
    @Test
    public void play_3볼_결과_반환() {
        BaseballNumbers userBaseballNumbers = BaseballNumbers.generateInputBaseballNumbers(Arrays.asList(1, 2, 3));
        BaseballGameMachine baseballGameMachine = new BaseballGameMachine(
                BaseballNumbers.generateInputBaseballNumbers(Arrays.asList(2, 3, 1)));
        GameResult gameResult = baseballGameMachine.play(userBaseballNumbers);
        assertThat(gameResult.isOnlyBall()).isTrue();
        assertThat(gameResult.getBallCounts()).isEqualTo(3);
    }

    @DisplayName("게임을 플레이하면 결과를 반환함 : 2볼 1스트라이크")
    @Test
    public void play_2볼_1스트라이크_결과_반환() {
        BaseballNumbers userBaseballNumbers = BaseballNumbers.generateInputBaseballNumbers(Arrays.asList(1, 2, 3));
        BaseballGameMachine baseballGameMachine = new BaseballGameMachine(
                BaseballNumbers.generateInputBaseballNumbers(Arrays.asList(1, 3, 2)));
        GameResult gameResult = baseballGameMachine.play(userBaseballNumbers);
        assertThat(gameResult.getBallCounts()).isEqualTo(2);
        assertThat(gameResult.getStrikeCounts()).isEqualTo(1);
    }
}
