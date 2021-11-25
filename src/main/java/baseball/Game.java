package baseball;

import static baseball.Computer.NUMBER_DIGITS;
import static baseball.Valid.*;
import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Game {
	private static final String SUCCESS_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
	private Computer computer;
	private int strike;
	private int ball;

	public Game(Computer computer) {
		this.computer = computer;
		this.strike = 0;
		this.ball = 0;
	}

	public void init() {
		computer.init();
		strike = 0;
		ball = 0;
	}

	public void play() {
		List<Integer> userNumbers;
		while (strike < NUMBER_DIGITS) {
			try {
				System.out.print("숫자를 입력해주세요 : ");
				String userInput = readLine();
				userNumbers = toIntegerList(userInput);
				validateUserNumbers(userNumbers);
			} catch (Exception e) {
				throw new IllegalArgumentException();
			}

			strike = computer.checkStrikeCount(userNumbers);
			ball = computer.checkBallCount(userNumbers);

			printHint();
		}
		printSuccessMessage();
	}

	private List<Integer> toIntegerList(String userInput) {
		String[] splitInput = userInput.split("");
		return Arrays
			.stream(splitInput)
			.map(Integer::parseInt)
			.collect(Collectors.toList());
	}

	private void printHint() {
		if (strike == 0 && ball == 0) {
			System.out.println("낫싱");
			return;
		}
		StringBuilder stringBuilder = new StringBuilder();
		if (ball != 0) {
			stringBuilder.append(ball)
				.append("볼 ");
		}
		if (strike != 0) {
			stringBuilder.append(strike)
				.append("스트라이크");
		}
		System.out.println(stringBuilder.toString());
	}

	private void printSuccessMessage() {
		System.out.println(SUCCESS_MESSAGE);
	}

	private void validateUserNumbers(List<Integer> userNumbers) {
		if (Valid.validateNumbersList(userNumbers) == VALID_FAILED) {
			throw new IllegalArgumentException();
		}
	}
}
