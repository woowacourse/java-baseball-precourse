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

			startGame(computerInput);

			System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
			System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

			String command = sc.nextLine();
			if (command.equals("1")) {
				continue;
			} else if (command.equals("2")) {
				break;
			} else {

			}
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

	private static void startGame(String computerInput) {
		while (true) {
			System.out.print("숫자를 입력해주세요: ");
			String userInput = sc.nextLine();

			int strike = compare(userInput, computerInput);
			if (strike == 3) {
				break;
			}
		}

	}

	private static int compare(String userInput, String computerInput) {
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
		return strike;
	}

}
