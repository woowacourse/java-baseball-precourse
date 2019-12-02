package src.main.java;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Player {

	private static final int DIGITS = 3;

	List<Integer> playerNums;

	public void createNumbers() {
		List<Integer> list = inputIntValue();

		while (!isThreeDigits(list) | hasZero(list) | isDuplicated(list)) {
			list = inputIntValue();
		}
		playerNums = new ArrayList<>(list);
	}

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
