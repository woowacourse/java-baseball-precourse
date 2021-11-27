package baseball;

import static camp.nextstep.edu.missionutils.Randoms.*;

import java.util.Arrays;

/**
 * <h1>야구게임에서 컴퓨터가 사용할 3자리 난수를 생성한다</h1>
 *
 * @author yunki kim
 * @version 3.0
 * @since 2021-11-25(V1.0)
 */

public class RandomNumber {
	/** 생성자에서 3자리 난수 생성에 사용되는 난수 범위 최대값 */
	public static final Integer RANDOM_NUMBER_MAX_RANGE = 9;

	/** 생성자에서 3자리 난수 생성에 사용되는 난수 범위 최소값 */
	public static final Integer RANDOM_NUMBER_MIN_RANGE = 1;

	/** 생성자에서 만든 3자리 난수를 문자열로 저장 */
	private String randomNumber;

	/**
	 * 3자리 난수를 만들어 반환한다
	 *
	 * @return String 만들어진 3자리 난수
	 */
	private String makeRandomNumber() {
		Boolean[] usedNumber = new Boolean[11];
		Arrays.fill(usedNumber, false);
		String randomNumber = "";
		while(randomNumber.length() < 3) {
			int tempNumber =
				pickNumberInRange(RANDOM_NUMBER_MIN_RANGE, RANDOM_NUMBER_MAX_RANGE);
			if(usedNumber[tempNumber]) {
				continue;
			}
			usedNumber[tempNumber] = true;
			randomNumber = randomNumber.concat(Integer.toString(tempNumber));
		}
		return randomNumber;
	}

	/** RandomNumber 인스턴스를 만드는 생성자 */
	public RandomNumber() {
		this.randomNumber = makeRandomNumber();
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
