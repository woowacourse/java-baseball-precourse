package domain;

import static org.assertj.core.api.AssertionsForInterfaceTypes.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("baseBall 집합에 대한 테스트")
class BaseBallsTest {

	@Test
	@DisplayName("BaseBall을 List<Integer>에 따라서 생성한다. Number 같은지 테스트")
	void number() {
		List<Integer> numbers = Arrays.asList(9, 7, 3);
		List<OneBaseBall> baseBalls = new BaseBalls(numbers).getBaseBalls();

		for (int i = 0; i < numbers.size(); i++) {
			Integer baseBallValue = baseBalls.get(i).getBaseBallNumber().getValue();
			assertThat(baseBallValue).isEqualTo(numbers.get(i));
		}
	}

	@Test
	@DisplayName("BaseBall을 List<Integer>에 따라서 생성한다. Position 같은지 테스트")
	void position() {
		List<Integer> numbers = Arrays.asList(9, 7, 3);
		List<OneBaseBall> baseBalls = new BaseBalls(numbers).getBaseBalls();

		for (int i = 0; i < numbers.size(); i++) {
			assertThat(baseBalls.get(i).getBaseBallPosition()).isEqualTo(i);
		}
	}

	@Test
	@DisplayName("position에 따라 OneBaseBall 리턴하기")
	void findBaseBallByPosition() {
		List<Integer> numbers = Arrays.asList(9, 7, 3);
		BaseBalls baseBalls = new BaseBalls(numbers);

		for (int i = 0; i < numbers.size(); i++) {
			OneBaseBall baseBallByPosition = baseBalls.findBaseBallByPosition(i);
			assertThat(baseBallByPosition.getBaseBallPosition()).isEqualTo(i);
			assertThat(baseBallByPosition.getBaseBallNumber().getValue()).isEqualTo(numbers.get(i));
		}

	}
}