package src.main.java;

public class BaseballGame {

	private static final int DIGITS = 3;
	private static final int EXIT = 2;
	private static final int START = 1;


	private int strike;
	private int ball;

	Computer com;
	Player player;

	BaseballGame() {
		com = new Computer();
		player = new Player();
	}


	void play() {
		com.createNumbers();
		player.createNumbers();
		calculateScore();
	}

	private void calculateScore() {
		strike = 0;
		ball = 0;
		for (int i = 0; i < DIGITS; i++) {
			if (com.comNums.get(i) == player.playerNums.get(i)) {
				strike++;
			} else if(com.comNums.contains(player.playerNums.get(i))){
				ball++;
			}
		}
	}
}
