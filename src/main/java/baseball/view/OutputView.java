package baseball.view;

import baseball.domain.players.Computer;
import baseball.domain.rule.BaseBallCount;
import baseball.domain.rule.BaseBallRule;

import java.util.List;

public class OutputView {

    private static final String BASEBALL_RESULT_MESSAGE = "%d " + BaseBallCount.BALL.getName() + " %d " + BaseBallCount.STRIKE.getName();
    private static final String BASEBALL_RESULT_NOTHING_MESSAGE = "낫싱";

    public static final String FINISH_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 끝";

    public static final String ANSWER_REPLAY = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public void printCompareCountMessage(Computer computer, List<Integer> userNumbers, BaseBallRule baseBallRule) {
        baseBallRule.compareBall(computer.getComputerNumbers(), userNumbers);

        if (baseBallRule.getBallCount() == 0 && baseBallRule.getStrikeCount() == 0) {
            System.out.println(BASEBALL_RESULT_NOTHING_MESSAGE);
        }

        if (!(baseBallRule.getBallCount() == 0 && baseBallRule.getStrikeCount() == 0)) {
            System.out.println(String.format(BASEBALL_RESULT_MESSAGE,
                    baseBallRule.getBallCount(),
                    baseBallRule.getStrikeCount()));
        }
    }

    public void printFinishMessageAndAnswerReplay() {
        System.out.println(FINISH_MESSAGE);
        System.out.println(ANSWER_REPLAY);
    }
}
