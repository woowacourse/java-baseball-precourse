package baseball;

import baseball.view.ResultView;

public class GameSystem {

	private static final String EXIT_CODE = "2";
	private static final int THREE_STRIKE = 3;
	private Computer computer = new Computer();
	private User user = new User();
	private ResultCalculator resultCalculator;
	private ResultView resultView = new ResultView();
	private String randomBallNumbers;
	private String inputBallNumbers;
	private String inputRestartOrExit;

	public void playGames() {
		do {
			playGame();
		} while (restartGame());
	}

	private void playGame() {
		randomBallNumbers = computer.getRandomBallNumbers();

		do {
			inputBallNumbers = user.getInputBallNumbers();

			resultCalculator = new ResultCalculator(inputBallNumbers, randomBallNumbers);
			resultCalculator.calculateResults();

			resultView.printResult(resultCalculator.getBall(), resultCalculator.getStrike());

		} while (resultCalculator.getStrike() != THREE_STRIKE);
	}

	private boolean restartGame() {
		resultView.printCorrectMessage();
		inputRestartOrExit = user.getRestartOrExit();

		return !inputRestartOrExit.equals(EXIT_CODE);
	}
}
