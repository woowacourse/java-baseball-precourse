package src.main.java;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
 * 유저에게 세자리수 정수를 입력받고 배열에 저장한다. 게임 진행을 위해 playerNums을 만드는 클래스
 * 
 * @author smr60
 *
 */
public class Player {

	/** 게임을 위해 필요한 숫자의 자릿 수 */
	private static final int DIGITS = 3;

	/** 플레이어가 입력한 숫자를 저장하는 리스트  */
	List<Integer> playerNums;

	/**
	 * 사용자로부터 입력받은 숫자를 배열로 저장하는 메소드 입니다. 
	 * 입력받은 수가 세자리 수가 아니거나, 0을 포함하고 있거나, 중복되는 수가 포함되어 있으면 입력을 다시 받습니다.
	 * 예외 사항에 해당하지 않으면 리스트를 playerNums에 복사합니다. 
	 */
	public void createNumbers() {
		List<Integer> list = inputIntValue();

		while (!isThreeDigits(list) | hasZero(list) | isDuplicated(list)) {
			list = inputIntValue();
		}
		playerNums = new ArrayList<>(list);
	}

	/**
	 * 사용자로부터 실질적으로 입력을 받는 메소드 입니다. 문자가 입력으로 들어왔을 경우, 예외처리가 발생하여 다시 입력을 받습니다.
	 * 
	 * @return 입력받은 정수를 한자리씩 List에 저장하여 반환합니다.
	 */
	private List<Integer> inputIntValue() {
		Scanner input = new Scanner(System.in);
		System.out.print("숫자를 입력해주세요 : ");
		int inputIntValue;

		while (true) {
			try {
				inputIntValue = input.nextInt();
				break;
			} catch (InputMismatchException e) {
				System.out.print("숫자를 입력해주세요 : ");
				input = new Scanner(System.in);
			} catch (Exception e) {
			}
		}

		List<Integer> list = new ArrayList<>();
		while (inputIntValue > 0) {
			list.add(0, inputIntValue % 10);
			inputIntValue /= 10;
		}
		return list;
	}

	private boolean isThreeDigits(List<Integer> list) {
		return list.size() == DIGITS;
	}

	private boolean hasZero(List<Integer> list) {
		return list.contains(0);
	}

	private boolean isDuplicated(List<Integer> list) {
		Set<Integer> set = new HashSet<Integer>(list);
		return set.size() < list.size();
	}
}
