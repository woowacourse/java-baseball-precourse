package baseball;

import baseball.view.InputView;
import baseball.view.ResultView;

public class Computer {

	private RandomNumberPicker randomNumberPicker;
	private String randomBallNumbers;
	private InputView inputView;
	private String inputBallNumbers;
	private ResultCalculator resultCalculator;
	private ResultView resultView;

	public void playGames() {
		while (true) {
			if(!playGame()) {
				break;
			}
		}
	}

	public boolean playGame() {
		randomNumberPicker = new RandomNumberPicker();
		randomNumberPicker.setRandomBallNumbers();
		randomBallNumbers = randomNumberPicker.getRandomBallNumbers();

		while (true) {
			inputView = new InputView();
			inputView.printStartMessage();
			inputView.setInputBallNumbers();
			inputBallNumbers = inputView.getInputBallNumbers();

			new InputBallNumberValidator(inputBallNumbers);

			resultCalculator = new ResultCalculator(inputBallNumbers, randomBallNumbers);

			resultView = new ResultView();
			resultView.printResult(resultCalculator.getBall(), resultCalculator.getStrike());

			if (resultCalculator.getStrike() == 3) {
				resultView.printEndMessage();

				inputView.printExitOrRestartMessage();
				inputView.setInputExitOrRestart();
				String inputExitOrRestart = inputView.getInputExitOrRestart();

				new InputExitOrRestartValidator(inputExitOrRestart);

				return restartGame(inputExitOrRestart);
			}
		}
	}

	public boolean restartGame(String inputExitOrRestart) {
		if (inputExitOrRestart.equals("2")) {
			return false;
		} else {
			return true;
		}
	}
}
