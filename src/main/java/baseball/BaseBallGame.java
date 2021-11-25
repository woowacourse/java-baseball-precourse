package baseball;

import static constants.BaseBallConstant.*;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;

/** 야구 게임의 전체적인 흐름을 구성 */
public class BaseBallGame {
	private List<Integer> randomNumber;
	private BaseBallPlayer baseBallPlayer;
	private BaseBallProvider baseBallProvider;
	private Integer gameStatus;

	public BaseBallGame(BaseBallPlayer baseBallPlayer, BaseBallProvider baseBallProvider) {
		randomNumber = baseBallProvider.getRandomNumber();
		this.baseBallPlayer = baseBallPlayer;
		this.baseBallProvider = baseBallProvider;
		this.gameStatus = GOING;
	}

	public void start() {
		BaseBallScore baseBallScore;
		while (gameStatus == GOING) {
			baseBallPlayer.getUserNumber();
			baseBallScore = new BaseBallScore();
			baseBallScore.countScore(randomNumber, baseBallPlayer);
			System.out.println(baseBallScore.scoreString());
			if (baseBallScore.isAllStrike()) {
				System.out.println(SUCCESS_MESSAGE);
				System.out.println(RESTART_OR_END_MESSAGE);
				gameStatus = Integer.valueOf(Console.readLine());
				if (gameStatus == GOING) {
					randomNumber = baseBallProvider.getRandomNumber();
				}
			}
		}
	}

}
