package baseball.utils;

import java.util.ArrayList;
import java.util.List;

public class ConversionUtils {
	public static List<Integer> userInputStringToIntegerList(String userInputString) {
		List<Integer> userInputDigitList = new ArrayList<>();
		for (int i = 0; i < userInputString.length(); i++) {
			int userInputNumber = Character.getNumericValue(userInputString.charAt(i));
			userInputDigitList.add(userInputNumber);
		}
		return userInputDigitList;
	}
}
