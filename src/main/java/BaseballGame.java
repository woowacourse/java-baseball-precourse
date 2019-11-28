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
		correctAns = new int[3]; /* 게임에서 세자리 숫자를 사용하므로 배열길이가 3임 */
		
		/* file correctAns[0] */
		correctAns[0] = (int)(Math.random() * 10);
		
		/* fill correctAns[1] */
		do {
			/* 두번째 랜덤숫자가 첫번째 랜덤숫자와 같지 않게 한다. */
			correctAns[1] = (int)(Math.random() * 10);
		
		} while (correctAns[1] == correctAns[0]);
		
		/* fill correctAns[2] */
		do {
			/* 세번째 랜덤숫자가 첫번째, 두번째 랜덤숫자와 같지 않게 한다. */
			correctAns[2] = (int)(Math.random() * 10);
			
		} while ( correctAns[2] == correctAns[0] 
				|| correctAns[2] == correctAns[1] );
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
		String ret;
		
		int strikeCnt = strikeCnt(guess);
		int ballCnt = ballCnt(guess);
		
		if (strikeCnt == 0 && ballCnt == 0) {
			
			/* strike와 ball 중 아무것도 없으면 실행된다. */
			ret = "낫싱";
		}
		else if (ballCnt == 0) {
			
			/* strike만 있고 ball이 없는 경우 실행된다. */
			ret = strikeCnt + " 스트라이크";
		}
		else if (strikeCnt == 0) {
			
			/* ball만 있고 strike가 없는 경우 실행된다. */
			ret = ballCnt + "볼";
		}
		else {
			
			/* strike와 ball 모두 한개 이상 있는 경우 실행된다. */
			ret = strikeCnt + " 스트라이크 " + ballCnt + "볼";
		}
		
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
		
		/* String guess를 int 세개로 바꾼다.*/
		int guessArr[] = new int[3];
		
		guessArr[0] = new Integer(guess.substring(0, 1));
		guessArr[1] = new Integer(guess.substring(1, 2));
		guessArr[2] = new Integer(guess.substring(2, 3));
		
		/* 각 자리마다 숫자를 비교하여 같은 갯수를 센다. */
		if (guessArr[0] == correctAns[0]) ret++;
		if (guessArr[1] == correctAns[1]) ret++;
		if (guessArr[2] == correctAns[2]) ret++;
		
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