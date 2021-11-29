package baseball;

import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
	private static final String ENTER_THE_PREDICTION = "숫자를 입력해주세요 : ";
	private static final String ENTER_THE_QUIT_OR_NOT = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

	public List<Integer> getPredictionNumber() {
		System.out.print(ENTER_THE_PREDICTION);
		return InputValidation.validatePrediction(Console.readLine());
	}

	public boolean getQuitOrNot() {
		System.out.println(ENTER_THE_QUIT_OR_NOT);
		String quitOrNot = Console.readLine();
		if (quitOrNot.equals("1")) {
			return false;
		} else {
			return true;
		}
	}
}
