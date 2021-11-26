package baseball;

import java.util.Objects;

import camp.nextstep.edu.missionutils.Console;

public class InputManager {

	/**
	 * 게임 플레이어로부터 정답 입력을 받아, int Array를 반환
	 * @return 입력한 값이 담긴 int Array
	 * @throws IllegalArgumentException 3자리가 아니거나, 숫자가 아닌경우
	 */
	public int[] inputGuess() throws IllegalArgumentException {
		String guess = Console.readLine();
		checkLength(guess);
		int[] guessArray = new int[3];
		for (int i = 0; i < guess.length(); i++) {
			guessArray[i] = Integer.parseInt(String.valueOf(guess.charAt(i)));
		}
		return guessArray;
	}

	/**
	 * 게임 플레이어가 입력한 값의 길이가 3인지 체크함.
	 * @param guess 플레이어가 입력한 값
	 */
	public void checkLength(String guess) {
		if (guess.length() != 3) {
			throw new IllegalArgumentException();
		}
	}

	/**
	 * 게임이 종료된 후, 플레이어에게 재시작 의사를 입력받아 해당 값을 정수로 반환함
	 * @return 1혹은 2를 정수로서 반환함
	 * @throws IllegalArgumentException 1혹은 2가 아닐 경우 발생
	 */
	public int inputRestartNum() throws IllegalArgumentException {
		String restartNum = Console.readLine();
		if (!Objects.equals(restartNum, "1") && !Objects.equals(restartNum, "2")) {
			throw new IllegalArgumentException();
		}
		return Integer.parseInt(restartNum);
	}

}
