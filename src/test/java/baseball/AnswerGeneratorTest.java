package baseball;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import baseball.exception.RedundancyException;

class AnswerGeneratorTest {

	private AnswerGenerator answerGenerator;

	@BeforeEach
	void setup() {
		answerGenerator = new AnswerGenerator();
	}

	@Test
	void 중복검사테스트() throws RedundancyException {
		Assertions.assertThrows(RedundancyException.class, () -> {
			int[] answerArray = {1, 3, 3};
			answerGenerator.checkRedundancy(answerArray);
		});
	}
}