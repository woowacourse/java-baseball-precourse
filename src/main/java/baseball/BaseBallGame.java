package baseball;

import static camp.nextstep.edu.missionutils.Console.*;

public class BaseBallGame {

	public BaseBallGame() {
	}

	public void play() {
		Balls userBalls = makeUserBalls();
	}

	private Balls makeUserBalls() {
		Balls userBalls = null;
		while (userBalls == null) {
			String userInput = getUserInput();
			validateUserInput(userInput);
			try {
				userBalls = Balls.stringToBalls(userInput);
			} catch (NumberFormatException e) {
				printFormatExceptionMessage();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		return userBalls;
	}

	private void validateUserInput(String userInput) {
		if (checkUserInputLength(userInput)) {
			throw new IllegalArgumentException("입력값의 길이가 잘못 되었습니다.");
		}
	}

	private String getUserInput() {
		return readLine();
	}

	private Boolean checkUserInputLength(String str) {
		return str.length() != Balls.BALLS_COUNT;
	}

	private void printFormatExceptionMessage() {
		System.out.printf("%d개의 1~9 사이의 중복되지 않는 수만 입력할 수 있습니다.%n", Balls.BALLS_COUNT);
	}
}
