package baseball.player;

import baseball.constant.Constant;
import camp.nextstep.edu.missionutils.Console;

public class Player {

	public String readUserAnswer() {
		System.out.print(Constant.INPUT_NUMBER_MESSAGE);
		String userAnswer = Console.readLine();

		return Validator.validateUserAnswer(userAnswer);
	}

}
