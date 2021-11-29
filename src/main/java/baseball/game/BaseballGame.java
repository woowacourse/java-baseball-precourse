package baseball.game;

import baseball.constant.Constant;
import camp.nextstep.edu.missionutils.Console;

import baseball.computer.Computer;
import baseball.computer.ResultViewer;
import baseball.player.Player;

public class BaseballGame {
	private static final String RESTART = "1";
	private static final String FINISH = "2";

	Computer computer = new Computer();
	ResultViewer resultViewer = new ResultViewer();
	Player player = new Player();

	public BaseballGame() {

	}

	public void startGame() {
		while (true) {
			String computerBall = computer.createRandomBalls();
			System.out.println(computerBall);
			playGame(computerBall);

			if (!restartGame()) {
				System.out.println(Constant.FINISH_GAME_MESSAGE);
				break;
			}

		}
	}

	public void playGame(String computerBall) {
		while (true) {
			String validatedUserAnswer = player.readUserAnswer();
			int ballCnt = computer.checkBallCnt(computerBall, validatedUserAnswer);
			int strikeCnt = computer.checkStrikeCnt(computerBall, validatedUserAnswer);

			System.out.println(resultViewer.showResult(strikeCnt, ballCnt));

			if (strikeCnt == 3) {
				System.out.println(Constant.CORRECT_ALL_AND_FINISH_GAME_MESSAGE);
				break;
			}
		}
	}

	public boolean restartGame() {
		System.out.println(Constant.RESTART_GAME_MESSAGE);
		String restartFlag = Console.readLine();

		if (!restartFlag.equals(RESTART) && !restartFlag.equals(FINISH)) {
			throw new IllegalArgumentException(Constant.WRONG_INPUT_MESSAGE);
		}

		return restartFlag.equals(RESTART);
	}
}
