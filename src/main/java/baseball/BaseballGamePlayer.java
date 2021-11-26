package baseball;

import static baseball.SystemMessage.*;

import camp.nextstep.edu.missionutils.Console;

/**
 * 난수를 생성 및 저장, 스트라이크 볼 판별, 결과 출력, 게임 재시작
 * 야구 게임 관련 책임을 가진 클래스
 */
public class BaseballGamePlayer {
	private int strikeCount = 0;
	private int ballCount = 0;
	private String goalNumberString = null;

	public void setRandomGoalNumberString() {
		goalNumberString = RandomNumberStringMaker.getRandomNumberString();
	}

	/**
	 * 사용자의 문자열과 목표 문자열을 비교해서 스트라이크, 볼 필드를 초기화.
	 * @param userString
	 */
	public void compareString(String userString) {
		strikeCount = 0;
		ballCount = 0;

		for (int i = 0; i < goalNumberString.length(); i++) {
			char number = goalNumberString.charAt(i);
			if (userString.charAt(i) == number) {
				strikeCount++;
			} else if (userString.contains(String.valueOf(number))) {
				ballCount++;
			}
		}
	}

	public void printResult() {
		if (strikeCount == 0 && ballCount == 0) {
			System.out.println("낫싱");
		} else if (strikeCount == 0) {
			System.out.println(ballCount + "볼");
		} else if (ballCount == 0) {
			System.out.println(strikeCount + "스트라이크");
		} else if (ballCount != 0 && strikeCount != 0) {
			System.out.println(ballCount + "볼 " + strikeCount + "스트라이크");
		}
	}

	/**
	 * 스트라이크 3개를 달성하기 전까지 계속 세자리 숫자를 입력받아 게임을 진행하는 메서드
	 */
	public void playBaseballGame() {
		do {
			System.out.print(INPUT_NUMBERS);
			String inputString = Console.readLine();
			InputStringChecker.checkStringIsNumbers(inputString);
			compareString(inputString);
			printResult();
		} while (strikeCount != 3);
		System.out.println(THREE_STRIKE_SUCCESS);
	}

	/**
	 * 정답을 맞췄을 때, 게임 추가 진행을 입력받고 그 여부를 반환하는 메서드
	 * @Return boolean
	 */
	public boolean getNewGame() {
		final int startNewGame = 1;
		final int exitProgram = 2;
		String inputString = Console.readLine();
		InputStringChecker.checkStringIsOneOrTwo(inputString);
		int answer = Integer.parseInt(inputString);
		if (answer == startNewGame) {
			return true;
		} else if (answer == exitProgram) {
			return false;
		}
		throw new IllegalArgumentException("getNewGame IllegalArgumentException.");
	}
}
