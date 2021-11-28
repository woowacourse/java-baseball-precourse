package baseball.controller;

import java.util.List;

import baseball.constants.ComparingResultConstant;
import baseball.constants.RandomNumberConstant;
import baseball.view.ConsoleView;
import baseball.constants.StatementConstant;
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
		int resume = StatementConstant.RESUME;
		do {
			List<Integer> inputNumbers = view.getUserInputNumbers();

			CompareResult result = compareWithRandomNumbers(inputNumbers);

			if(checkAllCorrect(result)) {
				view.notifyCorrectAll();
				resume = view.getRestartIntention();
				checkRestart(resume);
			}

		} while(resume == StatementConstant.RESUME);
	}

	private CompareResult compareWithRandomNumbers(List<Integer> inputNumbers) {
		CompareResult result = computer.compareNumbers(inputNumbers);
		String resultOfComparing = resultOfComparing(result);
		view.notifyResultOfComparing(resultOfComparing);
		return result;
	}

	private boolean checkAllCorrect(CompareResult result) {
		return result.getStrike() == RandomNumberConstant.RANDOM_NUMBER_SIZE;
	}

	private String resultOfComparing(CompareResult result) {
		int strike = result.getStrike();
		int ball = result.getBall();

		if(strike == 0 && ball == 0) {
			return String.format(ComparingResultConstant.NOTHING);
		} else if(ball == 0) {
			return String.format(ComparingResultConstant.STRIKE, strike);
		} else if(strike == 0) {
			return String.format(ComparingResultConstant.BALL, ball);
		}
		return String.format(ComparingResultConstant.BALL_AND_STRIKE, ball, strike);
	}

	private void checkRestart(int resume) {
		if(resume == StatementConstant.RESUME) {
			computer.refresh();
		}
	}
}
