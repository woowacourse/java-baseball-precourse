package baseball.view;

import static baseball.constants.GameConstants.GameOverInput.*;
import static baseball.utils.ValidationUtils.*;

import java.util.List;

import baseball.constants.GameConstants;
import baseball.utils.ConversionUtils;
import camp.nextstep.edu.missionutils.Console;

public class InputView {
	public static List<Integer> inputUserNumber() {
		String userInput = Console.readLine();
		validateUserInputDigitsLength(userInput);
		validateUserInputDigitsInRange(userInput);

		List<Integer> userNumberList = ConversionUtils.userInputStringToIntegerList(userInput);
		validateUserInputDigitListDuplicate(userNumberList);

		return userNumberList;
	}

	public static GameConstants.GameOverInput inputUserGameOverSelection() {
		String userInput = Console.readLine();
		validateUserGameOverInputNumber(userInput);
		validateUserGameOverInputLength(userInput);
		validateUserGameOverInputInRange(userInput);
		if (userInput.equals("1"))
			return RESTART;
		else
			return STOP;
	}
}
