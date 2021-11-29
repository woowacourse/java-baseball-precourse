package baseball;

import baseball.view.InputView;

public class User {

	private InputView inputView = new InputView();
	private InputValidator inputValidator = new InputValidator();
	private String inputBallNumbers;
	private String inputRestartOrExit;

	public String getInputBallNumbers() {
		inputView.printStartMessage();
		inputView.setInputBallNumbers();
		inputBallNumbers = inputView.getInputBallNumbers();

		inputValidator.validateInputBallNumbers(inputBallNumbers);

		return inputBallNumbers;
	}

	public String getRestartOrExit() {
		inputView.printRestartOrExitMessage();
		inputView.setInputRestartOrExit();
		inputRestartOrExit = inputView.getInputRestartOrExit();

		inputValidator.validateInputRestartOrExit(inputRestartOrExit);

		return inputRestartOrExit;
	}
}
