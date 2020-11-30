package baseball;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BaseballResultTest {
    @Test
    @DisplayName("3스트라이크 시 정답 처리 확인")
    public void checkAnswer() throws Exception {
        //given
        final int ANSWER_COUNT = 3;
        BaseballResult baseballResult = new BaseballResult();
        //when
        for (int i = 0; i < ANSWER_COUNT; i++) {
            baseballResult.accumulateBallType(BallType.STRIKE);
        }
        //then
        assertTrue(baseballResult.isAnswer());
    }

    @Test
    @DisplayName("낫싱볼 확인")
    public void checkNothing() throws Exception {
        //given
        final String NOTHING = "낫싱";
        //when
        BaseballResult baseballResult = new BaseballResult();
        //then
        assertEquals(NOTHING, baseballResult.getResult());
    }

    @Test
    @DisplayName("볼과 스트라이크가 섞여있을 때 확인")
    public void checkMixBallAndStrike() throws Exception {
        //given
        final int EXPECTED_BALL_COUNT = 2;
        final int EXPECTED_STRIKE_COUNT = 1;
        final String EXPECTED_RESULT = "2볼 1스트라이크";
        BaseballResult baseballResult = new BaseballResult();
        //when
        for (int i = 0; i < EXPECTED_BALL_COUNT; i++) {
            baseballResult.accumulateBallType(BallType.BALL);
        }
        for (int i = 0; i < EXPECTED_STRIKE_COUNT; i++) {
            baseballResult.accumulateBallType(BallType.STRIKE);
        }
        //then
        assertEquals(EXPECTED_RESULT, baseballResult.getResult());
    }
}