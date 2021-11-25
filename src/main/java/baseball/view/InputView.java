package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
	private static final String NUMBER_INPUT_MESSAGE = "숫자를 입력하세요 : ";

	public static String inputNumber(){
		System.out.print(NUMBER_INPUT_MESSAGE);
		return Console.readLine();
	}
}
