package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

public class Application {
	public static void main(String[] args) {
		//TODO: 숫자 야구 게임 구현

		// 게임 시작
		// Game game = new Game(createRandomNumberList());
		// while (game.isPlay()) {
		// 	// 사용자 입력
		// 	View.input();
		// 	String input = Console.readLine();
		// 	Balls user = new Balls(convertStringToNumberList(input));
		// 	// 힌트 출력
		// 	Hint hint = new Hint(game.getComputer(), user);
		// 	View.hint(hint);
		// 	// 힌트에 따라 게임 진행
		// 	if (!game.checkhint(hint)) {
		// 		continue;
		// 	}
		// 	View.success();
		// 	game.choicePlay(Console.readLine());
		// }
	}

	public static List<Integer> createRandomNumberList() {
		LinkedHashSet<Integer> numberSet = new LinkedHashSet<>();
		while (numberSet.size() < Balls.SIZE) {
			numberSet.add(Randoms.pickNumberInRange(Ball.MIN_VALUE, Ball.MAX_VALUE));
		}
		return new ArrayList<>(numberSet);
	}

	public static List<Integer> convertStringToNumberList(String input) {
		validateNumbers(input);
		List<Integer> result = new ArrayList<>();
		for (int i = 0; i < input.length(); i++) {
			result.add(input.charAt(i) - '0');
		}
		return result;
	}

	public static void validateNumbers(String input) {
		for (int i = 0; i < input.length(); i++) {
			validateNumber(input.charAt(i));
		}
	}

	public static void validateNumber(char c) {
		if (!(Character.isDigit(c))) {
			throw new IllegalArgumentException();
		}
	}
}