package baseball.game;

import baseball.computer.Computer;
import baseball.computer.ResultViewer;
import baseball.player.Player;

public class BaseballGame {

	private final Computer computer;
	private final ResultViewer resultViewer;
	private final Player player;

	public BaseballGame(Computer computer, ResultViewer resultViewer, Player player) {
		this.computer = computer;
		this.resultViewer = resultViewer;
		this.player = player;
	}

	public void startGame() {
		while (true) {
			String computerBall = computer.createRandomBalls();
			playGame(computerBall);

		}
	}

	public void playGame(String computerBall) {
		while (true) {
			String validatedUserAnswer = player.readUserAnswer();
			int ballCnt = computer.checkBallCnt(computerBall, validatedUserAnswer);
			int strikeCnt = computer.checkStrikeCnt(computerBall, validatedUserAnswer);

			resultViewer.showResult(strikeCnt, ballCnt);

			if (strikeCnt == 3) {
				System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
				break;
			}
		}
	}
}
