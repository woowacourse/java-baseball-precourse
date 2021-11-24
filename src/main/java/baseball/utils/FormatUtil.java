package baseball.utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FormatUtil {
	public static final String EMPTY_STRING = "";

	public static List<Integer> convert(String value) {
		return Arrays.stream(value.split(EMPTY_STRING)).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());
	}
}
