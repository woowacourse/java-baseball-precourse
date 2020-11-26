package baseball.game;

import baseball.domain.BaseballType;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BaseballResultTest {
    private static final int MAX_BASEBALL_SIZE = 3;
    private static final int ZERO = 0;

    @Test
    void isNothingTest() {
        // given
        BaseballResult baseballResult = new BaseballResult(MAX_BASEBALL_SIZE);

        // when
        int ballCount = baseballResult.getBaseballTypeFrequency(BaseballType.BALL);
        int strikeCount = baseballResult.getBaseballTypeFrequency(BaseballType.STRIKE);

        // then
        assertThat(ballCount == ZERO && strikeCount == ZERO).isTrue();
        assertThat(baseballResult.isNothing()).isTrue();
    }

    @Test
    void isAllStrikeTest() {
        // given
        BaseballResult baseballResult = new BaseballResult(MAX_BASEBALL_SIZE);
        for (int index = 0; index < MAX_BASEBALL_SIZE; index += 1) {
            baseballResult.addBaseballTypeFrequency(BaseballType.STRIKE);
        }

        // when
        int ballCount = baseballResult.getBaseballTypeFrequency(BaseballType.BALL);
        int strikeCount = baseballResult.getBaseballTypeFrequency(BaseballType.STRIKE);

        // then
        assertThat(ballCount == ZERO && strikeCount == MAX_BASEBALL_SIZE).isTrue();
        assertThat(baseballResult.isAllStrike()).isTrue();
    }

    @Test
    void addBaseballTypeFrequency() {
        // given
        BaseballResult baseballResult = new BaseballResult(MAX_BASEBALL_SIZE);
        int increaseNumber = 1;

        // when
        int beforeBallCount = baseballResult.getBaseballTypeFrequency(BaseballType.BALL);
        baseballResult.addBaseballTypeFrequency(BaseballType.BALL);
        int nextBallCount = baseballResult.getBaseballTypeFrequency(BaseballType.BALL);

        // then
        assertThat((beforeBallCount + increaseNumber) == nextBallCount).isTrue();
    }
}