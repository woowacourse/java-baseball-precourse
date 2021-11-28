package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Player {

	public int[] getNumberFromPlayer() {
		String tempInput;
		int[] playerNumber;

		System.out.print("숫자를 입력해 주세요 : ");

		tempInput = Console.readLine();

		playerNumber = new int[tempInput.length()];

		for (int i = 0; i < tempInput.length(); i++) {
			playerNumber[i] = tempInput.charAt(i) - '0';
		}

		checkException(playerNumber);

		return playerNumber;
	}

	//need: 사용자 입력 예외 처리
	public void checkException(int[] playerNumber) {
		if (playerNumber.length != 3) {
			throw new IllegalArgumentException();
		}

		if (isStartWithZero(playerNumber)) {
			throw new IllegalArgumentException();
		}

	}


	public boolean isStartWithZero(int[] number) {
		if (number[0] == 0) {
			return true;
		}
		return false;
	}

}
