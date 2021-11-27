package baseball;

class HintSentenceGenerator {
	private static final String BALL_HINT_MESSAGE = "%d볼";
	private static final String STRIKE_HINT_MESSAGE = "%d스트라이크";
	private static final String OUT_HINT_MESSAGE = "낫싱";
	private static final String GAME_CLEAR_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
	private static final HintSentenceGenerator hintSentenceGenerator = new HintSentenceGenerator();

	private HintSentenceGenerator() {
	}

	public static HintSentenceGenerator getHintSentenceGenerator() {
		return hintSentenceGenerator;
	}

	public String makeHintSentence(int strikeCount, int ballCount) {
		String hintSentence = "";
		if (ballCount != 0) {
			hintSentence += String.format(BALL_HINT_MESSAGE, ballCount);
		}
		if (ballCount != 0 && strikeCount != 0) {
			hintSentence += " ";
		}
		if (strikeCount != 0) {
			hintSentence += String.format(STRIKE_HINT_MESSAGE, strikeCount);
		}
		if (strikeCount == 3) {
			hintSentence += ("\n" + GAME_CLEAR_MESSAGE);
		}
		if (ballCount + strikeCount == 0) {
			hintSentence += OUT_HINT_MESSAGE;
		}
		return hintSentence;
	}
}
