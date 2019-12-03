import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

/**
 * 숫자야구게임
 * 
 * @author sssssseungmi
 * @className BaseballGame
 * @date 2019.12.03
 * @version 1.0
 */
public class BaseballGame {
	/** 3자리 수를 체크하기 위한 상수 */
	private static final int THREE = 3;

	/** Input을 받기 위한 Scanner 변수 */
	private static Scanner sc = new Scanner(System.in);
	/** 랜덤으로 생성된 컴퓨터의 세 자리 숫자를 담을 변수 */
	private static String computerInput;
	/** Strike의 갯수를 측정할 변수 */
	private static int strike;
	/** Ball의 갯수를 측정할 변수 */
	private static int ball;
	/** Nothing의 갯수를 측정할 변수 */
	private static int nothing;
	/** 게임 시작과 종료를 판단할 Command 변수 */
	private static String command;

	/**
	 * 프로그램을 최초로 실행하는 main함수
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
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

	/**
	 * 컴퓨터가 세 자리 숫자를 만드는 함수입니다. HashSet으로 중복되는 숫자를 체크합니다.
	 */
	private static void randomize() {
		computerInput = "";
		Set<Integer> checkNumberSet = new HashSet<>();
		Random generator = new Random();
		for (int i = 0; i < THREE; i++) {
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

	/**
	 * 생성된 computerInput을 바탕으로 사용자와 게임을 시작하는 함수입니다. user가 3개의 숫자를 모두 맞히면 종료됩니다.
	 */
	private static void startGame() {
		while (true) {
			System.out.print("숫자를 입력해주세요: ");
			String userInput = sc.nextLine();
			if (userInput.length() != THREE) {
				System.out.println("3자리 숫자를 입력해주세요!!");
				continue;
			}
			compare(userInput, computerInput);
			printResult();
			if (strike == THREE) {
				System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
				break;
			}
		}

	}

	/**
	 * user가 입력한 input과 컴퓨터가 생성한 세자리 수를 비교하는 함수입니다.
	 * 
	 * @param userInput
	 * @param computerInput
	 */
	private static void compare(String userInput, String computerInput) {
		strike = 0;
		ball = 0;
		nothing = 0;
		for (int i = 0; i < THREE; i++) {
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

	/**
	 * 비교한 결과를 출력하는 함수입니다.
	 */
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

	/**
	 * 게임을 새로 시작할지 종료할지 판단하는 함수입니다.
	 * 1을 입력하면 새로 시작, 2를 입력하면 종료,그 이외를 입력하면 입력을 다시 받습니다.
	 */
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
