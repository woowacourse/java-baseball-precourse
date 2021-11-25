package baseball;

import java.util.ArrayList;

import camp.nextstep.edu.missionutils.Randoms;

public class Number {
	private ArrayList<Integer> number;

	public ArrayList<Integer> getNumber() {
		return number;
	}

	public void setNumber(ArrayList<Integer> playerNumber) {
		this.number = playerNumber;
	}

	// 임의의 수 3개 생성
	public static ArrayList<Integer> createRandomNumbers() {
		ArrayList<Integer> result = new ArrayList<>();
		int temp;

		for (int i = 0; i < 3; i++) {
			temp = Randoms.pickNumberInRange(1, 9);

			if (!result.contains(temp))
				result.add(temp);
			else
				i--;
		}
		return result;
	}

	//사용자로부터 입력받은 수 처리
	public static ArrayList<Integer> splitNumber(Integer playerNumber) {
		ArrayList<Integer> splitPlayerNumber = new ArrayList<>();
		for (int i = 0; i < 3; i++) {
			splitPlayerNumber.add(0, playerNumber % 10);
			playerNumber /= 10;
		}
		return splitPlayerNumber;
	}

	public static void inputCheck(Integer number) {
		is_Not_ThreeDigits(number);
		is_Contain_Zero(number);
		is_Overlap(splitNumber(number));
	}

	public static void is_Not_ThreeDigits(Integer number) {
		if (number.toString().length() != 3)
			throw new IllegalArgumentException("올바른 입력이 아닙니다!");
	}

	public static void is_Contain_Zero(Integer number) {
		if (String.valueOf(number).contains("0"))
			throw new IllegalArgumentException("올바른 입력이 아닙니다!");
	}

	public static void is_Overlap(ArrayList<Integer> number) {
		ArrayList<Integer> temp = new ArrayList<>();

		for (int i = 0; i < 3; i++) {
			if (temp.contains(number.get(i)))
				throw new IllegalArgumentException("올바른 입력이 아닙니다!");
			temp.add(number.get(i));
		}
	}

}