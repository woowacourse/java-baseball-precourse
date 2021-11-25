package baseball.view;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
	private static final String REQUEST_INPUT_NUMBERS = "숫자를 입력해주세요 : ";
	private static final String DELIMITER = "";

	public static List<Integer> getAnswerNumbers() {
		System.out.print(REQUEST_INPUT_NUMBERS);
		String inputResult = Console.readLine();
		return Arrays.stream(inputResult.split(DELIMITER))
			.map(Integer::parseInt)
			.collect(Collectors.toList());
	}
}
