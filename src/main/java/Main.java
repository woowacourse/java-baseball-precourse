import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class Main {
	private static Scanner sc = new Scanner(System.in);
	private static String computerInput;
	private static int strike;
	private static int ball;
	private static int nothing;
	private static String command;

	public static void main(String[] args) {
		init();
	}

	private static void init() {
		while (true) {
			randomize();
			startGame();
			inputCommand();

			if (command.equals("1")) {
				continue;
			} else {
				break;
			}
		}
	}

	private static void randomize() {
		computerInput = "";
		Set<Integer> checkNumberSet = new HashSet<>();
		Random generator = new Random();
		for (int i = 0; i < 3; i++) {
			int randomDigit = generator.nextInt(9) + 1;
			if (checkNumberSet.contains(randomDigit)) {
				i--;
			} else {
				checkNumberSet.add(randomDigit);
				computerInput += randomDigit;
			}
		}
		System.out.println(computerInput);
	}

	private static void startGame() {
		while (true) {
			System.out.print("숫자를 입력해주세요: ");
			String userInput = sc.nextLine();
			if (userInput.length() != 3) {
				System.out.println("3자리 숫자를 입력해주세요!!");
				continue;
			}
			compare(userInput, computerInput);
			printResult();
			if (strike == 3) {
				System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
				break;
			}
		}

	}

	private static void compare(String userInput, String computerInput) {
		strike = 0;
		ball = 0;
		nothing = 0;
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
	}

	private static void printResult() {
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
	}

	private static void inputCommand() {
		System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
		while (true) {
			command = sc.nextLine();
			if (command.equals("1")) {
				break;
			} else if (command.equals("2")) {
				break;
			} else {
				System.out.println("잘못된 숫자를 입력하셨습니다. 다시 입력해주세요!(새로 시작: 1, 종료: 2)");
			}
		}
	}
}
