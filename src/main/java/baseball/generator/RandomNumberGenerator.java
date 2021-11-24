package baseball.generator;

import java.util.ArrayList;
import camp.nextstep.edu.missionutils.Randoms;

/**
 * 1에서 9까지 서로 다른 임의의 수 3개를 생성하는 클래스
 */
public class RandomNumberGenerator {

	private static final Integer MINIMUM_INDEX = 0;
	private static final Integer MAXIMUM_INDEX = 9;
	private static final Integer INITIAL_VALUE = 0;
	private static final Integer FLAG_SIZE = 10;
	private static final Integer RANDOM_NUMBER_SIZE = 3;
	private static final Integer START_RANDOM_VALUE = 1;
	private static final Integer END_RANDOM_VALUE = 9;
	private static final Integer USED_VALUE_CHECK = 1;
	private static final int[] duplicateNumberFlag = new int[FLAG_SIZE];

	/**
	 * 중복확인을 위한 flag 배열을 초기화하는 함수
	 */
	public static void initNumberFlag() {
		for (int i = MINIMUM_INDEX; i <= MAXIMUM_INDEX; i++) {
			duplicateNumberFlag[i] = INITIAL_VALUE;
		}
	}

	/**
	 * 1에서 9까지 서로 다른 임의의 수 3개를 만드는 함수
	 *
	 * @return AnswerNumber
	 */
	public static ArrayList<Integer> generateRandomNumber() {
		ArrayList<Integer> AnswerNumber = new ArrayList<>();

		while (AnswerNumber.size() < RANDOM_NUMBER_SIZE) {
			int randomNumber = Randoms.pickNumberInRange(START_RANDOM_VALUE,
				END_RANDOM_VALUE);
			if (duplicateNumberCheck(randomNumber)) {
				continue;
			} else if (!duplicateNumberCheck(randomNumber)) {
				AnswerNumber.add(randomNumber);
			}
		}
		return AnswerNumber;
	}

	/**
	 * 랜덤값의 중복을 확인하는 함수
	 *
	 * @param randomNumber: Integer
	 * @return true or false
	 */
	public static boolean duplicateNumberCheck(Integer randomNumber) {
		int index = randomNumber - 1;
		initNumberFlag();
		if (duplicateNumberFlag[index] == INITIAL_VALUE) {
			duplicateNumberFlag[index] = USED_VALUE_CHECK;
			return false;
		} else {
			return true;
		}
	}
}
