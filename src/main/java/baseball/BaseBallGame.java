package baseball;

import static constants.BaseBallConstant.*;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;

/** 야구 게임의 전체적인 흐름을 구성 */
public class BaseBallGame {
	private List<Integer> answer;
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
				System.out.println(baseBallProvider.getAnswer());
				baseBallPlayer.getUserNumber();
				baseBallScore.countScore(baseBallProvider.getAnswer(), baseBallPlayer);
				System.out.println(baseBallScore.scoreString());
			}
			System.out.println(SUCCESS_MESSAGE);
			System.out.println(RESTART_OR_END_MESSAGE);
			gameStatus = Integer.valueOf(Console.readLine());
		}
	}

}
