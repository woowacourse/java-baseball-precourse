package baseball;

import baseball.domain.BaseballGame;
import baseball.domain.Result;
import baseball.view.InputView;
import baseball.view.OutputView;

public class Application {
	public static void main(String[] args) {
		// TODO: 숫자 야구 게임 구현
		BaseballGame baseballGame = new BaseballGame();
		boolean isNewGame = true;

		while (true) {
			if (isNewGame) {
				baseballGame.init();
				isNewGame = false;
			}
			OutputView.printInputMessage();
			String playerInput = InputView.enterNum();
			int[] playerNum = baseballGame.validCheck(playerInput);
			Result result = baseballGame.offer(playerNum);
			OutputView.printResult(result);
			if (result.getStrikeCount() == 3) {
				OutputView.printDone();
				return;
			}
		}
	}
}
