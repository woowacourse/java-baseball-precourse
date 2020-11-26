package baseball;

import java.util.Scanner;
import utils.*;

public class Application {

	public static void main(String[] args) {
		final Scanner scanner = new Scanner(System.in);
		int goStop = 1;
		// TODO 구현 진행
		
		while(goStop == 1) {
			playGame();
			System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
			goStop = Integer.parseInt(scanner.nextLine());
			goStop = continueGame(String.valueOf(goStop));
		}
	}

	/**
	 * 답을 맞출 때까지 게임을 진행한다
	 */
	private static void playGame() {
		boolean win = false;
		CheckDuplicate checkDuplicate = new CheckDuplicate();
		String randomNum = checkDuplicate.makeRandomNumber();
		// System.out.println(randomNum);

		CheckInputNumber checkInputNumber = new CheckInputNumber();
		
		while(!win) {
			String input = checkInputNumber.inputNumber();
			// System.out.println(checkInputNumber.isValid(inputNum));

			StrikeBallNothingCorrect strikeBallNothingCorrect =
					new StrikeBallNothingCorrect(input, randomNum);
			win = strikeBallNothingCorrect.correctingNumbers();
			//System.out.println(test);
		}
	}
	
	
	/**
	 * 게임을 진행할지 멈출지 검사한다
	 * @param goStop
	 * @return int
	 */
	private static int continueGame(String goStop) {
		if(goStop.equals("1")) {
			return 1;
		} else if(goStop.equals("2")) {
			return 2;
		} else {
			throw new IllegalArgumentException("1 또는 2를 입력해야 합니다.");
		}
	}
	
	
}
