package baseball;

import static baseball.utils.Constant.*;

import baseball.players.Computer;
import baseball.players.User;

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

	public void run() {
		boolean isGameContinued = true;
		System.out.println(START_GAME_MSG);
		do {
			try {
				user.inputNumbers();
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
				break;
			}
			countResult();
			isGameContinued = checkResult();
		} while (isGameContinued);
		System.out.println();
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
			return true;
		}
		System.out.println(CORRECT_MSG);
		return false;
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
}
