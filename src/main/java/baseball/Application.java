package baseball;

import java.util.Scanner;

public class Application {

	private static final String INPUT_GUIDE = "숫자를 입력해주세요 : ";
	private static int ball = 0;
	private static int strike = 0;
	
	public static void main(String[] args) {
		final Scanner scanner = new Scanner(System.in);
		// TODO 援ы쁽 吏꾪뻾
		System.out.print(INPUT_GUIDE);
		input = scanner.nextLine();

		int answer = Integer.parseInt(input);
		
		System.out.println("입력 : " + input + "랜덤수 : " + makeQuestion());
	}

	static int makeQuestion() {
		int max = 0;
		int question = 0;
		while (max != 3) {
			int number = RandomUtils.nextInt(1, 9);
			if (makeCheck(question, number)) {
				question = question * 10 + number;
				max++;
			}
		}

		return question;
	}
	
	static boolean makeCheck(int question, int number) {
		while (question != 0) {
			if (question % 10 == number) {
				return false;
			}
			question /= 10;
		}
		return true;
	}
}
