package baseball.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class BaseballNumsGeneratorTest {

	@Test
	public void 랜덤한_3자리_숫자_생성() {
		// given // when
		BaseballNums randomBaseballNums = BaseballNumsGenerator.generateRandomBaseballNums();

		// then
		assertEquals(3, randomBaseballNums.getBaseballNums().size());
	}

	@ParameterizedTest
	@ValueSource(strings = {"123", "234", "426", "326"})
	public void 입력한_3자리_숫자_생성_테스트(String inputNum) {
		// given // when
		BaseballNums inputBaseballNums = BaseballNumsGenerator.generateInputBaseballNums(inputNum);
		// then
		assertEquals(3, inputBaseballNums.getBaseballNums().size());
	}

	@ParameterizedTest
	@ValueSource(strings = {"122", "1234", "111", "xfe", "ㄹㄷㄹ", "$$%@"})
	public void 입력한_3자리_숫자_유효성_테스트(String inputNum) {
		assertThrows(IllegalArgumentException.class, () -> {
			BaseballNumsGenerator.generateInputBaseballNums(inputNum);
		});
	}
}