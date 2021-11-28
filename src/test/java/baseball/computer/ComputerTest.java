package baseball.computer;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;

public class ComputerTest {
	@Test
	void checkTarget() {
		//타겟 넘버 생성
		Computer computer = new Computer();

		//서로 다른 수 확인을 위한 set 자료구조 생성
		Set<Integer> set = new HashSet<>();
		//타켓 넘버들을 set에 넣는다
		for (int number : computer.target) {
			set.add(number);
		}
		// set의 크기가 3인지 확인하여 모두 서로 다른 수 인지 확인
		assertThat(set.size()).isEqualTo(3);

		//타켓 넘버들이 1~9사이의 숫자인지 확인
		Arrays.stream(computer.target).forEach(number -> {
			assertThat(number)
				.isGreaterThanOrEqualTo(1)
				.isLessThanOrEqualTo(9);
		});
	}
}
