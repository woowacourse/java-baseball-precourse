package baseball.game;

import camp.nextstep.edu.missionutils.Console;

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

			if (!restartGame()) {
				System.out.println("게임 종료");
				break;
			}

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

	public boolean restartGame() {
		System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
		String restartFlag = Console.readLine();

		if (!restartFlag.equals("1") && !restartFlag.equals("2")) {
			throw new IllegalArgumentException("잘못된 사용자 입력입니다.");
		}

		return restartFlag.equals("1");
	}
}
