package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class BaseballGame {
	public static final int TARGET_SIZE = 3;
	private List<Integer> target = new ArrayList<>(TARGET_SIZE);

	private void setNewTarget() {
		target = Randoms.pickUniqueNumbersInRange(1, 9, TARGET_SIZE);
	}
}
