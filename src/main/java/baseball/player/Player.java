package baseball.player;

import camp.nextstep.edu.missionutils.Console;

public class Player {

	public String readUserAnswer() {
		System.out.println("숫자를 입력해주세요 :");
		String userAnswer = Console.readLine();

		return Validator.validateUserAnswer(userAnswer);
	}

}
