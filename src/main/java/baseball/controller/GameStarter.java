package baseball.controller;

import java.util.List;

import baseball.view.ConsoleView;
import baseball.constants.NumberConstants;
import baseball.constants.StringConstants;
import baseball.dto.CompareResult;
import baseball.service.Computer;

public class GameStarter {
	private Computer computer;
	private ConsoleView view;

	public GameStarter() {
		computer = new Computer();
		view = new ConsoleView();
	}

	public void start() {
		int resume = NumberConstants.RESUME;
		do {
			List<Integer> inputNumbers = view.getUserInputNumbers();

			CompareResult result = compareWithRandomNumbers(inputNumbers);

			if(checkAllCorrect(result)) {
				view.notifyCorrectAll();
				resume = view.getRestartIntention();
				checkRestart(resume);
			}

		} while(resume == NumberConstants.RESUME);
	}

	private CompareResult compareWithRandomNumbers(List<Integer> inputNumbers) {
		CompareResult result = computer.compareNumbers(inputNumbers);
		String resultOfComparing = resultOfComparing(result);
		view.notifyResultOfComparing(resultOfComparing);
		return result;
	}

	private boolean checkAllCorrect(CompareResult result) {
		return result.getStrike() == NumberConstants.RANDOM_NUMBER_SIZE;
	}

	private String resultOfComparing(CompareResult result) {
		int strike = result.getStrike();
		int ball = result.getBall();

		if(strike == 0 && ball == 0) {
			return String.format(StringConstants.NOTHING);
		} else if(ball == 0) {
			return String.format(StringConstants.STRIKE, strike);
		} else if(strike == 0) {
			return String.format(StringConstants.BALL, ball);
		}
		return String.format(StringConstants.BALL_AND_STRIKE, ball, strike);
	}

	private void checkRestart(int resume) {
		if(resume == NumberConstants.RESUME) {
			computer.refresh();
		}
	}
}
