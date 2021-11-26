package baseball.utils;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ConversionUtils {
	public static List<Integer> userInputStringToIntegerList(String userInputString) {
		return IntStream.range(0, userInputString.length())
			.map(i -> Character.getNumericValue(userInputString.charAt(i)))
			.boxed()
			.collect(Collectors.toList());
	}
}
