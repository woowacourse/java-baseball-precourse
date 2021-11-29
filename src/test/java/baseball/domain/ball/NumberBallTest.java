package baseball.domain.ball;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import baseball.domain.hint.HintType;

class NumberBallTest {

	@Test
	@DisplayName("숫자 0 은 실패해야 한다.")
	public void testNumberBallZeroFail() throws Exception {
		// given
		int index = 0;
		int number = 0;
		// when
		assertThrows(IllegalArgumentException.class, () -> new NumberBall(index, number));
		// then
	}

	@Test
	@DisplayName("숫자 1 은 성공해야 한다.")
	public void testNumberBallOneSuccess() throws Exception {
		// given
		int index = 0;
		int number = 1;
		// then
		NumberBall numberBall = new NumberBall(index, number);
	}

	@Test
	@DisplayName("숫자 9 는 성공해야 한다.")
	public void testNumberBallNineSuccess() throws Exception {
		// given
		int index = 0;
		int number = 9;
		// then
		NumberBall numberBall = new NumberBall(index, number);
	}

	@Test
	@DisplayName("같은 인덱스와 숫자는 스트라이크를 반환해야 한다.")
	public void testCompareStrike() throws Exception {
		// given
		NumberBall aNumberBall = new NumberBall(0, 3);
		NumberBall bNumberBall = new NumberBall(0, 3);
		// when
		HintType hintType = aNumberBall.compare(bNumberBall);
		// then
		assertEquals(hintType, HintType.STRIKE);
	}

	@Test
	@DisplayName("다른 인덱스와 같은 숫자는 볼을 반환해야 한다.")
	public void testCompareBall() throws Exception {
		// given
		NumberBall aNumberBall = new NumberBall(0, 3);
		NumberBall bNumberBall = new NumberBall(1, 3);
		// when
		HintType hintType = aNumberBall.compare(bNumberBall);
		// then
		assertEquals(hintType, HintType.BALL);
	}

	@Test
	@DisplayName("다른 인덱스와 숫자는 미스를 반환해야 한다.")
	public void testCompareMiss() throws Exception {
		// given
		NumberBall aNumberBall = new NumberBall(0, 3);
		NumberBall bNumberBall = new NumberBall(1, 4);
		// when
		HintType hintType = aNumberBall.compare(bNumberBall);
		// then
		assertEquals(hintType, HintType.MISS);
	}
}
