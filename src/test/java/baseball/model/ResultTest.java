package baseball.model;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;
import static org.junit.jupiter.api.Assertions.*;

@SuppressWarnings("NonAsciiCharacters")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class ResultTest {

    @Test
    void 게임이_끝났는지_확인한다() {
        // given
        Result notOver = new Result(0, 0);
        Result over = new Result(3, 0);

        // when, then
        assertSoftly(softly -> {
            assertFalse(notOver.isGameOver());
            assertTrue(over.isGameOver());
        });
    }

    @Test
    void 스트라이크만_있는지_확인한다() {
        // given
        Result notOnlyStrike = new Result(1, 1);
        Result onlyStrike = new Result(2, 0);

        // when, then
        assertSoftly(softly -> {
            assertFalse(notOnlyStrike.hasOnlyStrike());
            assertTrue(onlyStrike.hasOnlyStrike());
        });
    }

    @Test
    void 볼만_있는지_확인한다() {
        // given
        Result notOnlyBall = new Result(1, 1);
        Result onlyBall = new Result(0, 2);

        // when, then
        assertSoftly(softly -> {
            assertFalse(notOnlyBall.hasOnlyBall());
            assertTrue(onlyBall.hasOnlyBall());
        });
    }

    @Test
    void 스트라이크와_볼_둘_다_없는지_확인한다() {
        // given
        Result withCounts = new Result(1, 1);
        Result noCounts = new Result(0, 0);

        // when, then
        assertSoftly(softly -> {
            assertFalse(withCounts.hasNoCounts());
            assertTrue(noCounts.hasNoCounts());
        });
    }

    @Test
    void 볼_카운트를_가져온다() {
        // given
        Result result = new Result(2, 1);

        // when, then
        assertThat(result.fetchBallCount()).isEqualTo(1);
    }

    @Test
    void 스트라이크_카운트를_가져온다() {
        // given
        Result result = new Result(2, 1);

        // when, then
        assertThat(result.fetchStrikeCount()).isEqualTo(2);
    }
}