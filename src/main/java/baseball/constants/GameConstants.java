package baseball.constants;

public class GameConstants {
	public enum RandomRange {
		START_INCLUSIVE(1), END_INCLUSIVE(9);

		private final int number;

		RandomRange(int number) {
			this.number = number;
		}

		public int getNumber() {
			return number;
		}
	}

	public enum RandomDigit {
		LENGTH(3);

		private final int number;

		RandomDigit(int number) {
			this.number = number;
		}

		public int getNumber() {
			return number;
		}
	}
}
