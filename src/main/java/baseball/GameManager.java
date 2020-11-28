package baseball;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import utils.RandomUtils;

public class GameManager {
	private final static int START_INCLUSIVE = 100;
	private final static int END_INVLUSIVE = 999;
	private final static int MAX_NUM_LENGTH = 3;

	private String randomNumber;

	private int answer;
	private int strike, ball;

	public GameManager() {
		int random = RandomUtils.nextInt(START_INCLUSIVE, END_INVLUSIVE);

		this.randomNumber = Integer.toString(random);
		this.strike = 0;
		this.ball = 0;
	}

	public String getNumber() {
		return this.randomNumber;
	}

	public void query() {
		final Scanner scanner = new Scanner(System.in);

		System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
		this.answer = scanner.nextInt();
	}

	public int getQueryAnswer() {
		return this.answer;
	}

	public void inspect(String playerNumber) {
		for (int i = 0; i < MAX_NUM_LENGTH; i++) {
			if (this.randomNumber.contains(playerNumber.substring(i, i + 1))) {
				countStrikeAndBall(this.randomNumber.substring(i, i + 1), playerNumber.substring(i, i + 1));
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
		this.strike = 0;
		this.ball = 0;
	}

	public void countStrikeAndBall(String randomNumber, String playerNumber) {
		if (randomNumber.equals(playerNumber)) {
			this.strike++;
		} else {
			this.ball++;
		}
	}
	
	public void printHint(String status) {
		if (status.equals("nothing")) {
			System.out.println("낫싱");
		} else if (status.equals("ball")) {
			System.out.println(String.format("%d볼", this.ball));
		} else if (status.equals("strike")) {
			System.out.println(String.format("%d스트라이크", this.strike));
		} else if (status.equals("strike && ball")){
			System.out.println(String.format("%d볼 %d스트라이크", this.ball, this.strike));
		}
	}
}
