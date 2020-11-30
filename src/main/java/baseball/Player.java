package baseball;

import java.util.Scanner;

public class Player {

	int[] playerNum = new int[Constant.NUM_LEN];

	public void getPlayerNum() {
		final Scanner scanner = new Scanner(System.in);

		System.out.print("숫자를 입력해주세요 : ");
		String input = scanner.next();
		if (checkLen(input) && isNum(input)) {
			stringToIntArray(input);
		} else {
			System.out.println("입력하신 수의 형식이 올바르지 않습니다.");
			throw new IllegalArgumentException();
		}

	}

	// 입력값을 int형 배열로 변환
	public void stringToIntArray(String input) {
		String[] temp = input.split("");
		for (int i = 0; i < Constant.NUM_LEN; i++) {
			playerNum[i] = Integer.parseInt(temp[i]);
		}
	}

	// 입력값의 길이가 3인지 검증
	public boolean checkLen(String input) {
		return input.length() == Constant.NUM_LEN;
	}

	// 입력값이 정수값인지, 1-9 범위 내에 있는지 검증
	public boolean isNum(String input) {
		String pattern = "^[1-9]+$";
		if (input.matches(pattern)) {
			return true;
		} else {
			return false;
		}
	}
}
