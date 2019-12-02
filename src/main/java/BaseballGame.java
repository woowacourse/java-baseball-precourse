package src.main.java;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * 게임진행의 역할을 담당하는 클래스
 * 
 * @author smr60
 *
 */
public class BaseballGame {

	/** 게임을 위해 필요한 숫자의 자릿 수 */
	private static final int DIGITS = 3;
	
	/** 정답일 경우, 게임을 종료하기 위한 상수 */
	private static final int EXIT = 2;
	
	/** 정답일 경우, 게임을 재시작하기 위한 상수 */
	private static final int RESTART = 1;


	/** strike의 갯수 */
	private int strike;
	
	/** ball의 갯수 */
	private int ball;

	/** 컴퓨터와 플레이어의 객체 선언 */
	Computer com;
	Player player;

	BaseballGame() {
		com = new Computer();
		player = new Player();
	}

	/**
	 * 전체 게임 로직을 실행하는 메소드입니다. 각 단계에서의 필요한 메소드들을 호출합니다.
	 */
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

	/**
	 * 컴퓨터가 생성한 수와 플레이어가 생성한 수를 비교하여 strike와 ball의 갯수를 계산합니다. 
	 * 계산이 필요할 때마다 strike와 ball을 0으로 초기화한 후 계산값을 새로 저장합니다.
	 */
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
	
	/**
	 * 플레이어의 입력에 따른 strike와 ball의 결과를 출력해 줍니다.
	 */
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
	
	/**
	 * 정답을 확인하는 메소드 입니다. strike 갯수가 3이면 정답으로 간주하고 축하 메시지와 함께 게임의 재시작/종료 여부를 묻습니다.
	 * 
	 * @return 정답일 경우 true를 반환, 그렇지 않으면 false를 반환합니다.
	 */
	private boolean checkAnswer() {
		if (strike == DIGITS) {
			System.out.println("3개의 숫자를 모두 맞추셨습니다! 게임 종료");
			System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");
			return true;
		}
		return false;
	}
	
	/**
	 * 플레이어에게 1 또는 2를 입력 받고, 2일 경우에는 프로그램이 종료됩니다. 
	 * 문자를 입력받거나, 1 또는 2이외의 수를 입력받았을 경우는 예외처리가 발생하여 다시 입력을 받습니다. 
	 * 1을 입력했을 경우 strike와 ball이 0으로 초기화되고 게임을 재시작합니다.
	 */
	private void restartOrExit() {
		Scanner input = new Scanner(System.in);
		int inputValue = 0;
		while (true) {
			try {
				inputValue = input.nextInt();
				createException(inputValue);
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
	
	/**
	 * 1 또는 2이외의 정수를 입력으로 받았을 때, 임의로 예외처리를 발생시키는 메소드 입니다. 예외가 발생하면 입력을 다시 받습니다.
	 * 
	 * @param inputValue
	 */
	private void createException(int inputValue) {
		if (inputValue != RESTART && inputValue != EXIT) {
			throw new InputMismatchException();
		}
	}
}
