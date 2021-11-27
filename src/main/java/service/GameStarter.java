package service;

import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import constants.Constants;
import dto.CompareResult;

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
		int resume = Constants.RESUME;
		do {
			List<Integer> givenNumbers = getUserGivenNumbers();

			CompareResult result = computer.compareNumbers(givenNumbers);
			notifyResultOfComparing(result);

			if(checkAllCorrect(result)) {
				notifyCorrectAll();
				resume = getResumeIntention();
				checkResume(resume);
			}

		} while(resume == Constants.RESUME);
	}

	private List<Integer> getUserGivenNumbers() {
		String givenString = readLineFromUser();
		validator.validateGivenString(givenString, Constants.RANDOM_NUMBER_SIZE);
		return converter.convertStringToIntegerList(givenString);
	}

	private String readLineFromUser() {
		System.out.print("숫자를 입력해주세요 : ");
		return Console.readLine();
	}

	private void notifyResultOfComparing(CompareResult result) {
		System.out.println(resultOfComparing(result));
	}

	private String resultOfComparing(CompareResult result) {
		int strike = result.getStrike();
		int ball = result.getBall();

		if(strike == 0 && ball == 0) {
			return "낫싱";
		} else if(strike != 0 && ball == 0) {
			return strike + "스트라이크";
		} else if(strike == 0 && ball != 0) {
			return ball + "볼";
		}
		return ball + "볼 " + strike + "스트라이크";
	}

	private boolean checkAllCorrect(CompareResult result) {
		return result.getStrike() == Constants.RANDOM_NUMBER_SIZE;
	}

	private void notifyCorrectAll() {
		System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
		System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
	}

	private int getResumeIntention() {
		String restart = Console.readLine();
		validator.validateRestartString(restart);
		return converter.convertStringToInt(restart);
	}

	private void checkResume(int resume) {
		if(resume == Constants.RESUME) {
			computer.refresh();
		}
	}
}
