package baseball;

import static baseball.utils.Constant.*;

import baseball.players.Computer;
import baseball.players.User;
import camp.nextstep.edu.missionutils.Console;

public class BaseballGame {
	private Computer computer;
	private User user;
	private int ballCount;
	private int strikeCount;

	public BaseballGame() {
		this.computer = new Computer();
		this.user = new User();
		this.ballCount = 0;
		this.strikeCount = 0;
	}

	/**
	 * 전체 게임을 플레이하는 메소드. 각 회차가 종료되면 게임 재시작 여부를 입력받아서
	 * 재시작 또는 종료를 한다.
	 */
	public void run() {
		try {
			boolean isGameContinued = true;
			System.out.println(START_GAME_MSG);
			do {
				computer.createNumbers();
				playGame();
				isGameContinued = checkRetry();
			} while (isGameContinued);
			System.out.println(END_MSG);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * 한 회차의 게임 플레이를 하는 메소드.
	 * @throws IllegalArgumentException User에서 input 도중 IllegalArgumentException이 발생할 경우
	 * 그대로 예외를 던져서 상위 메소드에서 처리한다.
	 */
	public void playGame() throws IllegalArgumentException {
		boolean isEnd = false;
		do {
			user.inputNumbers();
			countResult();
			printHint();
			isEnd = checkResult();
		} while (!isEnd);
	}

	/**
	 * 스트라이크와 볼의 개수를 센다.
	 */
	private void countResult() {
		strikeCount = 0;
		ballCount = 0;
		for (int i = 0; i < LENGTH_OF_NUMBERS; i++) {
			if (isStrike(i)) {
				strikeCount++;
				continue;
			}
			if (isBall(i)) {
				ballCount++;
			}
		}
	}

	/**
	 * 게임이 종료되는지 여부를 판정한다.
	 * @return 스트라이크가 3개면 true를 반환한다.
	 */
	private boolean checkResult() {
		if (strikeCount != LENGTH_OF_NUMBERS) {
			return false;
		}
		System.out.println(CORRECT_MSG);
		return true;
	}

	/**
	 * 숫자의 위치를 받아 해당 위치의 숫자가 스트라이크인지 판정한다.
	 * @param index 스트라이크인지 판정할 위치의 인덱스
	 * @return 스트라이크 여부를 반환한다.
	 */
	private boolean isStrike(int index) {
		return user.getNumber(index) == computer.getNumber(index);
	}

	/**
	 * 유저의 숫자의 위치를 받아 해당 숫자가 볼인지 판정한다.
	 * @param userIndex 볼인지 판정할 위치의 인덱스
	 * @return 볼 여부를 반환한다.
	 */
	private boolean isBall(int userIndex) {
		int comIndex = computer.getIndex(user.getNumber(userIndex));
		return comIndex != userIndex && comIndex != -1;
	}

	/**
	 * 스트라이크 / 볼 결과를 바탕으로 힌트를 출력한다.
	 */
	private void printHint() {
		String resultString = "";
		if (ballCount != 0) {
			resultString += ballCount + BALL;
		} else if (ballCount == strikeCount) {
			resultString = NOTHING;
		}
		if (strikeCount != 0) {
			resultString += strikeCount + STRIKE;
		}
		System.out.println(resultString);
	}

	/**
	 * 사용자에게 게임 재시작 여부를 입력받는다.
	 * @return 1을 입력받으면 true, 2를 입력받으면 false를 반환하고,
	 * 그 외의 경우 IllegalArgumentException을 발생시킨다.
	 */
	private boolean checkRetry() {
		System.out.println(CHECK_END_MSG);
		String input = Console.readLine();
		if (input.equals("1")) {
			return true;
		}
		if (input.equals("2")) {
			return false;
		}
		throw new IllegalArgumentException(ERR_INPUT_MSG);
	}
}
