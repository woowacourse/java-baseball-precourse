/*
 * NumberValidatorTest.java    1.00  2019/03/27
 *
 * copyright by yuyu154
 * All rights reserved.
 */

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * NumberValidator 클래스 테스트
 */
public class NumberValidatorTest {

	/**
	 * isValidNumbers 함수를 테스트
	 */
	@Test
	public void isValidNumbers() {
		boolean flag = true;
		String[] strArr = {"012", "12", "34", "abc", "3a", ""};

		for (int i = 0; i < strArr.length; i++) {
			System.out.println(strArr[i]);
			flag = NumberValidator.isValidNumbers(strArr[i]);
		}
		assertFalse(flag);
	}
}