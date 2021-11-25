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

}