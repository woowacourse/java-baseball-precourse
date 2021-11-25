package baseball.util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DupCheckerTest {
	@Test
	public void checkDupSuccessCase() throws Exception {
		//given
		DupChecker dupChecker = new DupChecker();
		//when
		int[] target = {1, 2, 3};
		//then
		for (int n : target) {
			assertTrue(dupChecker.check(n));
		}
	}

	@Test
	public void checkDupFailCase() throws Exception {
		//given
		DupChecker dupChecker = new DupChecker();
		//when
		int[] target = {1, 3, 3};
		//then
		for (int n : target) {
			if(!dupChecker.check(n)){
				return;
			}
		}

		Assertions.fail();
	}
}
