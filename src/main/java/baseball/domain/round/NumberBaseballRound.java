package baseball.domain.round;

import baseball.domain.ball.NumberBallSet;
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
	}

	private NumberBallSet generateRandomNumbers() {
		return NumberBallSet.generateRandom();
	}


}
