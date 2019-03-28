package edu.woowa.course.yagu;

/**
*@version 1.00 2019/03/28
*@author 조재훈
*/
public class BaseBallGame {

	private Pitcher pitcher;
	private Catcher catcher;

	public BaseBallGame(Pitcher pitcher, Catcher catcher) {
		this.pitcher = pitcher;
		this.catcher = catcher;
	}

	public void startGame() {
		do {
			playGame();
		} while (isContinue());
		Utils.closeScanner();
	}

	private void playGame() {
	}

	private boolean isContinue() {
		return true;
	}

	public static void main(String[] args) {
		Pitcher pitcher = new Pitcher();
		Catcher catcher = new Catcher();
		BaseBallGame game = new BaseBallGame(pitcher, catcher);

		game.startGame();
	}
}
