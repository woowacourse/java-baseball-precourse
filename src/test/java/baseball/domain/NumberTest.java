package baseball.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import baseball.application.domain.number.Number;

class NumberTest {

	@ParameterizedTest
	@CsvSource({"123,456,0", "321,132,3", "123,345,1"})
	void 두_숫자의_볼_카운트를_셀_수_있다(String given1, String given2, int expected) {
		// given
		Number givenNumber1 = new Number(given1);
		Number givenNumber2 = new Number(given2);

		// when
		int countBall = givenNumber1.countBall(givenNumber2);

		// then
		assertEquals(expected, countBall);
	}

	@ParameterizedTest
	@CsvSource({"123,123,3", "123,132,1", "123,456,0"})
	void 두_숫자의_스트라이크_카운트를_셀_수_있다(String given1, String given2, int expected) {
		// given
		Number givenNumber1 = new Number(given1);
		Number givenNumber2 = new Number(given2);

		// when
		int countStrike = givenNumber1.countStrike(givenNumber2);

		// then
		assertEquals(expected, countStrike);
	}

}