package baseball;

public class GameSystem {
	private static final String BALL_STR = "볼";
	private static final String STRIKE_STR = "스트라이크";
	private static final String NOTHING = "낫싱";
	private static final int CNT_NUMBER = 3;
	
	private int[] player;
	private int[] computer;
	
	private int strike;
	private int ball;

	public GameSystem(int[] player, int[] computer) {
		this.player = player;
		this.computer = computer;
		this.strike = 0;
		this.ball = 0;
	}
	
	public void calculateScore() {
		for(int i=0;i<CNT_NUMBER;i++) {
			int score = isStrikeOrBall(player[i], i);
			if(score == 1) {
				ball++;
				continue;
			}
			if(score == 2) {
				strike++;
			}
		}
	}
	
	private int isStrikeOrBall(int num, int index) {
		for(int i=0;i<CNT_NUMBER;i++) {
			int score = getScore(computer[i], i, num, index);
			if(score != 0) {
				return score;
			}
		}
		return -1;
	}
	
	private int getScore(int num1, int num2, int index1, int index2) {
		int score = 0;
		if(num1 == num2) {
			score++;
			if(index1 == index2) {
				score++;
			}
		}
		return score;
	}
	
	public void printResult() {
		System.out.println(getResultString());
		if(strike == 3) {
			System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
		}
	}
	
	public void reset() {
		strike = 0;
		ball = 0;
	}
	
	private String getResultString() {
		if(strike == 0 && ball == 0) {
			return NOTHING;
		}
		
		StringBuilder sb = new StringBuilder();
		if(ball > 0) {
			sb.append(ball).append(BALL_STR);
		}
		if(strike > 0) {
			sb.append(strike).append(STRIKE_STR);
		}
		return sb.toString();
	}
}
