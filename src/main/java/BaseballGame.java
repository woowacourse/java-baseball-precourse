package src.main.java;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BaseballGame {

	private static final int DIGITS = 3;
	private static final int EXIT = 2;
	private static final int START = 1;


	private int strike;
	private int ball;

	Computer com;
	Player player;

	BaseballGame() {
		com = new Computer();
		player = new Player();
	}


	void play() {
		while(true) {
			com.createNumbers();
			while(!checkAnswer()) {
				player.createNumbers();
				calculateScore();
				showResult();
			}
			restartOrExit();
		}
		
		
	}

	private void calculateScore() {
		strike = 0;
		ball = 0;
		for (int i = 0; i < DIGITS; i++) {
			if (com.comNums.get(i) == player.playerNums.get(i)) {
				strike++;
			} else if(com.comNums.contains(player.playerNums.get(i))){
				ball++;
			}
		}
	}
	
	private void showResult() {
		String result = "낫싱";
		if (strike > 0 && ball > 0) {
			result = strike + " 스트라이크 " + ball + "볼";
		} else if (strike > 0) {
			result = strike + " 스트라이크";
		} else if (ball > 0) {
			result = ball + "볼";
		}
		System.out.println(result);
	}
	
	private boolean checkAnswer() {
		if (strike == DIGITS) {
			System.out.println("3개의 숫자를 모두 맞추셨습니다! 게임 종료");
			System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");
			return true;
		}
		return false;
	}
	
	private void restartOrExit() {
		Scanner input = new Scanner(System.in);
		int inputValue = 0;
		while (true) {
			try {
				inputValue = input.nextInt();
				break;
			} catch (InputMismatchException e) {
				checkAnswer();
				input = new Scanner(System.in);
			} catch (Exception e) {
			}
		}
		if (inputValue == EXIT) {
			System.exit(0);
		}

		strike = 0;
		ball = 0;

	}
}
