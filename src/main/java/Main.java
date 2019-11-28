import java.util.Random;
import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		init();
	}

	private static void init() {

		while (true) {
			String computerInput = randomize();

			compare(computerInput);
		}
	}

	private static String randomize() {
		String number = "";
		boolean[] check = new boolean[10];
		Random generator = new Random();
		for (int i = 0; i < 3; i++) {
			int randomNumber = generator.nextInt(9) + 1;
			if (check[randomNumber]) {
				i--;
			} else {
				check[randomNumber] = true;
				number += randomNumber;
			}
		}
		System.out.println(number);
		return number;
	}

	private static void compare(String computerInput) {
		while (true) {
			System.out.print("숫자를 입력해주세요: ");
			String userInput = sc.nextLine();

			int strike = 0;
			int ball = 0;
			int nothing = 0;

			for (int i = 0; i < 3; i++) {
				char digit = userInput.charAt(i);
				if (computerInput.charAt(i) == digit) {
					strike++;
				} else if (computerInput.contains(digit + "")) {
					ball++;
				} else {
					nothing++;
				}
			}
			if (strike > 0) {
				System.out.print(strike + "스트라이크 ");
			}
			if (ball > 0) {
				System.out.print(ball + "볼 ");
			}
			if (nothing > 0) {
				System.out.print(nothing + "낫싱 ");
			}
			System.out.println();
			if (strike == 3) {
				break;
			}

		}

	}
}
