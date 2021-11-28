package baseball.computer;

import static baseball.Constants.*;
import static camp.nextstep.edu.missionutils.Randoms.*;

import java.util.LinkedHashSet;

public class Computer {
	// 맞춰야 할 숫자
	public int[] target;

	// Computer 인스턴스 생성시 target 만들어짐
	public Computer() {

		LinkedHashSet<Integer> targetSet = makeTargetSet();
		target = toIntArray(targetSet);

	}

	private LinkedHashSet<Integer> makeTargetSet() {
		LinkedHashSet<Integer> targetSet = new LinkedHashSet<>();
		while (targetSet.size() < maxNumberLen) {
			targetSet.add(pickNumberInRange(1, 9));
		}
		return targetSet;
	}

	private int[] toIntArray(LinkedHashSet<Integer> targetSet) {
		int[] array = new int[maxNumberLen];
		Object[] objects = targetSet.toArray();

		for (int i = 0; i < maxNumberLen; i++) {
			array[i] = (int)objects[i];
		}

		return array;
	}
}
