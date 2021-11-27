package baseball.controller;

import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import baseball.constants.NumberConstants;
import baseball.constants.StringConstants;
import baseball.dto.CompareResult;
import baseball.service.Computer;
import baseball.service.Converter;
import baseball.service.Validator;

public class GameStarter {
	private Computer computer;
	private Converter converter;
	private Validator validator;

	public GameStarter() {
		computer = new Computer();
		converter = new Converter();
		validator = new Validator();
	}

	public void start() {
		int resume = NumberConstants.RESUME;
		do {
			List<Integer> inputNumbers = getUserInputNumbers();

			CompareResult result = computer.compareNumbers(inputNumbers);
			notifyResultOfComparing(result);

			if(checkAllCorrect(result)) {
				notifyCorrectAll();
				resume = getResumeIntention();
				checkResume(resume);
			}
		} while(resume == NumberConstants.RESUME);
	}

	private List<Integer> getUserInputNumbers() {
		String inputString = readLineFromUser();
		validator.validateInputString(inputString);
		List<Integer> inputNumbers = converter.convertStringToIntegerList(inputString);
		validator.validateInputNumbers(inputNumbers);
		return inputNumbers;
	}

	private String readLineFromUser() {
		System.out.print(StringConstants.ASK_NUMBER);
		return Console.readLine();
	}

	private void notifyResultOfComparing(CompareResult result) {
		System.out.println(resultOfComparing(result));
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

	private boolean checkAllCorrect(CompareResult result) {
		return result.getStrike() == NumberConstants.RANDOM_NUMBER_SIZE;
	}

	private void notifyCorrectAll() {
		System.out.println(StringConstants.NOTIFY_CORRECT_ALL);
		System.out.println(StringConstants.NOTIFY_RESTART);
	}

	private int getResumeIntention() {
		String restartString = Console.readLine();
		validator.validateRestartString(restartString);
		int restartNumber = converter.convertStringToInt(restartString);
		validator.validateRestartNumber(restartNumber);
		return restartNumber;
	}

	private void checkResume(int resume) {
		if(resume == NumberConstants.RESUME) {
			computer.refresh();
		}
	}
}
