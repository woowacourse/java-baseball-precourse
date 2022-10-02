package baseball;

import static camp.nextstep.edu.missionutils.Console.*;

public class BaseBallGame {

	public BaseBallGame() {
	}

	public void play() {
		Balls userBalls = makeUserBalls();
	}

	private Balls makeUserBalls() {
		Balls userBalls = null;
		while (userBalls == null) {
			// todo 사용자 볼 생성 예외처리
			userBalls = Balls.stringToBalls(getUserInput());
		}
		return userBalls;
	}

	private String getUserInput() {
		return readLine();
	}
}
