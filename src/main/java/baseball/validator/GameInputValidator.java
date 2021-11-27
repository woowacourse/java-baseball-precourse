package baseball.validator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GameInputValidator implements InputValidator {

	@Override
	public void inputCheck(String input) throws IllegalArgumentException {
		int lengthRule = 3;

		// input 의 길이가 3이 아닐때 예외 발생
		if (input.length() != lengthRule) {
			throw new IllegalArgumentException();
		}

		// input 에 숫자가 아닌 값 혹은 0이 있을 때 예외 발생
		for (int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);

			if (!Character.isDigit(c) || c == 48) {
				throw new IllegalArgumentException();
			}
		}

		// input 에 중복되는 숫자가 입력될 때
		ArrayList<Character> inputCharList = new ArrayList<>();
		for (char c : input.toCharArray()) {
			inputCharList.add(c);
		}

		List<Character> inputCharDistinctList = inputCharList.stream().distinct().collect(Collectors.toList());

		if (inputCharList.size() != inputCharDistinctList.size()) {
			throw new IllegalArgumentException();
		}
	}
}
