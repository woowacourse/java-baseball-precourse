package baseball.generator;

import java.util.ArrayList;
import camp.nextstep.edu.missionutils.Randoms;

/**
 * 1에서 9까지 서로 다른 임의의 수 3개를 생성하는 클래스
 */
public class RandomNumberGenerator {

	private static final int MINIMUM_INDEX = 0;
	private static final int MAXIMUM_INDEX = 9;
	private static final int INITIAL_VALUE = 0;
	private static final int FLAG_SIZE = 10;
	private static final int RANDOM_NUMBER_SIZE = 3;
	private static final int START_RANDOM_VALUE = 1;
	private static final int END_RANDOM_VALUE = 9;
	private static final int USED_VALUE_CHECK = 1;
	private static int[] duplicateNumberFlag = new int[FLAG_SIZE];
	private static ArrayList<Integer> answerNumber = new ArrayList<>();

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
		initNumberFlag();

		while (answerNumber.size() < RANDOM_NUMBER_SIZE) {
			int randomNumber = Randoms.pickNumberInRange(START_RANDOM_VALUE, END_RANDOM_VALUE);
			duplicateNumberCheck(randomNumber);
		}
		return answerNumber;
	}

	/**
	 * 랜덤값의 중복을 확인하는 함수
	 *
	 * @param randomNumber: int
	 */
	public static void duplicateNumberCheck(int randomNumber) {
		int index = randomNumber - 1;
		if (duplicateNumberFlag[index] == INITIAL_VALUE) {
			duplicateNumberFlag[index] = USED_VALUE_CHECK;
			answerNumber.add(randomNumber);
		}
	}

	/**
	 * 게임 재시작을 위해 정해진 랜덤값을 초기화시키는 함수
	 *
	 * @param answerNumber: ArrayList<Integer>
	 */
	public static void initProgramNumber(ArrayList<Integer> answerNumber) {
		if (!answerNumber.isEmpty()) {
			answerNumber.clear();
		}
	}
}
