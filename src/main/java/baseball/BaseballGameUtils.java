package baseball;

import camp.nextstep.edu.missionutils.*;

public class BaseballGameUtils {

	public BaseballGameUtils() {
		// TODO Auto-generated constructor stub
	}
	
	public static String makeThreeLengthRandomNumber() {
		int number = 0;
		number = Randoms.pickNumberInRange(1, 9) * 100
				+ Randoms.pickNumberInRange(1, 9) * 10
				+ Randoms.pickNumberInRange(1, 9);
		return Integer.toString(number);
	}
	
	public static String getNumberFromUser() {
		System.out.print("숫자를 입력해주세요 : "); //수정
		String number = Console.readLine();
		validateUserNumber(number);
		return number;
	}
	
	private static void validateUserNumber(String number) {
		if (number.length()!=3) {
			throw new IllegalArgumentException("세자리 숫자가 아닙니다.");
		}
		
		for (int i = 0; i < number.length(); i++) {
			char compareChar = number.charAt(i);
			if (!Character.isDigit(compareChar)) {
				throw new IllegalArgumentException("숫자가 아닙니다. 숫자외 문자가 포함되어있습니다.");
			}
			if (compareChar == '0') {
				throw new IllegalArgumentException("1~9사이의 숫자가 아닌 값이 표함되어 있습니다.");
			}
		}
	}
}
