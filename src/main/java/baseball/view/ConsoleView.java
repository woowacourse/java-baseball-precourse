package baseball.view;

import java.util.List;

import baseball.constants.StringConstants;
import baseball.service.Converter;
import baseball.service.Validator;
import camp.nextstep.edu.missionutils.Console;

public class ConsoleView {
	private Converter converter;
	private Validator validator;

	public ConsoleView() {
		converter = new Converter();
		validator = new Validator();
	}

	public List<Integer> getUserInputNumbers() {
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

	public void notifyResultOfComparing(String resultOfComparing) {
		System.out.println(resultOfComparing);
	}

	public void notifyCorrectAll() {
		System.out.println(StringConstants.NOTIFY_CORRECT_ALL);
		System.out.println(StringConstants.NOTIFY_RESTART);
	}

	public int getRestartIntention() {
		String restartString = Console.readLine();
		validator.validateRestartString(restartString);
		int restartNumber = converter.convertStringToInt(restartString);
		validator.validateRestartNumber(restartNumber);
		return restartNumber;
	}
}
