package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Player {
	public List<Integer> getPlayerInputNum() {
		System.out.print("숫자를 입력하세요: ");
		String playerInput = Console.readLine();
		validateLength(playerInput);
		validateDupNumber(playerInput);
		return Arrays.stream(playerInput.split("")).map(Integer::parseInt).collect(Collectors.toList());
	}

	public boolean wantRestart() {
		System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
		int restartFlag = Integer.parseInt(Console.readLine());
		validateRestartFlag(restartFlag);
		return restartFlag == 1;
	}

	private void validateRestartFlag(int restartFlag) {
		if (restartFlag != 1 && restartFlag != 2) {
			throw new IllegalArgumentException("restart flag must be 1 or 2");
		}
	}

	private void validateLength(String playerInput) {
		if (playerInput.length() != 3) {
			throw new IllegalArgumentException("length of player input must be 3");
		}
	}

	private void validateDupNumber(String playerInput) {
		if (playerInput.charAt(0) == playerInput.charAt(1)) {
			throw new IllegalArgumentException("player input must be different each other");
		} else if (playerInput.charAt(0) == playerInput.charAt(2)) {
			throw new IllegalArgumentException("player input must be different each other");
		} else if (playerInput.charAt(1) == playerInput.charAt(2)) {
			throw new IllegalArgumentException("player input must be different each other");
		}
	}
}
