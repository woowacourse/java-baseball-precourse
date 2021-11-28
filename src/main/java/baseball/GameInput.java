package baseball;

public class GameInput {

	private GameInput() {
	}

	public static RestartDecision readRestartDecision() {
		System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
		try {
			return RestartDecision.from(InputUtil.readInt());
		} catch (Exception e) {
			throw new IllegalArgumentException(e.getMessage());
		}
	}
}
