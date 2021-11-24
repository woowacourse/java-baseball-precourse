package baseball.view;

import java.util.List;

import baseball.utils.ConversionUtils;
import baseball.utils.ValidationUtils;
import camp.nextstep.edu.missionutils.Console;

public class InputView {
	public static List<Integer> inputUserNumber(){
		String userInput = Console.readLine();
		ValidationUtils.validateUserInputDigitsLength(userInput);
		ValidationUtils.validateUserInputDigitsInRange(userInput);

		List<Integer> userNumberList = ConversionUtils.userInputStringToIntegerList(userInput);
		ValidationUtils.validateUserInputDigitListDuplicate(userNumberList);

		return userNumberList;
	}

	public static int inputUserGameOverSelection() {
		String userInput = Console.readLine();
		ValidationUtils.validateUserGameOverInputLength(userInput);
		ValidationUtils.validateUserGameOverInputInRange(userInput);
		return Integer.parseInt(userInput);
	}
}
