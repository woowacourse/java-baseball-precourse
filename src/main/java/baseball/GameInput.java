package baseball;

import static baseball.InputUtil.*;
import static java.util.stream.Collectors.*;

import java.util.List;

public class GameInput {

	private GameInput() {
	}

	public static RestartDecision readRestartDecision() {
		System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
		try {
			return RestartDecision.from(readInt());
		} catch (Exception e) {
			throw new IllegalArgumentException(e.getMessage());
		}
	}

	public static Balls readBalls() {
		System.out.print("숫자를 입력해주세요 : ");
		try {
			return new Balls(readBallList());
		} catch (Exception e) {
			throw new IllegalArgumentException(e.getMessage());
		}
	}

	private static List<Ball> readBallList() {
		return readIntList()
			.stream()
			.map(Ball::new)
			.collect(toList());
	}
}
