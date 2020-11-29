package baseball;

import java.util.Scanner;

import utils.RandomUtils;

public class GameManager {
	private final static int START_INCLUSIVE = 100;
	private final static int END_INCLUSIVE = 999;
	
	public final static int MAX_NUM_LENGTH = 3;

	public String randomNumber;

	private int answer;
	private int strike, ball;

	GameManager() {
		this.randomNumber = getNumber();
		this.strike = 0;
		this.ball = 0;
	}
	
	private String getNumber() {
		String random;
		do {
			random = Integer.toString(RandomUtils.nextInt(START_INCLUSIVE, END_INCLUSIVE));			
		} while (!Validator.isUseable(random));
		
		return random;
	}

	public void query() {
		final Scanner scanner = new Scanner(System.in);

		System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
		answer = scanner.nextInt();
	}

	public int getQueryAnswer() {
		return answer;
	}

	public void inspect(String playerNumber) {
		for (int i = 0; i < MAX_NUM_LENGTH; i++) {
			if (randomNumber.contains(playerNumber.substring(i, i + 1))) {
				countStrikeAndBall(randomNumber.substring(i, i + 1), playerNumber.substring(i, i + 1));
			}
		}

		if (this.strike == 0 && this.ball == 0) {
			printHint("nothing");
		} else if (this.strike == 0 && this.ball > 0) {
			printHint("ball");
		} else if (this.ball == 0 && this.strike > 0) {
			printHint("strike");
		} else {
			printHint("strike && ball");
		}

		strike = 0;
		ball = 0;
	}

	public void countStrikeAndBall(String randomNumber, String playerNumber) {
		if (randomNumber.equals(playerNumber)) {
			strike++;
		} else {
			ball++;
		}
	}

	public void printHint(String status) {
		if (status.equals("nothing")) {
			System.out.println("낫싱");
		} else if (status.equals("ball")) {
			System.out.println(String.format("%d볼", ball));
		} else if (status.equals("strike")) {
			System.out.println(String.format("%d스트라이크", strike));
		} else if (status.equals("strike && ball")) {
			System.out.println(String.format("%d볼 %d스트라이크", ball, strike));
		}
	}
}
