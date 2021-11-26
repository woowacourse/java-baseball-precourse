package baseball.domain;

import baseball.view.InputView;

public class Game {
	private final User user = new User();

	public void start() {
		user.setNumberOfUser(InputView.getInput());
	}
}
