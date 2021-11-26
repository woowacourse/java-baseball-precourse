package baseball;

import java.util.HashSet;

public class Application {
	static int RANDOM_NUMBER_START = 1;
	static int RANDOM_NUMBER_END = 9;
	static int RANDOM_NUMBER_SIZE = 3;

	public static void main(String[] args) {

	}

	public static String generateNumber() {
		HashSet<Integer> numberSet = new HashSet<>();
		String randomNumber = "";
		while (numberSet.size() < RANDOM_NUMBER_SIZE) {
			numberSet.add(
				camp.nextstep.edu.missionutils.Randoms.pickNumberInRange(RANDOM_NUMBER_START, RANDOM_NUMBER_END));
		}
		for (int eachNum : numberSet) {
			randomNumber += eachNum;
		}
		return randomNumber;
	}
}
