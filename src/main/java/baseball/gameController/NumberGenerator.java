package baseball.gameController;

import java.util.HashSet;

import camp.nextstep.edu.missionutils.Randoms;

public class NumberGenerator {

	private HashSet<Integer> generateNumSet() {
		HashSet<Integer> selectedNum = new HashSet<>();

		while (selectedNum.size() < 3) {
			int randomNum = Randoms.pickNumberInRange(1, 9);
			selectedNum.add(randomNum);
		}
		
		return selectedNum;
	}
}
