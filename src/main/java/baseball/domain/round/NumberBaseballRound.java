package baseball.domain.round;

import baseball.domain.ball.NumberBallSet;
import baseball.domain.hint.NumberBallHint;
import baseball.view.View;

public class NumberBaseballRound {

	private static final String PREDICT_MSG = "숫자를 입력해주세요 : ";
	private static final String END_MSG = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

	private final View view;

	public NumberBaseballRound(View view) {
		this.view = view;
	}

	public void start() {
		NumberBallSet randomNumbers = generateRandomNumbers();
		while (true) {
			NumberBallHint hint = predictByUserInput(randomNumbers);
			showHint(hint);
			if (isUserCorrect(hint)) {
				break;
			}
		}
		endRound();
	}

	private NumberBallSet generateRandomNumbers() {
		return NumberBallSet.generateRandom();
	}

	private NumberBallHint predictByUserInput(NumberBallSet randomNumbers) {
		return NumberBallHint.compareNumberBallSets(randomNumbers, generateUserNumbers());
	}

	private NumberBallSet generateUserNumbers() {
		return NumberBallSet.generateFromInput(view.request(PREDICT_MSG));
	}

	private void showHint(NumberBallHint hint) {
		hint.giveHint();
	}

	private boolean isUserCorrect(NumberBallHint hint) {
		return hint.isAnswer();
	}

	private void endRound() {
		view.print(END_MSG);
	}
}
