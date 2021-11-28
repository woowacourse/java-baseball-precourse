package baseball;

import static constants.BaseBallConstant.*;

import camp.nextstep.edu.missionutils.Console;

/** 야구 게임의 전체적인 흐름을 구성 */
public class BaseBallGame {
	private final BaseBallPlayer baseBallPlayer;
	private final BaseBallProvider baseBallProvider;
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
		String userInputStatus = Console.readLine();
		if (!checkUserInputStatus(userInputStatus)) {
			throw new IllegalArgumentException(INVALID_RESTART_OR_END_INPUT_ERROR);
		}
		gameStatus = Integer.parseInt(userInputStatus);
	}

	private boolean checkUserInputStatus(String userInputStatus) {
		return isRightLength(userInputStatus) && isDigit(userInputStatus) && isRightStatus(userInputStatus);
	}

	private boolean isRightLength(String userInputStatus) {
		return userInputStatus.length() == 1;
	}

	private boolean isDigit(String userInputStatus) {
		return Character.isDigit(userInputStatus.charAt(0));
	}

	private boolean isRightStatus(String userInputStatus) {
		return Integer.parseInt(userInputStatus) == GOING || Integer.parseInt(userInputStatus) == STOP;
	}

}
