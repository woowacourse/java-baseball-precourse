package baseball;

import java.util.Scanner;
import java.util.HashSet;

public class Player {
	
	public void inputThreeNumbers() {
		Scanner scanner = new Scanner(System.in);
		String inputNumbers = scanner.nextLine();
	}

	public HashSet<String> conveHartInputNumbersTOArray(String input) {
		HashSet<String> numbersSet = new HashSet();
		String[] arrayNumbers = input.split("");

		for (int i = 0; i <= arrayNumbers.length; i++) {
			numbersSet.add(arrayNumbers[i]);
		}
		
		return numbersSet;
	}

}
