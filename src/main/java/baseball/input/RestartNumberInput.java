package baseball.input;

import baseball.model.InputFactory;
import baseball.output.Output;
import camp.nextstep.edu.missionutils.Console;

public class RestartNumberInput implements InputFactory {
	@Override
	public String receiveInput() {
		Output.printRequestRestartNumberInput();
		String inputNumber = Console.readLine();
		return inputNumber;
	}
}
