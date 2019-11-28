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
		
	}
	
	
	/**
	 * This method provides CUI for only one game.
	 * This method is used in interactiveShell() method.
	 */
	private void oneGameInteractiveShell(Scanner scanner) {
		
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