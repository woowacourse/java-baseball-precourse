package baseball;

import java.util.List;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Randoms;

/**
 * <h1>야구게임에서 컴퓨터가 사용할 3자리 난수를 생성한다</h1>
 *
 * @author yunki kim
 * @version 2.0
 * @since 2021-11-25(V1.0)
 */

public class RandomNumber {
	/** 생성자에서 n자리 난수 생성에 사용되는 난수 범위 최대값 */
	public static final Integer RANDOM_NUMBER_MAX_RANGE = 9;

	/** 생성자에서 n자리 난수 생성에 사용되는 난수 범위 최소값 */
	public static final Integer RANDOM_NUMBER_MIN_RANGE = 1;

	/** 생성자에서 n자리 난수 생성에 사용되는 값 n */
	public static final Integer RANDOM_NUMBER_SIZE = 3;

	/** 생성자에서 만든 3자리 난수를 문자열로 저장 */
	private String randomNumber;

	/** RandomNumber 인스턴스를 만드는 생성자 */
	public RandomNumber() {
		final List<Integer> randomNumberList = Randoms.pickUniqueNumbersInRange(RANDOM_NUMBER_MIN_RANGE,
			RANDOM_NUMBER_MAX_RANGE, RANDOM_NUMBER_SIZE);
		this.randomNumber = randomNumberList.stream()
			.map(number -> Integer.toString(number))
			.collect(Collectors.joining());
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
