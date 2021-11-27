package baseball.input;

import baseball.model.InputFactory;
import baseball.output.Output;
import camp.nextstep.edu.missionutils.Console;

public class BaseballNumberInput implements InputFactory {
	@Override
	public String receiveInput() {
		Output.printRequestNumberInput();
		String inputNumber = Console.readLine();
		return inputNumber;
	}
}
