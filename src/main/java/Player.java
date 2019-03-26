/*
 * Player.java
 *
 */

import java.util.Scanner;

/**
 * 게임의 진행과 입력을 담당하는 클래스
 */
public class Player {

	/**
	 * player.play() 함수를 반복하면서 게임을 진행
	 * @param args
	 */
	public static void main(String args[]) {
		Player player = new Player();

		do {
			player.play();
		} while (player.askRestart());
	}

	/**
	 * 게임을 진행하는 함수
	 */
	private void play() {
		String randomNumber = NumberMaker.makeRandomNumber();
		BaseBallGame game = new BaseBallGame(randomNumber);
		String userInput = null;

		do {
			userInput = getGameNumberInput();
			game.printResult(userInput);
		} while (!game.isCorrect());
	}

	/**
	 * 게임을 다시 시작할 것인지 묻는 함수
	 * @return
	 */
	private boolean askRestart() {
		String input = null;

		while (true) {
			System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
			input = getInput();
			if (input.equals("1")) {
				return true;
			} else if (input.equals("2")) {
				return false;
			} else {
				System.out.println("1 또는 2를 입력하세요");
			}
		}
	}

	/**
	 * 문자열을 입력받아 리턴하는 함수
	 * @return input
	 */
	private String getInput() {
		String input = null;
		Scanner scanner = new Scanner(System.in);

		input = scanner.nextLine();
		return input;
	}

	/**
	 * 게임 중 3자리 숫자를 리턴하는 함수
	 * @return
	 */
	private String getGameNumberInput() {
		String gameInput = null;

		while (true) {
			System.out.print("숫자를 입력해주세요: ");
			gameInput = getInput();
			if(NumberValidator.isValidNumbers(gameInput)) {
				break;
			}
			System.out.println("3자리 숫자를 입력해주세요 (0 제외)");
		}
		return gameInput;
	}
}
