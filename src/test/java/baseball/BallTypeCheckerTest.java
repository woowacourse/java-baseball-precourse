package baseball;

import domain.BaseBall;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BallTypeCheckerTest {
    private BaseballRepository baseballRepository;

    public BallTypeCheckerTest() {
        baseballRepository = new BaseballRepository();
    }

    @Test
    public void BallTypeCheckWith3Strikes() throws Exception {
        //given
        BaseBall randomBaseball = baseballRepository.createInputBaseBall(135);
        BaseBall inputBaseball = baseballRepository.createInputBaseBall(135);
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
        BaseBall randomBaseball = baseballRepository.createInputBaseBall(135);
        BaseBall inputBaseball = baseballRepository.createInputBaseBall(136);
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
        BaseBall randomBaseball = baseballRepository.createInputBaseBall(315);
        BaseBall inputBaseball = baseballRepository.createInputBaseBall(136);
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
        BaseBall randomBaseball = baseballRepository.createInputBaseBall(135);
        BaseBall inputBaseball = baseballRepository.createInputBaseBall(247);
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

        BaseBall randomBaseball = baseballRepository.createInputBaseBall(135);
        BaseBall answerBaseball = baseballRepository.createInputBaseBall(135);
        BaseBall twoStrikeBaseball = baseballRepository.createInputBaseBall(136);
        BaseBall twoBallOneStrikeBaseball = baseballRepository.createInputBaseBall(315);
        BaseBall nothingBaseball = baseballRepository.createInputBaseBall(247);
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