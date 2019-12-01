package domain.baseBalls;

import static org.assertj.core.api.AssertionsForInterfaceTypes.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import domain.OneBaseBall;
import generator.CustomGameNumbersGenerator;

@DisplayName("QuestionBaseBall 집합에 대한 테스트")
class QuestionBaseBallsTest {

	@Test
	@DisplayName("BaseBall을 List<Integer>에 따라서 생성한다. Number 같은지 테스트")
	void number() {
		List<Integer> numbers = Arrays.asList(9, 7, 3);
		List<OneBaseBall> baseBalls = QuestionBaseBalls.ofManual(numbers).getBaseBalls();

		for (int i = 0; i < numbers.size(); i++) {
			Integer baseBallValue = baseBalls.get(i).getBaseBallNumber().getValue();
			assertThat(baseBallValue).isEqualTo(numbers.get(i));
		}
	}

	@Test
	@DisplayName("BaseBall을 List<Integer>에 따라서 생성한다. Position 같은지 테스트")
	void position() {
		List<Integer> numbers = Arrays.asList(9, 7, 3);
		List<OneBaseBall> baseBalls = QuestionBaseBalls.ofManual(numbers).getBaseBalls();

		for (int i = 0; i < numbers.size(); i++) {
			assertThat(baseBalls.get(i).getBaseBallPosition()).isEqualTo(i);
		}
	}

	@Test
	@DisplayName("baseBalls 정답 여부 확인하기")
	void findBaseBallByPosition() {
		AnswerBaseBalls answer = AnswerBaseBalls.ofGenerator(new CustomGameNumbersGenerator(Arrays.asList(9, 7, 4)));

		QuestionBaseBalls question1 = QuestionBaseBalls.ofManual(Arrays.asList(9, 7, 3));
		QuestionBaseBalls question2 = QuestionBaseBalls.ofManual(Arrays.asList(4, 7, 3));
		QuestionBaseBalls question3 = QuestionBaseBalls.ofManual(Arrays.asList(1, 2, 3));

		QuestionBaseBalls.ResultQuestion calculateResult = question1.getCalculateResult(answer);
		QuestionBaseBalls.ResultQuestion calculateResult1 = question2.getCalculateResult(answer);
		QuestionBaseBalls.ResultQuestion calculateResult2 = question3.getCalculateResult(answer);

		assertThat(calculateResult.getBall()).isEqualTo(0);
		assertThat(calculateResult.getStrike()).isEqualTo(2);
		assertThat(calculateResult1.getBall()).isEqualTo(1);
		assertThat(calculateResult1.getStrike()).isEqualTo(1);
		assertThat(calculateResult2.getBall()).isEqualTo(0);
		assertThat(calculateResult2.getStrike()).isEqualTo(0);

	}

}