package baseball;

import static baseball.SystemMessage.*;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * 난수와 관련된 일을 책임지는 클래스
 */
public class RandomNumberStringMaker {

	/**
	 * 서로 다른 세개의 난수로 이뤄진 문자열 만드는 메서드
	 *
	 * @return
	 */
	public static String getRandomNumberString() {
		Set<Integer> randomNumberSet = new LinkedHashSet<>();
		StringBuilder stringBuilder = new StringBuilder();

		while (randomNumberSet.size() != GAME_STRING_LENGTH) {
			randomNumberSet.add(Randoms.pickNumberInRange(RANDOM_MIN, RANDOM_MAX));
		}
		randomNumberSet.stream().forEach(number -> stringBuilder.append(number));
		return stringBuilder.toString();
	}
}
