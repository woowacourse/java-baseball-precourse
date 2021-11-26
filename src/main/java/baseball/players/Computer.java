package baseball.players;

import static baseball.utils.Constant.*;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class Computer implements Player {
	private List<Integer> numbers;

	/**
	 * 생성자가 호출될 때 자동으로 숫자 배열을 생성하고
	 * 배열 안에 들어갈 숫자들을 생성한다.
	 */
	public Computer() {
		createNumbers();
	}

	/**
	 * 컴퓨터 플레이어가 가지는 세 자리 수를 생성한다.
	 * 각 자리수의 숫자는 서로 다른 수이며 각 자리수를 ArrayList 에 저장한다.
	 */
	public void createNumbers() {
		numbers = Randoms.pickUniqueNumbersInRange(MIN_NUM, MAX_NUM, LENGTH_OF_NUMBERS);
	}

	@Override
	public int getNumber(int index) {
		return numbers.get(index);
	}

	public int getIndex(int number) {
		return numbers.indexOf(number);
	}
}
