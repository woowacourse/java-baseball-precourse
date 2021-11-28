package baseball;

import static constants.BaseBallConstant.*;

import camp.nextstep.edu.missionutils.Console;

/** 야구 게임의 전체적인 흐름을 구성 */
public class BaseBallGame {
	private final BaseBallPlayer baseBallPlayer;
	private final BaseBallAnswerProvider baseBallAnswerProvider;
	private final BaseBallInputValidator validator;
	private Integer gameStatus;

	public BaseBallGame(BaseBallPlayer baseBallPlayer, BaseBallAnswerProvider baseBallAnswerProvider) {
		this.baseBallPlayer = baseBallPlayer;
		this.baseBallAnswerProvider = baseBallAnswerProvider;
		this.validator = new BaseBallInputValidator();
		this.gameStatus = GOING;
	}

	public void start() {
		BaseBallScore baseBallScore = new BaseBallScore();
		while (gameStatus == GOING) {
			baseBallAnswerProvider.makeAnswer();
			while (!baseBallScore.isAllStrike()) {
				baseBallPlayer.getUserNumber();
				baseBallScore.countScore(baseBallAnswerProvider.getAnswer(), baseBallPlayer);
				System.out.println(baseBallScore.scoreString());
			}
			getGameStatus();
		}
	}

	private void getGameStatus() {
		System.out.println(SUCCESS_MESSAGE);
		System.out.println(RESTART_OR_END_MESSAGE);
		String userInputStatus = Console.readLine();
		if (!validator.checkUserInputStatus(userInputStatus)) {
			throw new IllegalArgumentException(INVALID_RESTART_OR_END_INPUT_ERROR);
		}
		gameStatus = Integer.parseInt(userInputStatus);
	}

}
