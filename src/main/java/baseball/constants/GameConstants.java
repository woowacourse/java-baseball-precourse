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
		ERR_DUPLICATE_EXISTS("중복된 수가 있습니다");

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
}
