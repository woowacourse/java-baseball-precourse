package baseball;

import baseball.domain.BaseballGame;
import baseball.util.Converter;
import baseball.view.InputView;
import baseball.view.OutputView;
import camp.nextstep.edu.missionutils.Console;

public class Application {
	public static void main(String[] args) {
		// TODO: 숫자 야구 게임 구현
		BaseballGame baseballGame = new BaseballGame();
		baseballGame.init();
		OutputView.printInputMessage();
		String playerInput = InputView.enterNum();
		int[] playerNum = baseballGame.validCheck(playerInput);
		baseballGame.offer(playerNum);
	}
}
