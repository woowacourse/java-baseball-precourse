package domain.baseBalls;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import domain.OneBaseBall;
import generator.CustomGameNumbersGenerator;
import generator.RandomGameNumbersGenerator;

class AnswerBaseBallsTest {

	@Test
	@DisplayName("숫자 생성기로 AnswerBaseBalls가 생성되는지 확인")
	void getBaseBallsFromGenerator() {
		List<Integer> numbers = Arrays.asList(1, 3, 5);
		BaseBalls baseBalls = AnswerBaseBalls.ofGenerator(new CustomGameNumbersGenerator(numbers));

		for (int i = 0; i < numbers.size(); i++) {
			OneBaseBall baseBallByPosition = baseBalls.findBaseBallByPosition(i);
			assertThat(baseBallByPosition.getBaseBallPosition()).isEqualTo(i);
			assertThat(baseBallByPosition.getBaseBallNumber().getValue()).isEqualTo(numbers.get(i));
		}

	}

	@Test
	@DisplayName("자동 숫자 생성기로 AnswerBaseBall 만들기")
	void makeAnswerBaseBall() {
		BaseBalls baseBalls = AnswerBaseBalls.ofGenerator(new RandomGameNumbersGenerator());
		assertThat(baseBalls.getSize()).isEqualTo(3);
	}
}