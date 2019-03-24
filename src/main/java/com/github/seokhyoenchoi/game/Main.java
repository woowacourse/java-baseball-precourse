package com.github.seokhyoenchoi.game;


import com.github.seokhyoenchoi.game.baseball.BaseballGame;

/**
*
* @description : Main Class
* @package : com.github.seokhyoenchoi.game
* @author : 최석현
* 
*/
public class Main { 
	
	/**
	 * @desc Main Method. 시작, 종료 Control
	 */
	public static void main(String[] args) {
		BaseballGame baseballGame = new BaseballGame();
		while(true) {
			baseballGame.init();
			baseballGame.start();
			if(!baseballGame.answerRestart()) {
				break;
			}
		}
	}
}
