package baseball;

import java.util.HashSet;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator {

	public String makeRandomNumber() {
		String answer = "";

		// 중복되는 숫자 제거를 위한 HashSet
		HashSet<Integer> set = new HashSet<>();

		// set 의 사이즈가 3이 될때 까지 무작위 숫자를 뽑아 준다
		while (set.size() != 3) {
			int number = Randoms.pickNumberInRange(1, 9);
			set.add(number);
		}

		// set 의 숫자를 하나의 문자열로 만들어주기
		StringBuilder sb = new StringBuilder();
		for (int i : set) {
			sb.append(String.valueOf(i));
		}

		answer = sb.toString();
		return answer;
	}
}
