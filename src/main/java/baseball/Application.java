package baseball;

import java.util.Scanner;

import service.ComputerBaseballService;
import service.UserBaseballService;
import utils.BallStrikeCheckUtils;

/**
 * 숫자야구 게임을 진행하는 클래스(main)
 * 기능 1. 각 순서에 맞게 숫자야구게임 진행
 * 기능 2. 새로운 컴퓨터 턴을 시작하기 위한 객체 생성
 * 기능 3. 새로운 유저 턴을 시작하기 위한 객체 생성
 * 기능 4. 힌트를 출력하고 정답 여부 확인 후 출력
 * 기능 5. 리플레이 여부 확인하고 다시 숫자야구게임 진행 혹은 종료
 */
public class Application {
	/** 정답을 만족하는 스트라이크 갯수를 한정하는 상수 */
	private static final Integer MAX_BALL_CNT = 3;
	
	/** 스트라이크, 볼 갯수 체크를 위한 상수 */
	private static final Integer ZERO = 0;
	
	/** 리플레이 여부를 확인하기 위한 상수 */
	private static final Integer REPLAY_YES = 1;
	private static final Integer REPLAY_NO = 2;
	
	/** 힌트 출력에 쓰이는 상수 */
	private static final String BALL_WORD = "볼";
	private static final String STRIKE_WORD = "스트라이크";
	private static final String NOTHING_WORD = "낫싱";
	private static final Character WHITESPACE = 32;
	
	/** 정답 맞출 시 게임 종료 메시지 출력에 쓰이는 상수 */
	private static final String FINISH_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
	
	/** 리플레이 여부 물어보는 메시지 출력에 쓰이는 상수 */
	private static final String REPLAY_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
	
	public static void main(String[] args) {
		final Scanner scanner = new Scanner(System.in);
		gamePlay(scanner);
	}

	/** 각 순서에 맞게 숫자야구게임 진행 */
	private static void gamePlay(Scanner scanner) {
		computerPlay();
		userPlay(scanner);
		checkResult(scanner);
		checkReplay(scanner);
	}

	/** 새로운 컴퓨터 턴을 시작하기 위한 객체 생성 */
	private static void computerPlay() {
		new ComputerBaseballService();
	}

	/** 새로운 유저 턴을 시작하기 위한 객체 생성 */
	private static void userPlay(Scanner scanner) {
		try {
			new UserBaseballService(scanner);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			new UserBaseballService(scanner);
		}
	}

	/** 힌트를 출력하고 정답 여부 확인 후 출력 */
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

	/** 리플레이 여부 확인하고 다시 숫자야구게임 진행 혹은 종료 */
	private static void checkReplay(Scanner scanner) {
		System.out.println(REPLAY_MESSAGE);

		int replayFlag = Integer.parseInt(scanner.nextLine());

		if (replayFlag == REPLAY_YES) {
			gamePlay(scanner);
		} else if (replayFlag == REPLAY_NO) {
			// Do nothing; no more play
		}
	}

	/** 양식에 맞게 힌트 출력하는 기능 */
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
