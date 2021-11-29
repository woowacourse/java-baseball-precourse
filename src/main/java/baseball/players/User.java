package baseball.players;

import static baseball.utils.Constant.*;
import static camp.nextstep.edu.missionutils.Console.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Predicate;

public class User implements Player {
	private final ArrayList<Integer> numbers;

	public User() {
		this.numbers = new ArrayList<>();
	}

	/**
	 * 콘솔로부터 세자리 수를 입력받아서 저장한다.
	 * @throws IllegalArgumentException 잘못된 입력이 들어오면 발생시킨다.
	 */
	public void inputNumbers() throws IllegalArgumentException {
		numbers.clear();
		System.out.print(INPUT_MSG);
		String[] input = readLine().split("");
		validateLength(input);
		validateZero(input);
		validateOverlapped(input);
		parseInt(input);
	}

	/**
	 * 사용자의 입력으로 받은 숫자들에 0이 들어있는지 확인한다.
	 * @param input 입력 받은 숫자 배열
	 */
	private void validateZero(String[] input) {
		if (Arrays.stream(input).anyMatch(Predicate.isEqual("0"))) {
			throw new IllegalArgumentException(ERR_INPUT_MSG);
		}
	}

	/**
	 * 사용자의 입력으로 받은 숫자의 길이가 맞는지 확인한다.
	 * @param input 입력 받은 숫자 배열
	 */
	private void validateLength(String[] input) {
		if (input.length != LENGTH_OF_NUMBERS) {
			throw new IllegalArgumentException(ERR_INPUT_MSG);
		}
	}

	/**
	 * 사용자의 입력으로 받은 숫자에 중복이 있는지 확인한다.
	 * @param input 입력 받은 숫자 배열
	 */
	private void validateOverlapped(String[] input) {
		if (input.length != Arrays.stream(input).distinct().count()) {
			throw new IllegalArgumentException(ERR_INPUT_MSG);
		}
	}

	/**
	 * 입력 받은 숫자를 int 형으로 변환한다.
	 * 변환 시 숫자가 아닐 경우 IllegalArgumentException을 발생시킨다.
	 * @param input 입력 받은 숫자 배열
	 */
	private void parseInt(String[] input) {
		for (String s : input) {
			try {
				numbers.add(Integer.parseInt(s));
			} catch (NumberFormatException e) {
				throw new IllegalArgumentException(ERR_INPUT_MSG);
			}
		}
	}

	@Override
	public int getNumber(int index) {
		return numbers.get(index);
	}
}
