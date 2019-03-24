package com.github.seokhyoenchoi.game.baseball;

/**
*
* @description : Ball Type 출력을 위한 Class
* @package : com.github.seokhyoenchoi.game.baseball
* @author : 최석현
* 
*/
public class BallType { 
	private int strikes;
	private int balls;

	public BallType(int strikes, int balls) {
		this.strikes = strikes;
		this.balls = balls;
	}
	
	/**
	 * @desc toString Overriding
	 */
	@Override
	public String toString() {
		if (strikes == 0 && balls == 0) {
			
			return "낫싱";
			
		} else {
			String str = "";
			
			if (strikes > 0) {
				str += strikes + " 스트라이크   ";
			}
			
			if (balls > 0) {
				str += balls + " 볼";
			}
			
			return str;
		}
	}
}
