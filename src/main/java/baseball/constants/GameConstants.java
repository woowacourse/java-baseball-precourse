package baseball.constants;

public class GameConstants {
	public enum DigitRange {
		START_INCLUSIVE(1), END_INCLUSIVE(9);

		private final int number;

		DigitRange(int number) {
			this.number = number;
		}

		public int getNumber() {
			return number;
		}
	}

	public enum Digit {
		LENGTH(3);

		private final int number;

		Digit(int number) {
			this.number = number;
		}

		public int getNumber() {
			return number;
		}
	}

	public enum Message {
		ERR_NOT_IN_RANGE("범위 내의 숫자가 아닙니다"),
		ERR_IMPROPER_LENGTH("적절한 길이가 아닙니다"),
		ERR_DUPLICATE_EXISTS("중복된 수가 있습니다"),
		ERR_IMPROPER_USER_SELECTION("잘못된 선택입니다");

		private final String message;

		Message(String message) {
			this.message = message;
		}

		public String getMessage() {
			return message;
		}
	}

	public enum Terminology {
		STRIKE("스트라이크"),
		BALL("볼"),
		NOTHING("낫싱");

		private final String string;

		Terminology(String string) {
			this.string = string;
		}

		public String getString() {
			return string;
		}
	}

	public enum Hint {
		HINT_ASK_INPUT("숫자를 입력해주세요 : "),
		HINT_GAME_OVER(
			Digit.LENGTH.getNumber() + "개의 숫자를 모두 맞히셨습니다! 게임 종료\n게임을 새로 시작하려면 " + GameOverInput.RESTART.getNumber()
				+ ", 종료하려면 " + GameOverInput.RESTART.getNumber() + "를 입력하세요");

		private final String string;

		Hint(String string) {
			this.string = string;
		}

		public String getString() {
			return string;
		}
	}

	public enum GameOverInput {
		INPUT_LENGTH(1),
		RESTART(1),
		STOP(2);

		private final int number;

		GameOverInput(int number) {
			this.number = number;
		}

		public int getNumber() {
			return number;
		}
	}
}
