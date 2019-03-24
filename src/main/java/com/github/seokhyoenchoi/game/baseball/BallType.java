package com.github.seokhyoenchoi.game.baseball;

public class BallType {
	private int strikes;
	private int balls;

	public BallType(int strikes, int balls) {
		this.strikes = strikes;
		this.balls = balls;
	}

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
