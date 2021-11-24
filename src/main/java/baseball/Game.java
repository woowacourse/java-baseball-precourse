package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Game {
	private Computer computer;
	private int strike;
	private int ball;

	public Game(Computer computer) {
		this.computer = computer;
		this.strike = 0;
		this.ball = 0;
	}

	public void play() {
		System.out.print("숫자를 입력해주세요 : ");
		String userInputMessage = readLine();
		List<Integer> userNumbers = toIntegerList(userInputMessage);
	}

	public List<Integer> toIntegerList(String input) {
		String[] splitInput = input.split("");
		List<Integer> integerList = Arrays
			.stream(splitInput)
			.map(Integer::parseInt)
			.collect(Collectors.toList());
		return integerList;
	}
}
