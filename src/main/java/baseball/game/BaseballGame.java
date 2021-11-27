package baseball.game;

import java.util.List;

import baseball.input.BaseballNumberInput;
import baseball.model.ResultContainer;
import baseball.number.ComputerNumber;
import baseball.number.UserNumber;
import baseball.output.Output;
import baseball.output.PrintMessage;

public class BaseballGame {
	private static final int END_COUNT = 3;
	private ComputerNumber computerNumber = new ComputerNumber();
	private List<Integer> userBaseballNumbers;
	private List<Integer> computerBaseballNumbers;
	private int count = 0;

	public void playGame() {
		computerBaseballNumbers = computerNumber.createBaseballNumbers();

		do {
			count = progress();
		} while (count != END_COUNT);

		Output.printBaseballGameResult(PrintMessage.CORRECT_ANSWER_AND_EXIT_MESSAGE.getMessage());
	}

	private int progress() {
		BaseballNumberInput baseballNumberInput = new BaseballNumberInput();
		String inputNumber = baseballNumberInput.receiveInput();
		UserNumber userNumber = new UserNumber(inputNumber);
		userBaseballNumbers = userNumber.createBaseballNumbers();
		CheckBaseballNumber baseballNumbers = new CheckBaseballNumber(userBaseballNumbers, computerBaseballNumbers);
		ResultContainer result = new ResultContainer(baseballNumbers.countStrike(), baseballNumbers.countBall());
		Output.printBaseballGameResult(result.getResult());
		return baseballNumbers.countStrike();
	}

}
