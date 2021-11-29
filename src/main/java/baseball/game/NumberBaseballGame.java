package baseball.game;

import baseball.domain.Game;
import baseball.view.View;

public class NumberBaseballGame implements Game {

	private static final String CONTINUE_MSG
		= "게임을 새로 시작하시려면 1, 종료하려면 2를 입력하세요.";

	private final View view;

	public NumberBaseballGame(View view) {
		this.view = view;
	}

	@Override
	public void run() {
		NumberBaseballRound round = new NumberBaseballRound(view);
		do {
			play(round);
		} while (toBeContinued());
	}

	private void play(NumberBaseballRound round) {
		round.start();
	}

	private boolean toBeContinued() {
		return true; // todo : create continuation type (enum) and get from it
	}
}
