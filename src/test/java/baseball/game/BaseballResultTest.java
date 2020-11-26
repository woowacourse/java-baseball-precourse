package baseball.game;

import baseball.domain.BaseballType;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BaseballResultTest {
    final int maxBaseballSize = 3;
    final int zero = 0;

    @Test
    void isNothingTest() {
        // given
        BaseballResult baseballResult = new BaseballResult(maxBaseballSize);

        // when
        int ballCount = baseballResult.getBaseballTypeFrequency(BaseballType.BALL);
        int strikeCount = baseballResult.getBaseballTypeFrequency(BaseballType.STRIKE);

        // then
        assertThat(ballCount == zero && strikeCount == zero).isTrue();
        assertThat(baseballResult.isNothing()).isTrue();
    }

    @Test
    void isAllStrikeTest() {
        // given
        BaseballResult baseballResult = new BaseballResult(maxBaseballSize);
        for (int index = 0; index < maxBaseballSize; index += 1) {
            baseballResult.addBaseballTypeFrequency(BaseballType.STRIKE);
        }

        // when
        int ballCount = baseballResult.getBaseballTypeFrequency(BaseballType.BALL);
        int strikeCount = baseballResult.getBaseballTypeFrequency(BaseballType.STRIKE);

        // then
        assertThat(ballCount == zero && strikeCount == maxBaseballSize).isTrue();
        assertThat(baseballResult.isAllStrike()).isTrue();
    }

    @Test
    void addBaseballTypeFrequency() {
        // given
        BaseballResult baseballResult = new BaseballResult(maxBaseballSize);
        int increaseNumber = 1;

        // when
        int beforeBallCount = baseballResult.getBaseballTypeFrequency(BaseballType.BALL);
        baseballResult.addBaseballTypeFrequency(BaseballType.BALL);
        int nextBallCount = baseballResult.getBaseballTypeFrequency(BaseballType.BALL);

        // then
        assertThat((beforeBallCount + increaseNumber) == nextBallCount).isTrue();
    }
}