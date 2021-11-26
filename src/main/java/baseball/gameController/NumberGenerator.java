package baseball.gameController;

import java.util.LinkedHashSet;

import camp.nextstep.edu.missionutils.Randoms;

public class NumberGenerator {

	public LinkedHashSet<Integer> generateNumSet() {
		LinkedHashSet<Integer> selectedNum = new LinkedHashSet<>();

		while (selectedNum.size() < 3) {
			int randomNum = Randoms.pickNumberInRange(1, 9);
			selectedNum.add(randomNum);
		}
		return selectedNum;
	}
}
