package baseball.domain.hint;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import baseball.domain.ball.NumberBallSet;

class HintTest {

	@Test
	@DisplayName("숫자가 하나도 일치하지 않으면 낫싱을 표시해야 한다")
	public void testHintNothing() throws Exception {
		// given
		NumberBallSet numberBallSetA = NumberBallSet.generateFromInput("123");
		NumberBallSet numberBallSetB = NumberBallSet.generateFromInput("456");
		// when
		Hint hint = Hint.generateHintByComparison(numberBallSetA, numberBallSetB);
		// then
		Assertions.assertFalse(hint.isAnswer());
		Assertions.assertEquals(hint.giveHint(), "낫싱");
	}

	@Test
	@DisplayName("동일한 위치에 같은 숫자는 스트라이크를 표시해야 한다")
	public void testHintStrike() throws Exception {
		// given
		NumberBallSet numberBallSetA = NumberBallSet.generateFromInput("123");
		NumberBallSet numberBallSetB = NumberBallSet.generateFromInput("156");
		// when
		Hint hint = Hint.generateHintByComparison(numberBallSetA, numberBallSetB);
		// then
		Assertions.assertFalse(hint.isAnswer());
		Assertions.assertEquals(hint.giveHint(), "1스트라이크");
	}

	@Test
	@DisplayName("다른 위치에 같은 숫자는 스트라이크를 표시해야 한다")
	public void testHintBall() throws Exception {
		// given
		NumberBallSet numberBallSetA = NumberBallSet.generateFromInput("123");
		NumberBallSet numberBallSetB = NumberBallSet.generateFromInput("451");
		// when
		Hint hint = Hint.generateHintByComparison(numberBallSetA, numberBallSetB);
		// then
		Assertions.assertFalse(hint.isAnswer());
		Assertions.assertEquals(hint.giveHint(), "1볼");
	}

	@Test
	@DisplayName("일부 일치하면 'X볼 X스트라이크'를 출력해야 한다.")
	public void testHintStrikeAndBall() throws Exception {
		// given
		NumberBallSet numberBallSetA = NumberBallSet.generateFromInput("123");
		NumberBallSet numberBallSetB = NumberBallSet.generateFromInput("421");
		// when
		Hint hint = Hint.generateHintByComparison(numberBallSetA, numberBallSetB);
		// then
		Assertions.assertFalse(hint.isAnswer());
		Assertions.assertEquals(hint.giveHint(), "1볼 1스트라이크");
	}

	@Test
	@DisplayName("모든 숫자와 자리가 일치하면 3스트라이크를 표시해야 한다.")
	public void testHintAllStrike() throws Exception {
		// given
		NumberBallSet numberBallSetA = NumberBallSet.generateFromInput("123");
		NumberBallSet numberBallSetB = NumberBallSet.generateFromInput("123");
		// when
		Hint hint = Hint.generateHintByComparison(numberBallSetA, numberBallSetB);
		// then
		Assertions.assertTrue(hint.isAnswer());
		Assertions.assertEquals(hint.giveHint(), "3스트라이크");
	}
}
