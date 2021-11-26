package baseball.players;

import static baseball.utils.Constant.*;
import static camp.nextstep.edu.missionutils.Console.*;

import java.util.ArrayList;

public class Player {
	private final ArrayList<Integer> numbers;

	public Player() {
		this.numbers = new ArrayList<>();
	}

	/**
	 * 콘솔로부터 세자리 수를 입력받아서 저장한다.
	 * @throws IllegalArgumentException 잘못된 입력이 들어오면 발생시킨다.
	 */
	public void inputNumbers() throws IllegalArgumentException {
		System.out.print("숫자를 입력해주세요 : ");
		String[] input = readLine().split("");
		if (input.length != LENGTH_OF_NUMBERS) {
			throw new IllegalArgumentException("올바르지 않은 입력입니다.");
		}
		for (String ch : input) {
			numbers.add(convertToInteger(ch));
		}
		if (isOverlapped(numbers)) {
			throw new IllegalArgumentException("올바르지 않은 입력입니다.");
		}
	}

	public ArrayList<Integer> getNumbers() {
		return numbers;
	}

	private static boolean isOverlapped(ArrayList<Integer> numbers) {
		return numbers.size() != numbers.stream().distinct().count();
	}

	private static int convertToInteger(String ch) {
		try {
			return Integer.parseInt(ch);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("올바르지 않은 입력입니다.");
		}
	}
}
