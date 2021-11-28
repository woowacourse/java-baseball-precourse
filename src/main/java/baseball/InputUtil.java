package baseball;

import static camp.nextstep.edu.missionutils.Console.*;
import static java.util.stream.Collectors.*;

import java.util.Arrays;
import java.util.List;

public class InputUtil {

	private InputUtil() {
	}

	public static int readInt() {
		try {
			return Integer.parseInt(readLine());
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("숫자를 입력해야 합니다.");
		}
	}

	public static List<Integer> readIntList() {
		try {
			return parseIntList(readLine());
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("숫자를 입력해야 합니다.");
		}
	}

	private static List<Integer> parseIntList(String input) {
		return Arrays.stream(input.split(""))
			.map(Integer::valueOf)
			.collect(toList());
	}
}
