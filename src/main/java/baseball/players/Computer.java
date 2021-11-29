package baseball.players;

import static baseball.utils.Constant.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import camp.nextstep.edu.missionutils.Randoms;

public class Computer implements Player {
	private List<Integer> numbers;

	/**
	 * 컴퓨터 플레이어가 가지는 세 자리 수를 생성한다.
	 * 각 자리수의 숫자는 서로 다른 수이며 각 자리수를 ArrayList 에 저장한다.
	 */
	public void createNumbers() {
		Set<Integer> set = new HashSet<>();
		while (set.size() < LENGTH_OF_NUMBERS) {
			set.add(Randoms.pickNumberInRange(MIN_NUM, MAX_NUM));
		}
		numbers = new ArrayList<>(set);
		Collections.shuffle(numbers);
	}

	@Override
	public int getNumber(int index) {
		return numbers.get(index);
	}

	public int getIndex(int number) {
		return numbers.indexOf(number);
	}
}
