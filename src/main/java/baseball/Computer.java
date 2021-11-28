package baseball;

import baseball.view.InputView;
import baseball.view.ResultView;

public class Computer {
	public void playGames() {
		RandomNumberPicker randomNumberPicker = new RandomNumberPicker();
		randomNumberPicker.setRandomBallNumbers();
		String randomBallNumbers = randomNumberPicker.getRandomBallNumbers();

		while (true) {
			InputView inputView = new InputView();
			inputView.printStartMessage();
			inputView.setInputBallNumbers();
			String inputBallNumbers = inputView.getInputBallNumbers();

			new InputBallNumberValidator(inputBallNumbers);

			if (inputBallNumbers.equals("q")) {
				break;
			}

			ResultCalculator resultCalculator = new ResultCalculator(inputBallNumbers, randomBallNumbers);

			ResultView resultView = new ResultView();
			resultView.printResult(resultCalculator.getBall(), resultCalculator.getStrike());

			if (resultCalculator.getStrike() == 3) {
				resultView.printEndMessage();

				inputView.printExitOrRestartMessage();
				inputView.setInputExitOrRestart();
				String inputExitOrRestart = inputView.getInputExitOrRestart();
				new InputExitOrRestartValidator(inputExitOrRestart);

				if (inputExitOrRestart.equals("2")) { // indent 초과
					break;
				}
			}
		}
	}
}
