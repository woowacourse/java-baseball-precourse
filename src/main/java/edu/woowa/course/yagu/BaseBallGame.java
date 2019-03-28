package edu.woowa.course.yagu;

/**
*@version 1.00 2019/03/28
*@author 조재훈
*/
public class BaseBallGame {

	private static final int NEWGAME = 1;
	private static final int EXIT = 2;
	private static final String GAME_MESSEAGE = "3개의 숫자를 모두 맞히셨습니다!"
												+" 게임 종료\n게임을 새로 시작하려면"
												+ NEWGAME 
												+ ", 종료하려면"
												+ EXIT
												+ "를 입력하세요.";
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
		boolean isPlaying = true;

		this.catcher.init();
		while (isPlaying) {
			isPlaying = catcher.catching(pitcher.pitching());
		}
	}

	private boolean isContinue() {
		while (true) {
			System.out.println(GAME_MESSEAGE);

			int selectionInput = Utils.getInput();
			if ( selectionInput == NEWGAME ) {
				return true;
			} else if ( selectionInput == EXIT ) {
				return false;
			}
		}
	}

	public static void main(String[] args) {
		Pitcher pitcher = new Pitcher();
		Catcher catcher = new Catcher();
		BaseBallGame game = new BaseBallGame(pitcher, catcher);

		game.startGame();
	}
}