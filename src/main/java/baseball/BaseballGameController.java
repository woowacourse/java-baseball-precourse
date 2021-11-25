package baseball;

import baseball.domain.BaseballGame;
import baseball.domain.Result;
import baseball.util.Validator;
import baseball.view.InputView;
import baseball.view.OutputView;

public class BaseballGameController {
	BaseballGame baseballGame;

	public BaseballGameController(BaseballGame baseballGame) {
		this.baseballGame = baseballGame;
	}

	public void gameStart() {
		boolean isNewGame = true;
		while (true) {
			if (isNewGame) {
				baseballGame.init();
				isNewGame = false;
			}
			int[] playerNum = enterNum();
			Result result = baseballGame.offer(playerNum);
			OutputView.printResult(result);
			if (result.isCorrect()) {
				OutputView.printGameEnd();
				return;
			}
		}
	}

	public int selectAfterEnd() {
		OutputView.printRetryOrExit();
		String select = InputView.enterNum();
		Validator.checkSelectValid(select);
		return Integer.parseInt(select);
	}

	private int[] enterNum() {
		OutputView.printInputMessage();
		String playerInput = InputView.enterNum();
		return baseballGame.validCheck(playerInput);
	}
}
