package baseball.computer;

import static baseball.Constants.*;
import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;

public class ComputerTest {
	@Test
	void checkTarget() {
		// 타겟 넘버 생성
		Computer computer = new Computer();

		// 서로 다른 수 확인을 위한 set 자료구조 생성
		Set<Integer> set = new HashSet<>();
		//타켓 넘버들을 set에 넣는다
		for (int number : computer.target) {
			set.add(number);
		}
		// 테스트 진행
		checkDuplicates(set);
		checkNumRange(computer.target, set);
	}

	// set의 크기가 3인지 확인하여 모두 서로 다른 수 인지 확인
	void checkDuplicates(Set<Integer> set) {
		assertThat(set.size()).isEqualTo(maxNumberLen);
	}

	//타켓 넘버들이 1~9사이의 숫자인지 확인
	void checkNumRange(int[] target, Set<Integer> set) {
		Arrays.stream(target).forEach(number -> {
			assertThat(number)
				.isGreaterThanOrEqualTo(1)
				.isLessThanOrEqualTo(9);
		});
	}

}
