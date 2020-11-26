package baseball;

import domain.BaseBall;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BallTypeCheckerTest {
    @Test
    public void BallTypeCheckWith3Strikes() throws Exception{
        //given
        BaseBall randomBaseball = BaseBall.createBaseBall(135);
        BaseBall inputBaseball = BaseBall.createBaseBall(135);
        //when
        BallTypeChecker ballTypeChecker = BallTypeChecker.ballTypeCheckWith(randomBaseball);
        BaseballResult baseballResult = ballTypeChecker.startChecking(inputBaseball);
        //then
        baseballResult.printResult();
        assertTrue(baseballResult.isAnswer());
    }

    @Test
    public void BallTypeCheckWith2Strikes0Ball() throws Exception{
        //given
        final int BALL_COUNT = 0;
        final int STRIKE_COUNT = 2;
        BaseBall randomBaseball = BaseBall.createBaseBall(135);
        BaseBall inputBaseball = BaseBall.createBaseBall(136);
        //when
        BallTypeChecker ballTypeChecker = BallTypeChecker.ballTypeCheckWith(randomBaseball);
        BaseballResult baseballResult = ballTypeChecker.startChecking(inputBaseball);
        //then
        int actualBallCount = baseballResult.countFor(BallType.BALL);
        int actualStrikeCount = baseballResult.countFor(BallType.STRIKE);
        baseballResult.printResult();
        assertEquals(BALL_COUNT, actualBallCount);
        assertEquals(STRIKE_COUNT, actualStrikeCount);
    }

    @Test
    public void BallTypeCheckWith2Ball0Strike() throws Exception{
        //given
        final int BALL_COUNT = 2;
        final int STRIKE_COUNT = 0;
        BaseBall randomBaseball = BaseBall.createBaseBall(315);
        BaseBall inputBaseball = BaseBall.createBaseBall(136);
        //when
        BallTypeChecker ballTypeChecker = BallTypeChecker.ballTypeCheckWith(randomBaseball);
        BaseballResult baseballResult = ballTypeChecker.startChecking(inputBaseball);
        //then
        int actualBallCount = baseballResult.countFor(BallType.BALL);
        int actualStrikeCount = baseballResult.countFor(BallType.STRIKE);
        baseballResult.printResult();
        assertEquals(BALL_COUNT, actualBallCount);
        assertEquals(STRIKE_COUNT, actualStrikeCount);
    }

    @Test
    public void BallTypeCheckWithNothing() throws Exception{
        //given
        final int ZERO = 0;
        BaseBall randomBaseball = BaseBall.createBaseBall(135);
        BaseBall inputBaseball = BaseBall.createBaseBall(247);
        //when
        BallTypeChecker ballTypeChecker = BallTypeChecker.ballTypeCheckWith(randomBaseball);
        BaseballResult baseballResult = ballTypeChecker.startChecking(inputBaseball);
        //then
        int actualBallCount = baseballResult.countFor(BallType.BALL);
        int actualStrikeCount = baseballResult.countFor(BallType.STRIKE);
        baseballResult.printResult();
        assertEquals(ZERO, actualBallCount);
        assertEquals(ZERO, actualStrikeCount);
    }

    @Test
    public void BallTypeCheckWithMultipleInputNumber() throws Exception{
        //given
        BaseBall randomBaseball = BaseBall.createBaseBall(135);
        BaseBall answerBaseball = BaseBall.createBaseBall(135);
        BaseBall twoStrikeBaseball = BaseBall.createBaseBall(136);
        BaseBall twoBallOneStrikeBaseball = BaseBall.createBaseBall(315);
        BaseBall nothingBaseball = BaseBall.createBaseBall(247);
        //when
        BallTypeChecker ballTypeChecker = BallTypeChecker.ballTypeCheckWith(randomBaseball);
        BaseballResult answerResult = ballTypeChecker.startChecking(answerBaseball);
        BaseballResult twoStrikeResult = ballTypeChecker.startChecking(twoStrikeBaseball);
        BaseballResult twoBallOneStrikeResult = ballTypeChecker.startChecking(twoBallOneStrikeBaseball);
        BaseballResult nothingResult = ballTypeChecker.startChecking(nothingBaseball);
        //then
        assertTrue(answerResult.isAnswer());
        assertEquals(2, twoStrikeResult.countFor(BallType.STRIKE));
        assertEquals(2, twoBallOneStrikeResult.countFor(BallType.BALL));
        assertEquals(1, twoBallOneStrikeResult.countFor(BallType.STRIKE));
        assertEquals(0, nothingResult.countFor(BallType.BALL));
        assertEquals(0, nothingResult.countFor(BallType.STRIKE));
    }

}