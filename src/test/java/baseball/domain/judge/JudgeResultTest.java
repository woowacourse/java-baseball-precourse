package baseball.domain.judge;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

@DisplayName("판정 기록기에 대한 테스트")
class JudgeResultTest {

    private JudgeResult judgeResult;

    @BeforeEach
    void setUp() {
        judgeResult = JudgeResult.empty();
    }

    @DisplayName("특정 판정에 대한 카운트를 가져온다.")
    @ParameterizedTest
    @EnumSource(Judgement.class)
    void get(final Judgement judgement) {
        final int expect = 0;

        final int count = judgeResult.get(judgement);

        assertEquals(count, expect);
    }

    @DisplayName("특정 판정에 대한 카운트를 1개 증가시킨다.")
    @ParameterizedTest
    @EnumSource(Judgement.class)
    void increment(final Judgement judgement) {
        final int expect = 1;

        judgeResult.increment(judgement);

        assertEquals(judgeResult.get(judgement), expect);
    }

    @DisplayName("스트라이크가 3개면 게임은 완료 상태가 된다.")
    @Test
    void isComplete() {
        final boolean expect = true;

        for (int i = 0; i < 3; i++) {
            judgeResult.increment(Judgement.STRIKE);
        }

        assertEquals(judgeResult.isComplete(), expect);
    }

    @DisplayName("스트라이크가 3개가 아니면 게임은 완료 상태가 되지 않는다.")
    @Test
    void isNotComplete() {
        final boolean expect = false;

        for (int i = 0; i < 2; i++) {
            judgeResult.increment(Judgement.STRIKE);
        }
        judgeResult.increment(Judgement.BALL);

        assertEquals(judgeResult.isComplete(), expect);
    }

    @DisplayName("스트라이크 기록이 존재하는지 확인한다.")
    @Test
    void hasStrike() {
        final boolean expect = true;

        judgeResult.increment(Judgement.STRIKE);

        assertEquals(judgeResult.has(Judgement.STRIKE), expect);
    }

    @DisplayName("볼 기록이 존재하는지 확인한다.")
    @Test
    void hasBall() {
        final boolean expect = true;

        judgeResult.increment(Judgement.BALL);

        assertEquals(judgeResult.has(Judgement.BALL), expect);
    }

    @DisplayName("낫싱인지 확인한다.")
    @Test
    void hasNothing() {
        final boolean expect = true;

        for (int i = 0; i < 3; i++) {
            judgeResult.increment(Judgement.NOTHING);
        }

        assertEquals(judgeResult.isNothing(), expect);
    }
}