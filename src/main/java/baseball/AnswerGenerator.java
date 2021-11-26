package baseball;

import baseball.exception.RedundancyException;
import camp.nextstep.edu.missionutils.Randoms;

public class AnswerGenerator {
	/**
	 * 후보가 될 수 있는 정답 array 생성
	 */
	public int[] generateAnswerCandidateArray() {
		int[] answerCandidateArray = new int[3];
		for (int i = 0; i < answerCandidateArray.length; i++) {
			int randomNumber = Randoms.pickNumberInRange(1, 9);
			answerCandidateArray[i] = randomNumber;
		}
		return answerCandidateArray;
	}

	/**
	 * 후보 정답 array에서 중복이 있는지 체크한다.
	 * @param answerCandidateArray 후보 정답 array
	 * @return 아무 이상 없으면 해당 array 반환
	 * @throws RedundancyException 중복이 발견될 경우 해당 Exception throw
	 */
	public int[] checkRedundancy(int[] answerCandidateArray) throws RedundancyException {
		if (answerCandidateArray[0] == answerCandidateArray[1] || answerCandidateArray[0] == answerCandidateArray[2]
			|| answerCandidateArray[1] == answerCandidateArray[2]) {
			throw new RedundancyException();
		} else {
			return answerCandidateArray;
		}
	}

	/**
	 * 게임의 정답으로 사용되는 3자리 숫자가 담긴 array를 생성
	 * @return 정답 숫자 3개가 담긴 array
	 */
	public int[] generateAnswerArray() {
		while (true) {
			try {
				return checkRedundancy(generateAnswerCandidateArray());
			} catch (RedundancyException e) {
				;
			}
		}
	}

}
