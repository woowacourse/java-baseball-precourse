/*
 * Result
 * 
 * version 1.0
 * 
 * 2019. 3. 27
 * 
 * Created by Wongeun Song
 */
public class Result {
	private int strike;
	private int ball;
	
	public Result() {
		strike = 0;
		ball = 0;
	}
	
	public void increaseStrike() {
		strike++;
	}
	
	public void increaseBall() {
		ball++;
	}
	
	public boolean isNotting() {
		return (strike == 0) && (ball == 0);
	}
	
	public void print() {
		String message = "";
		
		if ((strike == 0) && (ball == 0)) {
			message += "낫싱";
		} else {
			if (strike != 0) {
				message += strike + " 스트라이크 ";
			}
			if (ball != 0) {
				message += ball + "볼";
			}
		}
		System.out.println(message);
	}
}
