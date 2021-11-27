package baseball.runner;

import baseball.domain.vo.JudgementResult;
import baseball.domain.vo.number.Number;

public class Referee {

    private JudgementResult judgementResult;

    public JudgementResult judge(Number playerNumber, Number otherPlayerNumber) {
        int ballCount = playerNumber.countBall(otherPlayerNumber);
        int strikeCount = playerNumber.countStrike(otherPlayerNumber);
        judgementResult = new JudgementResult(ballCount, strikeCount);
        return judgementResult;
    }

    public boolean isGameOver() {
        return judgementResult.isThreeStrike();
    }
}
