package baseball.generator;

import baseball.view.OutputView;
import java.util.ArrayList;
import java.util.Objects;

/**
 * 유저에게 보여줄 힌트를 생성하는 클래스
 */
public class HintGenerator {
	private static int LOOP_INDEX = 0;
	private static final int INITIAL_VALUE = 0;

	/** 볼, 스트라이크 개수에 따라 힌트를 제어하는 함수
	 *
	 * @param ballCount: int
	 * @param strikeCount: int
	 */
	public static void controlHint(int ballCount, int strikeCount) {
		if (ballCount != INITIAL_VALUE) {
			OutputView.printBall(ballCount);
			if (strikeCount != INITIAL_VALUE) {
				OutputView.printStrike(strikeCount);
			}
			OutputView.printNewLine();
		} else if (strikeCount != INITIAL_VALUE) {
			OutputView.printStrike(strikeCount);
			OutputView.printNewLine();
		} else {
			OutputView.printNothing();
		}
	}

	/** 스트라이크 개수를 세는 함수
	 *
	 * @param answerNumber: ArrayList<Integer>
	 * @param playerNumber: ArrayList<Integer>
	 * @return strikeCount
	 */
	public static int strikeCounter(ArrayList<Integer> answerNumber, ArrayList<Integer> playerNumber) {
		int strikeCount = INITIAL_VALUE;
		LOOP_INDEX = INITIAL_VALUE;

		while (LOOP_INDEX != answerNumber.size()) {
			if (Objects.equals(answerNumber.get(LOOP_INDEX), playerNumber.get(LOOP_INDEX))) {
				strikeCount++;
			}
			LOOP_INDEX++;
		}

		return strikeCount;
	}

	/** 볼 개수를 세는 함수
	 *
	 * @param answerNumber: ArrayList<Integer>
	 * @param playerNumber: ArrayList<Integer>
	 * @return ballCount
	 */
	public static int ballCounter(ArrayList<Integer> answerNumber, ArrayList<Integer> playerNumber) {
		int ballCount = INITIAL_VALUE;
		LOOP_INDEX = INITIAL_VALUE;

		while (LOOP_INDEX != answerNumber.size()) {
			if (answerNumber.contains(playerNumber.get(LOOP_INDEX))) {
				ballCount++;
			}
			LOOP_INDEX++;
		}
		return ballCount - strikeCounter(answerNumber, playerNumber);
	}
}
