package baseball.view;

import baseball.domain.constants.ConstantsMessages;
import baseball.domain.players.Computer;
import baseball.domain.rule.BaseBallRule;

import java.util.List;

public class OutputView {

    public void printCompareCountMessage(Computer computer, List<Integer> userNumbers, BaseBallRule baseBallRule) {
        baseBallRule.compareBall(computer.getComputerNumbers(), userNumbers);

        if (baseBallRule.getBallCount() == 0 && baseBallRule.getStrikeCount() == 0) {
            System.out.println(ConstantsMessages.BASEBALL_RESULT_NOTHING_MESSAGE);
        }

        if (!(baseBallRule.getBallCount() == 0 && baseBallRule.getStrikeCount() == 0)) {
            printThreeCorrectCount(baseBallRule.getBallCount(), baseBallRule.getStrikeCount());
        }
    }

    private void printThreeCorrectCount(int ballCount, int strikeCount) {
        if(ballCount == 3) {
            System.out.println(ConstantsMessages.BASEBALL_3BALL_MESSAGE);
        }

        if(strikeCount == 3) {
            System.out.println(ConstantsMessages.BASEBALL_3STRIKE_MESSAGE);
        }

        if(!(ballCount == 3 || strikeCount == 3)) {
            System.out.println(String.format(ConstantsMessages.BASEBALL_RESULT_MESSAGE, ballCount, strikeCount));
        }
    }

    public void printFinishMessageAndAnswerReplay() {
        System.out.println(ConstantsMessages.FINISH_MESSAGE);
        System.out.println(ConstantsMessages.ANSWER_REPLAY);
    }
}
