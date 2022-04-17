package baseball.domain.constants;

import baseball.domain.rule.BaseBallCount;

public class ConstantsMessages {

    public static final String INPUT_MESSAGES = "숫자를 입력해 주세요 : ";

    public static final String BASEBALL_RESULT_MESSAGE = "%d" + BaseBallCount.BALL.getName() + " %d" + BaseBallCount.STRIKE.getName();

    public static final String BASEBALL_3STRIKE_MESSAGE = "3" + BaseBallCount.STRIKE.getName();

    public static final String BASEBALL_3BALL_MESSAGE = "3" + BaseBallCount.BALL.getName();

    public static final String BASEBALL_RESULT_NOTHING_MESSAGE = BaseBallCount.NOTHING.getName();

    public static final String FINISH_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    public static final String ANSWER_REPLAY = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
}
