package baseball;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BaseballResultTest {
    @Test
    @DisplayName("3스트라이크 시 정답 처리 확인")
    public void checkAnswer() throws Exception{
        //given
        final int ANSWER_COUNT = 3;
        BaseballResult baseballResult = new BaseballResult();
        //when
        for (int i = 0; i < ANSWER_COUNT; i++) {
            baseballResult.accumulateBallType(BallType.STRIKE);
        }
        //then
        baseballResult.printResult();
        Assertions.assertTrue(baseballResult.isAnswer());
    }

    @Test
    @DisplayName("낫싱볼 확인")
    public void checkNothing() throws Exception{
        //given
        final int ZERO = 0;
        BaseballResult baseballResult = new BaseballResult();
        //when
        int ballCount = baseballResult.getCount(BallType.BALL);
        //then
        baseballResult.printResult();
        Assertions.assertEquals(ZERO, ballCount);
    }

    @Test
    @DisplayName("볼과 스트라이크가 섞여있을 때 확인")
    public void checkMixBallAndStrike() throws Exception{
        //given
        BaseballResult baseballResult = new BaseballResult();
        //when
        baseballResult.accumulateBallType(BallType.BALL);
        baseballResult.accumulateBallType(BallType.BALL);
        baseballResult.accumulateBallType(BallType.STRIKE);
        //then
        int ballCount = baseballResult.getCount(BallType.BALL);
        int strikeCount = baseballResult.getCount(BallType.STRIKE);
        baseballResult.printResult();
        Assertions.assertEquals(2,ballCount);
        Assertions.assertEquals(1,strikeCount);
    }
}