package baseball;

import java.util.HashSet;
import java.util.LinkedHashSet;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Game {

	public static final String ENTER_NUMBER = "숫자를 입력해주세요 : ";
	public static final String ASK_RESTART = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
	public static final String FINISH_GAME = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
	private static final int NUMBER_LENGTH = 3;
	private static final String INPUT_CHECK_REGEX = "[1-9][1-9][1-9]";
	private static final String RESTART_CHECK_REGEX = "[1-2]";
	private static final String WANT_RESTART = "1";
	private String randomNumber;
	private String userNumber;
	private boolean isFinish;

	public void init() {
		isFinish = false;
		LinkedHashSet<Integer> hashSet = new LinkedHashSet<>();

		while (hashSet.size() < NUMBER_LENGTH) {
			int pickedNumber = Randoms.pickNumberInRange(1, 9);
			hashSet.add(pickedNumber);
		}

		StringBuilder stringBuilder = new StringBuilder();
		for (Integer number : hashSet) {
			stringBuilder.append(number);
		}

		randomNumber = stringBuilder.toString();
	}

	public void play() {
		while (!isFinish) {
			takeInput();
			Result result = compareNumber();
			result.createMessage();
			result.printMessage();
			isFinish = result.isFinish(NUMBER_LENGTH);
		}

		printEndMessage();
		boolean isContinue = askRestart();
		if (isContinue) {
			init();
			play();
		}
	}

	public boolean askRestart() {
		System.out.println(ASK_RESTART);

		String input = Console.readLine();
		if (!input.matches(RESTART_CHECK_REGEX)) {
			throw new IllegalArgumentException();
		}

		return input.equals(WANT_RESTART);
	}

	private void takeInput() {
		System.out.print(ENTER_NUMBER);

		String input = Console.readLine();
		if (!isValid(input)) {
			throw new IllegalArgumentException();
		}

		userNumber = input;
	}

	private boolean isValid(String input) {
		if (!input.matches(INPUT_CHECK_REGEX)) {
			return false;
		}

		HashSet<Integer> hashSet = new HashSet<>();
		for (int i = 0; i < NUMBER_LENGTH; i++) {
			hashSet.add(input.charAt(i) - '0');
		}

		return hashSet.size() == NUMBER_LENGTH;
	}

	private Result compareNumber() {
		Result result = new Result();

		HashSet<Integer> hashSet = new HashSet<>();
		for (int i = 0; i < NUMBER_LENGTH; i++) {
			int currentUserNumber = userNumber.charAt(i) - '0';
			int currentRandomNumber = randomNumber.charAt(i) - '0';

			if (currentUserNumber == currentRandomNumber) {
				result.addStrikeCount();
				continue;
			}

			hashSet.add(currentUserNumber);
		}

		for (int i = 0; i < NUMBER_LENGTH; i++) {
			int currentRandomNumber = randomNumber.charAt(i) - '0';
			if (hashSet.contains(currentRandomNumber)) {
				result.addBallCount();
			}
		}

		return result;
	}

	public void printEndMessage() {
		System.out.println(FINISH_GAME);
	}
}
