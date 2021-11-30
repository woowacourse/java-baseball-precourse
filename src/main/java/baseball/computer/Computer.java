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

	// 맞춰야할 숫자를 만든다
	private LinkedHashSet<Integer> makeTargetSet() {
		LinkedHashSet<Integer> targetSet = new LinkedHashSet<>();
		
		// set의 크기가 3일때까지 반복ㅎ서 set에 숫자를 넣어준다
		while (targetSet.size() < maxNumberLen) {
			targetSet.add(pickNumberInRange(1, 9));
		}
		return targetSet;
	}

	// set을 배열로 바꿔준다
	private int[] toIntArray(LinkedHashSet<Integer> targetSet) {
		int[] array = new int[maxNumberLen];
		Object[] objects = targetSet.toArray();

		for (int i = 0; i < maxNumberLen; i++) {
			array[i] = (int)objects[i];
		}

		return array;
	}
}
