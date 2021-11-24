package baseball.view;

import static baseball.utils.ValidationUtils.*;

import java.util.List;

import baseball.utils.ConversionUtils;
import baseball.utils.ValidationUtils;
import camp.nextstep.edu.missionutils.Console;

public class InputView {
	public static List<Integer> inputUserNumber(){
		String userInput = Console.readLine();
		validateUserInputDigitsLength(userInput);
		validateUserInputDigitsInRange(userInput);

		List<Integer> userNumberList = ConversionUtils.userInputStringToIntegerList(userInput);
		validateUserInputDigitListDuplicate(userNumberList);

		return userNumberList;
	}

	public static int inputUserGameOverSelection() {
		String userInput = Console.readLine();
		validateUserGameOverInputLength(userInput);
		validateUserGameOverInputInRange(userInput);
		return Integer.parseInt(userInput);
	}
}
