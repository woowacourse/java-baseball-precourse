package baseball.game;

import baseball.view.View;

public class NumberBaseballRound {

	private static final String PREDICT_MSG = "숫자를 입력해주세요 : ";
	private static final String END_MSG = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

	private final View view;

	public NumberBaseballRound(View view) {
		this.view = view;
	}

	public void start() {
		// todo : play actual game
		return;
	}
}
