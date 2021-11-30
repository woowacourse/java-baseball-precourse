package baseball;

import org.junit.jupiter.api.Test;

import camp.nextstep.edu.missionutils.test.NsTest;
import controller.classes.BaseBallAnswer;

public class CalculateTest extends NsTest {
	@Override
	protected void runMain() {
		Application.main(new String[] {});
	}

	@Test
	void countTest() {
		BaseBallAnswer baseBallAnswer = new BaseBallAnswer();
		baseBallAnswer.makeAnswer();
		baseBallAnswer.calculateStatus("123");
	}

	@Test
	void ordinalTest() {

	}
}
