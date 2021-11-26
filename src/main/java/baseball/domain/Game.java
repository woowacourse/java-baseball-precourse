package baseball.domain;

import baseball.view.InputView;

public class Game {
	private final User user = new User();
	private Computer computer = new Computer();

	public void start() {
		computer.generateAnswer();
		user.setNumberOfUser(InputView.getInput());
	}
}
