package baseball;

import static util.Constants.*;

class HintSentenceGenerator {
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
		if (strikeCount == GAME_NUMBER_LENGTH) {
			hintSentence += ("\n" + GAME_CLEAR_MESSAGE);
		}
		if (ballCount + strikeCount == 0) {
			hintSentence += OUT_HINT_MESSAGE;
		}
		return hintSentence;
	}
}
