package baseball;

import static resource.MessageResource.*;

import camp.nextstep.edu.missionutils.Console;
import util.InputValidationUtils;

public class Player {
	private static final int RESTART = 1;
	private static final int END = 2;

	public String inputBallNumber() {
		System.out.print(INPUT_NUMBER_MESSAGE);
		String ballNumber = Console.readLine();
		if (InputValidationUtils.isCheckValid(ballNumber)) {
			throw new IllegalArgumentException(ERROR_INPUT_NUMBER);
		}
		return ballNumber;
	}

	public boolean isRestart() {
		System.out.println(SELECT_RESTART_MESSAGE);
		int button = Integer.parseInt(Console.readLine());
		if (button == RESTART) {
			return true;
		}
		if (button == END) {
			return false;
		}
		throw new IllegalArgumentException(ERROR_SELECT_RESTART);
	}
}
