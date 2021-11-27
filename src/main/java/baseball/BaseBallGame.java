package baseball;

import static constants.BaseBallConstant.*;

import camp.nextstep.edu.missionutils.Console;

/** 야구 게임의 전체적인 흐름을 구성 */
public class BaseBallGame {
	private BaseBallPlayer baseBallPlayer;
	private BaseBallProvider baseBallProvider;
	private Integer gameStatus;

	public BaseBallGame(BaseBallPlayer baseBallPlayer, BaseBallProvider baseBallProvider) {
		this.baseBallPlayer = baseBallPlayer;
		this.baseBallProvider = baseBallProvider;
		this.gameStatus = GOING;
	}

	public void start() {
		BaseBallScore baseBallScore = new BaseBallScore();
		while (gameStatus == GOING) {
			baseBallProvider.makeAnswer();
			while (!baseBallScore.isAllStrike()) {
				baseBallPlayer.getUserNumber();
				baseBallScore.countScore(baseBallProvider.getAnswer(), baseBallPlayer);
				System.out.println(baseBallScore.scoreString());
			}
			getGameStatus();
		}
	}

	private void getGameStatus() {
		System.out.println(SUCCESS_MESSAGE);
		System.out.println(RESTART_OR_END_MESSAGE);
		Integer userInputStatus = Integer.valueOf(Console.readLine());
		if (!isRightStatus(userInputStatus)) {
			throw new IllegalArgumentException(INVALID_RESTART_OR_END_INPUT_ERROR);
		}
		gameStatus = userInputStatus;
	}

	private boolean isRightStatus(Integer userInputStatus) {
		return userInputStatus == GOING || userInputStatus == STOP;
	}

}
