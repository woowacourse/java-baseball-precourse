package baseball.views;

import static baseball.utils.InputUtil.*;
import static java.util.stream.Collectors.*;

import java.util.List;

import baseball.domain.Ball;
import baseball.domain.Balls;
import baseball.domain.RestartDecision;

public class GameInput {

	private static final String DECIDE_RESTART_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
	private static final String BALL_PREDICT_MESSAGE = "숫자를 입력해주세요 : ";

	private GameInput() {
	}

	public static RestartDecision readRestartDecision() {
		System.out.println(DECIDE_RESTART_MESSAGE);
		try {
			return RestartDecision.from(readInt());
		} catch (Exception e) {
			throw new IllegalArgumentException(e.getMessage());
		}
	}

	public static Balls readBalls() {
		System.out.print(BALL_PREDICT_MESSAGE);
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
