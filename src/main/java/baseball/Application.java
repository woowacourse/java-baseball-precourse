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
		Game game = new Game(createRandomNumberList());
		while (game.isPlay()) {
			// 사용자 입력
			View.input();
			Balls user = new Balls(toNumberList(Console.readLine()));
			// 힌트 출력
			Hint hint = game.compare(user);
			View.hint(hint);
			// 힌트에 따라 게임 진행
			if (hint.strike() != Balls.SIZE) {
				continue;
			}
			// 게임 진행 여부 결정
			View.success();
			game.choicePlay(Console.readLine());
			// 재시작이면 컴퓨터의 숫자야구 재설정
			if (game.isPlay()) {
				game.setComputer(createRandomNumberList());
			}
		}
	}

	public static List<Integer> createRandomNumberList() {
		LinkedHashSet<Integer> numberSet = new LinkedHashSet<>();
		while (numberSet.size() < Balls.SIZE) {
			numberSet.add(Randoms.pickNumberInRange(Ball.MIN_VALUE, Ball.MAX_VALUE));
		}
		return new ArrayList<>(numberSet);
	}

	public static List<Integer> toNumberList(String input) {
		validateIsNumbers(input);
		List<Integer> result = new ArrayList<>();
		for (int i = 0; i < input.length(); i++) {
			result.add(input.charAt(i) - '0');
		}
		return result;
	}

	public static void validateIsNumbers(String input) {
		for (int i = 0; i < input.length(); i++) {
			validateIsNumber(input.charAt(i));
		}
	}

	public static void validateIsNumber(char c) {
		if (!(Character.isDigit(c))) {
			throw new IllegalArgumentException();
		}
	}
}