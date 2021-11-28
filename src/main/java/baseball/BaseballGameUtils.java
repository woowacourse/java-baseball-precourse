package baseball;

import camp.nextstep.edu.missionutils.*;

public class BaseballGameUtils {

	public BaseballGameUtils() {
		// TODO Auto-generated constructor stub
	}
	
	public static int makeThreeLengthRandomNumber() {
		int number = 0;
		number = Randoms.pickNumberInRange(1, 9) * 100
				+ Randoms.pickNumberInRange(1, 9) * 10
				+ Randoms.pickNumberInRange(1, 9);
		return number;
	}
	
	public static void getNumberFromUser() {
		Console.readLine();
	}
}
