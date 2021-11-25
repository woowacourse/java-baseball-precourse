package baseball;

import camp.nextstep.edu.missionutils.Randoms;

/**
 * <h1>야구게임에서 컴퓨터가 사용할 3자리 난수를 생성한다</h1>
 *
 * @author yunki kim
 * @version 1.0
 * @since 2021-11-25(V1.0)
 */

public class RandomNumber {
	/** 생성자에서 3자리 난수 생성에 사용되는 난수 범위 최대값 */
	public static final Integer RANDOM_NUMBER_MAX_RANGE = 1000;

	/** 생성자에서 3자리 난수 생성에 사용되는 난수 범위 최소값 */
	public static final Integer RANDOM_NUMBER_MIN_RANGE = 100;

	/** 생성자에서 만든 3자리 난수를 문자열로 저장 */
	private String randomNumber;

	public RandomNumber() {
		this.randomNumber = Integer.toString(
			Randoms.pickNumberInRange(RANDOM_NUMBER_MIN_RANGE, RANDOM_NUMBER_MAX_RANGE)
		);
	}

	/**
	 * 3자리 난수를 반환한다
	 *
	 * @return String String 타임의 3자리 난수
	 */
	public String getRandomNumber() {
		return this.randomNumber;
	}
}
