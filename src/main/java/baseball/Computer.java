package baseball;

import baseball.view.InputView;

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

			System.out.println(randomBallNumbers);
			System.out.println(resultCalculator.getBall() + "볼");
			System.out.println(resultCalculator.getStrike() + "스트라이크");

			if (resultCalculator.getStrike() == 3) {
				inputView.printExitOrRestartMessage();
				inputView.setInputExitOrRestart();
				System.out.println(inputView.getInputExitOrRestart());
			}
		}
	}
}
