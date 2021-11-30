package baseball;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Console;

public class Player {

	private static List<Integer> inputNumbers;

	public static List<Integer> getNumber() {
		System.out.println("숫자를 입력해주세요 : ");
		String inputNumber = Console.readLine();
		inputNumbers = convertStringToIntegerList(inputNumber);
		return inputNumbers;
	}

	private static List<Integer> convertStringToIntegerList(String number) {
		return Arrays.stream(number.split(""))
			.map(Integer::parseInt)
			.collect(Collectors.toList());
	}
}
