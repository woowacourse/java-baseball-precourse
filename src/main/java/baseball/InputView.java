package baseball;

import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
	private static final String ENTER_THE_PREDICTION = "숫자를 입력해주세요 : ";

	public List<Integer> getPredictionNumber() {
		System.out.print(ENTER_THE_PREDICTION);
		return InputValidation.validatePrediction(Console.readLine());
	}
}
