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
}
