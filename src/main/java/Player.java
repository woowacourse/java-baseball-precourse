package src.main.java;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Player {

	private static final int DIGITS = 3;

	List<Integer> playerNums;

	public void createNumbers() {
		List<Integer> list = inputIntValue();
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

}
