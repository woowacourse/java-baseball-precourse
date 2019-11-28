/**
 * BaseballGame.java
 * 
 * java version "1.8.0_212"
 * Eclipse 2018-12
 *
 * 2019. 11. 27.
 * 
 * copyright free
 */

package main.java;

import java.util.Scanner;

/**
 * 숫자야구 게임 (Baseball Game)
 * 
 * @author yelimkim98 : https://github.com/yelimkim98
 * @date 2019. 11. 27.
 */
public class BaseballGame {
	
	/**
	 * the correct answer of a baseball game
	 */
	private int[] correctAns;
	
	
	/**
	 * This method offer Command User Interface for baseball game.
	 * 
	 */
	public void interactiveShell() {
		/**
		 *  사용자가 게임을 다시 하기를 원하면 1, 그만하길 원하면 2가 저장된다. 
		 *  */
		int userWant = 1;
		final int RESTART = 1;
		final int QUIT = 2;
		
		Scanner scanner = new Scanner(System.in);
		
		do {
			/* 게임 한 판을 진행한다. 게임이 끝나면 다음줄로 넘어간다. */
			oneGameInteractiveShell(scanner); 
			
			/* 세 개임을 진행할지 말지 선택하는 User Interface를 제공한다. */
			System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
			userWant = scanner.nextInt();
			
		} while (userWant == RESTART);
		
		scanner.close();
	}
	
	
	/**
	 * This method provides CUI for only one game.
	 * This method is used in interactiveShell() method.
	 */
	private void oneGameInteractiveShell(Scanner scanner) {
		String guess;
		String ans;
		
		correctAnsRandomInit();		/* 정답이 될 세 개의 숫자를 랜덤 생성한다. */
		
		do {
			System.out.print("숫자를 입력해주세요 : ");
			
			guess = scanner.next();		/* 사용자 입력을 읽어온다. */
			
			ans = ansControl(guess);	/* 판단 결과를 얻는다. */
			System.out.println(ans);	/* 판단 결과를 출력한다. */
		
		} while (!ans.contentEquals("3 스트라이크"));
		
		System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
	}
	
	
	/**
	 * This method initializes the array correctAns[].
	 * Logically, This method should be used first in a game.
	 */
	private void correctAnsRandomInit() {
		
	}
	
	
	/**
	 * 
	 * Where this method is used : 
	 *     oneGameInteractiveShell
	 * 
	 * What does this method use :
	 *     strikeCnt
	 *     ballCnt
	 *
	 * @param guess the user's guessed answer
	 * @return how many strikes and how many balls as string
	 */
	private String ansControl(String guess) {
		
		String ret = "";
		
		
		
		return ret;
	}
	
	
	/**
	 * This method is used in ansControl method.
	 * 
	 * @param guess the user's guessed answer
	 * @return how many strikes as integer
	 */
	private int strikeCnt(String guess) {
		
		int ret = 0;
		
		
		
		return ret;
	}
	
	
	/**
	 * This method is used in ansControl method.
	 * 
	 * @param guess the user's guessed answer
	 * @return how many balls as integer
	 */
	private int ballCnt(String guess) {
		
		int ret = 0;
		
		
		
		return ret;
	}
	
}