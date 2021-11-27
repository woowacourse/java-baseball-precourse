package baseball.gameController;

import java.util.LinkedHashSet;

import baseball.constantStorage.Constant;
import camp.nextstep.edu.missionutils.Randoms;

public class NumberGenerator {

	public static LinkedHashSet<Integer> generateNumSet() {
		LinkedHashSet<Integer> selectedNum = new LinkedHashSet<>();

		while (selectedNum.size() < Constant.NUMBER_LENGTH) {
			int randomNum = Randoms.pickNumberInRange(Constant.MIN_NUMBER, Constant.MAX_NUMBER);
			selectedNum.add(randomNum);
		}
		return selectedNum;
	}
}
