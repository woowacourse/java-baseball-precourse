package utils;

import java.util.HashSet;
import java.util.Set;

/**
 * 생성된 난수에 중복된 숫자가 있는지 검사하는 클래스
 */
public class CheckDuplicate {

	final static int TRUE_SIZE = 3;
	final static int START_NUMBER = 100;
	final static int END_NUMBER = 999;

	public String makeRandomNumber() {
		int randomNumber = RandomUtils.nextInt(START_NUMBER, END_NUMBER);
		if(isDuplicate(randomNumber)) {
			return makeRandomNumber();
		}
		return String.valueOf(randomNumber);
	}

	private boolean isDuplicate(int randomNum) {
		Set<Integer> set = new HashSet<>();

		for(int i=0; i<TRUE_SIZE; i++) {
			set.add(randomNum % 10);
			randomNum /= 10;
		}
		return !(isLengthThree(set));
	}

	private boolean isLengthThree(Set<Integer> set){
		return (set.size()==TRUE_SIZE);
	}
}
