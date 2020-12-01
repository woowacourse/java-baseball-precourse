package baseball.domain.game;

import baseball.domain.number.BaseballNumbers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

class BaseballGameMachineTest {

    private BaseballNumbers userBaseballNumbers;

    @BeforeEach
    public void setup() {
        userBaseballNumbers = BaseballNumbers.generateInputBaseballNumbers(Arrays.asList(1, 2, 3));
    }

    @DisplayName("게임을 플레이하면 결과를 반환함 : 3스트라이크")
    @Test
    public void calculateGameResult_3스트라이크_결과_반환() {
        BaseballGameMachine baseballGameMachine = new BaseballGameMachine(userBaseballNumbers);
        GameResult gameResult = baseballGameMachine.calculateGameResult(userBaseballNumbers);
        assertThat(gameResult.isEndOfGame()).isTrue();
        assertThat(gameResult.isOnlyStrike()).isTrue();
    }

    @DisplayName("게임을 플레이하면 결과를 반환함 : 낫싱")
    @Test
    public void calculateGameResult_낫싱_결과_반환() {
        BaseballGameMachine baseballGameMachine = new BaseballGameMachine(
                BaseballNumbers.generateInputBaseballNumbers(Arrays.asList(4, 5, 6)));
        GameResult gameResult = baseballGameMachine.calculateGameResult(userBaseballNumbers);
        assertThat(gameResult.isNothing()).isTrue();
    }

    @DisplayName("게임을 플레이하면 결과를 반환함 : 3볼")
    @Test
    public void calculateGameResult_3볼_결과_반환() {
        BaseballGameMachine baseballGameMachine = new BaseballGameMachine(
                BaseballNumbers.generateInputBaseballNumbers(Arrays.asList(2, 3, 1)));
        GameResult gameResult = baseballGameMachine.calculateGameResult(userBaseballNumbers);
        assertThat(gameResult.isOnlyBall()).isTrue();
        assertThat(gameResult.getBallCounts()).isEqualTo(3);
    }

    @DisplayName("게임을 플레이하면 결과를 반환함 : 2볼 1스트라이크")
    @Test
    public void calculateGameResult_2볼_1스트라이크_결과_반환() {
        BaseballGameMachine baseballGameMachine = new BaseballGameMachine(
                BaseballNumbers.generateInputBaseballNumbers(Arrays.asList(1, 3, 2)));
        GameResult gameResult = baseballGameMachine.calculateGameResult(userBaseballNumbers);
        assertThat(gameResult.getBallCounts()).isEqualTo(2);
        assertThat(gameResult.getStrikeCounts()).isEqualTo(1);
    }

    @DisplayName("GameState가 KEEP_GOING이면 다음 시도 때, 동일한 Machine 객체를 반환")
    @Test
    public void prepareNextTry_KEEP_GOING_동일_객체_반환() {
        BaseballGameMachine baseballGameMachine =
                new BaseballGameMachine(BaseballNumbers.generateRandomBaseballNumbers());
        BaseballGameMachine nextBaseballGameMachine = baseballGameMachine.prepareNextTry(GameState.KEEP_PLAYING);
        assertThat(baseballGameMachine.equals(nextBaseballGameMachine)).isTrue();
    }

    @DisplayName("GameState가 RESTART면 다음 시도 때, 새로운 랜덤 숫자로 구성된 객체를 새로 생성 반환")
    @Test
    public void prepareNextTry_RESTART_새로운_객체_반환() {
        BaseballGameMachine baseballGameMachine =
                new BaseballGameMachine(BaseballNumbers.generateRandomBaseballNumbers());
        BaseballGameMachine nextBaseballGameMachine = baseballGameMachine.prepareNextTry(GameState.RESTART);
        assertThat(baseballGameMachine.equals(nextBaseballGameMachine)).isFalse();
    }

    @DisplayName("GameState가 EXIT면 다음 시도 때 예외 발생")
    @Test
    public void prepareNextTry_EXIT_예외_발생() {
        BaseballGameMachine baseballGameMachine =
                new BaseballGameMachine(BaseballNumbers.generateRandomBaseballNumbers());
        assertThatCode(() -> {
            baseballGameMachine.prepareNextTry(GameState.EXIT);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
