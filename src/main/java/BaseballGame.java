package main.java;

import java.util.Arrays;
import java.util.Scanner;

public class BaseballGame {
	private static final int MAX_TRY = 9 * 8 * 7;
	private static final Scanner SCANNER = new Scanner(System.in);

	private static final String RESTART = "1";
	private static final String EXIT = "2";

	public void runProgram() {
		runBaseball();
		restartGame();
	}

	/**
	 * 숫자야구 실행<br>
	 * 1~9까지 서로 다른 수로 이루어진 3자리의 수를 맞추는 게임이다.
	 */
	private void runBaseball() {
		int count = 0;
		BaseballNumber[] baseballNumbers = new BaseballNumber[9];
		String randomNumber = makeRandomNumber(baseballNumbers);
		while (count < MAX_TRY) {
			System.out.print("숫자를 입력해 주세요 : ");
			String inputNumber = SCANNER.nextLine();

			// TODO check input value
			
			++count;
			
			// TODO print hint

			if (randomNumber.equals(inputNumber)) {
				System.out.println(count + "번만에 숫자를 모두 맞히셨습니다! 게임 종료");
				return;
			}
		}

		// 최대 횟수가 초과 하면 정답 출력
		System.out.println("최대 회수를 초과했습니다! 정답은" + randomNumber + "입니다. 게임 종료");
	}

	/**
	 * 재시작 여부 확인<br>
	 * 1 : 재시작<br>
	 * 2 : 프로그램 종료<br>
	 */
	private void restartGame() {
		System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
		String inputFlag = SCANNER.nextLine();
		switch (inputFlag) {
			case RESTART:
				runProgram();
				break;
			case EXIT:
				System.out.println("프로그램 종료");
				break;

			default:
				System.out.println("잘 못 입력하셨습니다. 다시 입력해주세요.");
				restartGame();
				break;
		}
	}

	/**
	 * 3자리 난수를 생성
	 * @param baseballNumbers 
	 * @return randomNumber 3자리 난수
	 */
	private String makeRandomNumber(BaseballNumber[] baseballNumbers) {
		for (int i = 0; i < baseballNumbers.length; i++) {
			baseballNumbers[i] = new BaseballNumber(i + 1);
		}
		Arrays.sort(baseballNumbers);

		String randomNumber = "";
		for (int i = 0; i < 3; i++) {
			randomNumber += String.valueOf(baseballNumbers[i].getNumber());
		}
		return randomNumber;
	}
}
