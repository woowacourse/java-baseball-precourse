package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Round {
	static Referee referee = new Referee();
	static void input3Digits(ThreeDifferentDigits answer) {
		System.out.print("숫자를 입력해 주세요 : ");

		String input = Console.readLine();

		CheckException.is3DigitValid(input);

		referee.judge(answer.getDigits(), input.split(""));
	}
}
