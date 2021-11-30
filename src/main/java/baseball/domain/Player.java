package baseball.domain;

import baseball.views.GameInput;

public class Player {

	private Player() {
	}

	public static boolean wantRestart() {
		RestartDecision decision = GameInput.readRestartDecision();
		return decision.isRestart();
	}

	public static Balls predictBalls() {
		return GameInput.readBalls();
	}
}
