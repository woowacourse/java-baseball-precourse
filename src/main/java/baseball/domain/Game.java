package baseball.domain;

import baseball.view.InputView;

public class Game {
	private final User user;
	private final Computer computer;

	public Game() {
		user = new User();
		computer = new Computer();

	}

	public void start() {
		computer.generateAnswer();
		user.setNumberOfUser(InputView.getInput());
		Referee.getJudgment(user, computer);
	}
}
