package baseball;

import java.util.Arrays;

public class Game {
	private String computerNumber;

	/**
	 * 서로 다른 임의의 숫자(1부터 9 사이) 3개를 생성하는 메서드
	 */
	public void setComputerNumber() {
		int current = 3;
		int[] computer = new int[3];
		while (current > 0) {
			int selected = camp.nextstep.edu.missionutils.Randoms.pickNumberInRange(1, 9);

			// 중복된 값이 없다면 해당 숫자 추가
			if (!Arrays.asList(computer).contains(selected)) {
				computer[3 - current] = selected;
				current--;
			}
		}
		computerNumber = Arrays.toString(computer).replaceAll("[^0-9]", "");
	}

}
