package baseball;

import java.util.List;

import com.io.Input;
import com.io.Output;
import com.model.BaseballFactory;
import com.model.Result;

public class BaseballGame {
	private Computer computer = new Computer();
	private static final int END_COUNT = 3;
	private List<Integer> userBaseballNumbers;
	private List<Integer> computerBaseballNumbers;
	private int count = 0;

	public void playGame() {
		computerBaseballNumbers = computer.createRandomBaseballNumbers();

		do {
			count = progress();
		} while (count != END_COUNT);

		System.out.println(Output.CORRECT_ANSWER_AND_EXIT_MESSAGE);
	}

	private int progress() {
		String inputNumber = Input.receiveNumberInput();
		userBaseballNumbers = BaseballFactory.createUserBaseballNumbers(inputNumber);
		CheckBaseballNumbers baseballNumbers = new CheckBaseballNumbers(userBaseballNumbers, computerBaseballNumbers);
		Result result = new Result(baseballNumbers.countStrike(), baseballNumbers.countBall());
		Output.printBaseballGameResult(result.getResult());
		return baseballNumbers.countStrike();
	}

}
