package baseball.domain.judge;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import baseball.domain.judge.exception.JudgeMultipleJudgementException;
import baseball.domain.judge.judgeRule.JudgeRuleFactory;
import baseball.domain.judge.judgeRule.NothingJudgeRule;
import baseball.domain.judge.judgeRule.StrikeJudgeRule;
import baseball.domain.pitching.Pitchings;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

@DisplayName("판정기에 대한 테스트")
class JudgeTest {

    @Mock
    private Judge judge;

    @BeforeEach
    void setUp() {
        judge = Judge.of(JudgeRuleFactory.getAll());
    }

    @DisplayName("특정 위치에 있는 투구의 스트라이크를 판정할 수 있다.")
    @Test
    void judgeStrike() {
        final Pitchings base = Pitchings.of("123");
        final Pitchings target = Pitchings.of("123");

        for (int i = 0; i < Pitchings.SIZE; i++) {
            final Judgement judgement = judge.judgeOne(base, target, i);

            assertEquals(judgement, Judgement.STRIKE);
        }
    }

    @DisplayName("특정 위치에 있는 투구의 볼을 판정할 수 있다.")
    @Test
    void judgeBall() {
        final Pitchings base = Pitchings.of("123");
        final Pitchings target = Pitchings.of("312");

        for (int i = 0; i < Pitchings.SIZE; i++) {
            final Judgement judgement = judge.judgeOne(base, target, i);

            assertEquals(judgement, Judgement.BALL);
        }
    }

    @DisplayName("특정 위치에 있는 투구의 낫싱을 판정할 수 있다.")
    @Test
    void judgeNothing() {
        final Pitchings base = Pitchings.of("123");
        final Pitchings target = Pitchings.of("456");

        for (int i = 0; i < Pitchings.SIZE; i++) {
            final Judgement judgement = judge.judgeOne(base, target, i);

            assertEquals(judgement, Judgement.NOTHING);
        }
    }

    @DisplayName("특정 위치에 있는 투구의 판정은 " + Judge.JUDGEMENT_BOUNDARY + "개가 아니면 안된다.")
    @Test
    void judgeMultipleJudgement() {
        judge = Judge.of(StrikeJudgeRule.getInstance(), StrikeJudgeRule.getInstance(), NothingJudgeRule
            .getInstance());
        final Pitchings base = Pitchings.of("123");
        final Pitchings target = Pitchings.of("123");

        assertThrows(JudgeMultipleJudgementException.class, () -> judge.judgeOne(base, target, 0));
    }
}