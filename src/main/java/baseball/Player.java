package baseball;

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
