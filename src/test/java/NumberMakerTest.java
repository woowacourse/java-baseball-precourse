/*
 * NumberMakerTest.java    1.00  2019/03/27
 *
 * copyright by yuyu154
 * All rights reserved.
 */

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * NumberMaker 클래스를 테스트
 */
public class NumberMakerTest {

	/**
	 * makeRandomNumber 함수를 테스트
	 */
	@Test
	public void makeRandomNumber() {
		boolean testFlag = true;
		String randomNumber = NumberMaker.makeRandomNumber();

		if (randomNumber.length() != 3) {
			testFlag = false;
		} else if (randomNumber.contains("0")) {
			testFlag = false;
		}
		System.out.println(randomNumber);
		assertTrue(testFlag);
	}
}