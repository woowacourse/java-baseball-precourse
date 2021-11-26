package baseball;

import static camp.nextstep.edu.missionutils.Console.*;

public class Application {
	public static void main(String[] args) {
		int isGameEnd;
		do {
			gameStart();
			isGameEnd = Integer.parseInt(readLine());
		} while (isGameEnd == 1);
	}

	static void gameStart() {
		//TODO: 숫자 야구 게임 구현
	}

	//TODO: Target클래스에 맞춰서 범위와 길이를 맞춰야함.
	static void checkUserInput(String userInput) {
		if (userInput.length() > 3) {
			throw new IllegalArgumentException();
		}
		for (int i = 0; i < userInput.length(); i++) {
			if (userInput.charAt(i) - '0' < 1 && userInput.charAt(i) - '0' > 9) {
				throw new IllegalArgumentException();
			}
		}
	}
}
