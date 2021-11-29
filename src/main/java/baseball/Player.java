package baseball;

import static resource.MessageResource.*;

import camp.nextstep.edu.missionutils.Console;

public class Player {
	public String inputBallNumber() {
		System.out.print(INPUT_NUMBER_MESSAGE);
		String ballNumber = Console.readLine();
		if (ballNumber.length() != 3) {
			throw new IllegalArgumentException(ERROR_INPUT_NUMBER);
		}
		return ballNumber;
	}
}
