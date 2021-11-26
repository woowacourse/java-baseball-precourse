package baseball.view;

import baseball.exception.InputException;
import camp.nextstep.edu.missionutils.Console;

public class InputView {

	private static final String INPUT_NUMBER_MESSAGE = "숫자를 입력해주세요 : ";
	private static final String INPUT_RESTART_OR_STOP = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요";

	public static String getInput() {
		System.out.print(INPUT_NUMBER_MESSAGE);
		return InputException.userInputValidationCheck(Console.readLine());
	}

	public static String restartOrStop() {
		System.out.println(INPUT_RESTART_OR_STOP);
		return Console.readLine();
	}
}
