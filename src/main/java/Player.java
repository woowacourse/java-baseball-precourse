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

		/* 일단 1번만 실행 */
		do {
			player.play();
		} while (false);

	}

	/**
	 * 게임을 진행하는 함수
	 */
	private void play() {
		String randomNumber = NumberMaker.makeRandomNumber();
		String userInput = null;

		System.out.print("숫자를 입력해주세요: ");
		userInput = getInput();

		System.out.println(randomNumber);
		System.out.println(userInput);
	}

	/**
	 * 문자열을 입력받아 리턴하는 함수
	 * @return input
	 */
	private String getInput() {
		String input = null;
		Scanner scanner = new Scanner(System.in);

		input = scanner.nextLine();
		scanner.close();

		return input;
	}
}
