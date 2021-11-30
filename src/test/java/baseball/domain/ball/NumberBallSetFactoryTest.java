package baseball.domain.ball;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NumberBallSetFactoryTest {

	@Test
	@DisplayName("랜덤 숫자의 개수는 3개여야 한다.")
	public void testRandomGeneratedNumberBallLength() throws Exception {
		// given
		int count = NumberBallSet.NUMBER_COUNT;

		// when
		List<Integer> numbers = NumberBallSetFactory.generateNumbersFromRandom();

		// then
		Assertions.assertThat(numbers.size()).isEqualTo(count);
	}
}
