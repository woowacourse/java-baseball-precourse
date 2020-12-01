package baseball;

import java.util.Scanner;

public class Application {

	private static final String INPUT_GUIDE = "숫자를 입력해주세요 : ";
	private static final String NOT_THING = "낫싱 ";
	private static final String GAME_OVER = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
	private static final String RESTART_GUIDE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
	private static final String RESTART_GAME = "1";
	private static final String END_GAME = "2";

	private static int ball = 0;
	private static int strike = 0;

	public static void main(String[] args) {
		final Scanner scanner = new Scanner(System.in);
		// TODO 援ы쁽 吏꾪뻾

		boolean gameEnd = false;
		boolean threeStrike;
		String input;

		while (!gameEnd) {
			int question = makeQuestion();

			threeStrike = false;

			while (!threeStrike) {
				System.out.print(INPUT_GUIDE);
				input = scanner.nextLine();

				int answer = Integer.parseInt(input);

				threeStrike = checkNumber(answer, question);

				ball = 0;
				strike = 0;
			}

			System.out.println(RESTART_GUIDE);
			String restartAnswer = scanner.nextLine();

			gameEnd = restartCheck(restartAnswer);
		}
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

	static boolean checkNumber(int answer, int question) {
		answerPickNumber(answer, question);

		if (strike == 3) {
			System.out.println(GAME_OVER);
			return true;
		}

		if (ball + strike == 0) {
			System.out.println(NOT_THING);
			return false;
		}

		System.out.println("볼 : " + ball + " 스타라이크 : " + strike);

		return false;
	}

	static void answerPickNumber(int answer, int question) {
		for (int answerCount = 0; answerCount < 3; answerCount++) {
			checkBS(answer % 10, answerCount, question);
			answer /= 10;
		}
	}

	static void checkBS(int answerTemp, int answerCount, int question) {
		for (int questionCount = 0; questionCount < 3; questionCount++) {
			int questionTemp = question % 10;
			question /= 10;

			if (answerTemp == questionTemp) {
				ball = ball + 1;
				if (answerCount == questionCount) {
					ball = ball - 1;
					strike = strike + 1;
				}

			}
		}
	}

	static boolean restartCheck(String restartAnswer) {

		if (restartAnswer.equals(RESTART_GAME)) {
			return false;
		}

		if (restartAnswer.equals(END_GAME)) {
			return true;
		}
		return true;
	}

}
