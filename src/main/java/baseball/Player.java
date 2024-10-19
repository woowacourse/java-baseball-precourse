package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Player {
	public String getInput() {
		System.out.print("숫자를 입력해주세요 : ");
		String input = Console.readLine();
		validateInput(input);
		return input;
	}

	private void validateInput(String input) {
		if (input.length() != 3 || !input.matches("[1-9]{3}")) {
			throw new IllegalArgumentException("잘못된 입력입니다. 1부터 9까지의 3자리 숫자를 입력하세요.");
		}
	}
}
