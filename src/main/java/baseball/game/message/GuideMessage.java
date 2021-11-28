package baseball.game.message;

public class GuideMessage {

	public static String enterNumberMessage() {
		return "숫자를 입력해주세요 : ";
	}

	public static String wrongNumberMessage(int ball, int strike) {
		if (ball == 0 && strike == 0) {
			return nothingMessage(ball, strike);
		} else if (strike == 0) {
			return ballOnlyMessage(ball, strike);
		} else if (ball == 0) {
			return strikeOnlyMessage(ball, strike);
		} else {
			return ballAndStrikeMessage(ball, strike);
		}
	}

	public static String nothingMessage(int ball, int strike) {
		if (ball == 0 && strike == 0) {
			return "낫싱";
		} else {
			throw new IllegalArgumentException("낫싱 출력에 잘못된 인수가 전달되었습니다");
		}
	}

	public static String ballOnlyMessage(int ball, int strike) {
		if (strike == 0 && (ball == 1 || ball == 2 || ball == 3)) {
			return ball + "볼";
		} else {
			throw new IllegalArgumentException("볼만 출력에 잘못된 인수가 전달되었습니다");
		}
	}

	public static String strikeOnlyMessage(int ball, int strike) {
		if (ball == 0 && (strike == 1 || strike == 2)) {
			return strike + "스트라이크";
		} else {
			throw new IllegalArgumentException("스트라이크만 출력에 잘못된 인수가 전달되었습니다");
		}
	}

	public static String ballAndStrikeMessage(int ball, int strike) {
		if (ball == 1 && strike == 1 || ball == 2 && strike == 1) {
			return ball + "볼 " + strike + "스트라이크";
		} else {
			throw new IllegalArgumentException("볼과 스트라이크 출력에 잘못된 인수가 전달되었습니다");
		}
	}

	public static String correctNumberMessage(int ball, int strike) {
		if (ball == 0 && strike == 3) {
			return "3개의 숫자를 모두 맞히셨습니다! 게임 종료\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
		} else {
			throw new IllegalArgumentException("정답 메세지 출력에 잘못된 인수가 전달되었습니다");
		}
	}
}
