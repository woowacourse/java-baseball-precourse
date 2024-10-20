package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Player {
	public String getInput() {
		System.out.print("숫자를 입력해주세요 : ");
		String input = Console.readLine();
		validateInput(input);
		return input;
	}

	public void validateInput(String input) {
		if (input.length() != 3) {
			throw new IllegalArgumentException("입력은 반드시 3자리 숫자여야 합니다.");
		}
		if (!input.matches("[1-9]{3}")) {
			throw new IllegalArgumentException("입력은 1에서 9까지의 숫자로만 이루어져야 합니다.");
		}
		if (input.chars().distinct().count() != 3) {
			throw new IllegalArgumentException("입력은 서로 다른 숫자여야 합니다.");
		}
	}

}
