package baseball;

import domain.BaseBall;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BallTypeCheckerTest {
    @Test
    public void BallTypeCheckWith3Strikes() throws Exception {
        //given
        BaseBall randomBaseball = BaseBall.createBaseBall(135);
        BaseBall inputBaseball = BaseBall.createBaseBall(135);
        //when
        BallTypeChecker ballTypeChecker = BallTypeChecker.ballTypeCheckWith(randomBaseball);
        BaseballResult baseballResult = ballTypeChecker.startChecking(inputBaseball);
        //then
        assertTrue(baseballResult.isAnswer());
    }

    @Test
    public void BallTypeCheckWith2Strikes0Ball() throws Exception {
        //given
        final String RESULT = "2스트라이크";
        BaseBall randomBaseball = BaseBall.createBaseBall(135);
        BaseBall inputBaseball = BaseBall.createBaseBall(136);
        //when
        BallTypeChecker ballTypeChecker = BallTypeChecker.ballTypeCheckWith(randomBaseball);
        BaseballResult baseballResult = ballTypeChecker.startChecking(inputBaseball);
        //then
        assertEquals(RESULT, baseballResult.getResult());
    }

    @Test
    public void BallTypeCheckWith2Ball0Strike() throws Exception {
        //given
        final String RESULT = "2볼";
        BaseBall randomBaseball = BaseBall.createBaseBall(315);
        BaseBall inputBaseball = BaseBall.createBaseBall(136);
        //when
        BallTypeChecker ballTypeChecker = BallTypeChecker.ballTypeCheckWith(randomBaseball);
        BaseballResult baseballResult = ballTypeChecker.startChecking(inputBaseball);
        //then
        assertEquals(RESULT, baseballResult.getResult());
    }

    @Test
    public void BallTypeCheckWithNothing() throws Exception {
        //given
        final String RESULT = "낫싱";
        BaseBall randomBaseball = BaseBall.createBaseBall(135);
        BaseBall inputBaseball = BaseBall.createBaseBall(247);
        //when
        BallTypeChecker ballTypeChecker = BallTypeChecker.ballTypeCheckWith(randomBaseball);
        BaseballResult baseballResult = ballTypeChecker.startChecking(inputBaseball);
        //then
        assertEquals(RESULT, baseballResult.getResult());
    }

    @Test
    public void BallTypeCheckWithMultipleInputNumber() throws Exception {
        //given
        final String RESULT1 = "3스트라이크";
        final String RESULT2 = "2스트라이크";
        final String RESULT3 = "2볼 1스트라이크";
        final String RESULT4 = "낫싱";

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
        assertEquals(RESULT1, answerResult.getResult());
        assertEquals(RESULT2, twoStrikeResult.getResult());
        assertEquals(RESULT3, twoBallOneStrikeResult.getResult());
        assertEquals(RESULT4, nothingResult.getResult());
    }

}