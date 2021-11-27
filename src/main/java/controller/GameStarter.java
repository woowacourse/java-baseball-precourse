package controller;

import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import constants.NumberConstants;
import constants.StringConstants;
import dto.CompareResult;
import service.Computer;
import service.Converter;
import service.Validator;

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
		validator.validateInputString(inputString, NumberConstants.RANDOM_NUMBER_SIZE);
		return converter.convertStringToIntegerList(inputString);
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
			return StringConstants.NOTHING;
		} else if(strike != 0 && ball == 0) {
			return strike + StringConstants.STRIKE;
		} else if(strike == 0 && ball != 0) {
			return ball + StringConstants.BALL;
		}
		return ball + StringConstants.BALL + " " + strike + StringConstants.STRIKE;
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
		return converter.convertStringToInt(restartString);
	}

	private void checkResume(int resume) {
		if(resume == NumberConstants.RESUME) {
			computer.refresh();
		}
	}
}
