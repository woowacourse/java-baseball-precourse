package baseball.players;

import static baseball.utils.Constant.*;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class ComputerTest {
	@Test
	void 랜덤으로_숫자_생성하고_체크() {
		Computer computer = new Computer();
		ArrayList<Integer> checkList = new ArrayList<>();
		ArrayList<Integer> result = computer.getNumbers();

		assertThat(result.size()).isEqualTo(LENGTH_OF_NUMBERS);
		for (int number : result) {
			assertThat(number).isGreaterThanOrEqualTo(MIN_NUM).isLessThanOrEqualTo(MAX_NUM);
			assertThat(number).isNotIn(checkList);
			checkList.add(number);
		}
	}

}
