package baseball.view;

import baseball.domain.AnswerNumber;
import baseball.domain.GameResult;

public class OutputView {
	private static final String GAME_COMPLETE_MSG = AnswerNumber.ANSWER_LENGTH + "개의 숫자를 모두 맞히셨습니다! 게임 종료";

	public static void printGameResult() {
		System.out.println(GameResult.getResultMsg());
	}
}
