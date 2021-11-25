package baseball;

import baseball.domain.BaseballGame;
import baseball.view.OutputView;
import camp.nextstep.edu.missionutils.Console;

public class Application {
	public static void main(String[] args) {
		// TODO: 숫자 야구 게임 구현
		BaseballGame baseballGame = new BaseballGame();
		baseballGame.init();
		OutputView.printInputMessage();
		baseballGame.offer(Console.readLine());
	}
}
