package baseball;

import java.util.Scanner;

import service.ComputerBaseballService;
import service.UserBaseballService;
import utils.BallStrikeCheckUtils;

public class Application {
	private static final Integer REPLAY_YES = 1;
	private static final Integer REPLAY_NO = 2;
	private static final Integer MAX_BALL_CNT = 3;
	private static final Integer ZERO = 0;
	private static final String BALL_WORD = "볼";
	private static final String STRIKE_WORD = "스트라이크";
	private static final String NOTHING_WORD = "낫싱";
	private static final String FINISH_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
	private static final String REPLAY_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
	private static final Character WHITESPACE = 32;

	public static void main(String[] args) {
		final Scanner scanner = new Scanner(System.in);
		gamePlay(scanner);
	}

	private static void gamePlay(Scanner scanner) {
		computerPlay();
		userPlay(scanner);
		checkResult(scanner);
		checkReplay(scanner);
	}

	private static void computerPlay() {
		new ComputerBaseballService();
	}

	private static void userPlay(Scanner scanner) {
		try {
			new UserBaseballService(scanner);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			new UserBaseballService(scanner);
		}
	}

	private static void checkResult(Scanner scanner) {
		int ball = BallStrikeCheckUtils.getBall();
		int strike = BallStrikeCheckUtils.getStrike();

		printHint(ball, strike);

		if (strike != MAX_BALL_CNT) {
			userPlay(scanner);
			checkResult(scanner);
		} else {
			System.out.println(FINISH_MESSAGE);
		}
	}

	private static void checkReplay(Scanner scanner) {
		System.out.println(REPLAY_MESSAGE);

		int replayFlag = Integer.parseInt(scanner.nextLine());

		if (replayFlag == REPLAY_YES) {
			gamePlay(scanner);
		} else if (replayFlag == REPLAY_NO) {
			// Do nothing; no more play
		}
	}

	public static void printHint(int ball, int strike) {
		StringBuilder hint = new StringBuilder();

		if (ball != ZERO) {
			hint.append(ball);
			hint.append(BALL_WORD);
			hint.append(WHITESPACE);
		}

		if (strike != ZERO) {
			hint.append(strike);
			hint.append(STRIKE_WORD);
		}

		if (strike + ball != ZERO) {
			System.out.println(hint.toString());
			return;
		}

		System.out.println(NOTHING_WORD);
	}
}
