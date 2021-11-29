package baseball.domain.ball;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import baseball.domain.hint.HintType;

class NumberBallSetTest {

	@Test
	@DisplayName("일치하는 것이 없으면 스트라이크 0, 볼 0, 미스 3 이다.")
	public void testCompareNothing() throws Exception {
		// given
		NumberBallSet aNumberBallSet = NumberBallSet.generateFromInput("123");
		NumberBallSet bNumberBallSet = NumberBallSet.generateFromInput("456");

		// when
		Map<HintType, Integer> compareMap = aNumberBallSet.compare(bNumberBallSet);
		// then
		assertEquals(compareMap.get(HintType.MISS), 3);
	}

	@Test
	@DisplayName("일부 일치하면 X 볼, X 스트라이크이다.")
	public void testComparePartiallyCorrect() throws Exception {
		// given
		NumberBallSet aNumberBallSet = NumberBallSet.generateFromInput("123");
		NumberBallSet bNumberBallSet = NumberBallSet.generateFromInput("152");

		// when
		Map<HintType, Integer> compareMap = aNumberBallSet.compare(bNumberBallSet);
		// then
		assertEquals(compareMap.get(HintType.STRIKE), 1);
		assertEquals(compareMap.get(HintType.BALL), 1);
	}

	@Test
	@DisplayName("모두 일치하면 3 스트라이크이다.")
	public void testCompareAllCorrect() throws Exception {
		// given
		NumberBallSet aNumberBallSet = NumberBallSet.generateFromInput("123");
		NumberBallSet bNumberBallSet = NumberBallSet.generateFromInput("123");

		// when
		Map<HintType, Integer> compareMap = aNumberBallSet.compare(bNumberBallSet);
		// then
		assertEquals(compareMap.get(HintType.STRIKE), 3);
	}
}
