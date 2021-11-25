package baseball.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RefereeTest {
	@Test
	public void check() throws Exception {
		//given
		Referee referee1 = new Referee(new int[] {1, 2, 3}, new int[] {1, 3, 2});
		Referee referee2 = new Referee(new int[] {1, 2, 3}, new int[] {4, 5, 6});
		//when
		Result result1 = referee1.check();
		Result result2 = referee2.check();
		//then
		assertEquals(result1.getStrikeCount(), 1);
		assertEquals(result1.getBallCount(), 2);

		assertEquals(result2.getStrikeCount(), 0);
		assertEquals(result2.getBallCount(), 0);
	}
}
