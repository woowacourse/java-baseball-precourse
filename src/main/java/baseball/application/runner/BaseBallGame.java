package baseball.application.runner;

import baseball.application.domain.JudgementResult;
import baseball.application.domain.number.Number;
import baseball.application.domain.number.UniqueNumberFactory;
import baseball.application.service.Referee;
import baseball.application.view.InputView;
import baseball.application.view.OutputView;

public class BaseBallGame {

	private final InputView inputView;
	private final OutputView outputView;
	private final Referee referee;

	public BaseBallGame(InputView inputView, OutputView outputView, Referee referee) {
		this.inputView = inputView;
		this.outputView = outputView;
		this.referee = referee;
	}

	public void start() {

		do {
			playGame();
		} while (wantNewGame());

	}

	private void playGame() {
		Number enemyNumber = UniqueNumberFactory.create();

		do {
			Number playerNumber = inputView.guessNumber();
			JudgementResult result = referee.judge(enemyNumber, playerNumber);
			outputView.printResult(result);
		} while (!referee.isGameOver());

		outputView.gameOver();
	}

	private boolean wantNewGame() {
		return inputView.wantNewGame();
	}

}
