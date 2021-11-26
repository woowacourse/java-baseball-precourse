package baseball.domain;

import baseball.view.InputView;

public class Game {
	private final User user;
	private final Computer computer;
	private Referee referee;

	public Game() {
		user = new User();
		computer = new Computer();
		referee = new Referee();
	}

	public void start() {
		computer.generateAnswer();
		user.setNumberOfUser(InputView.getInput());
		referee.getJudgment(user, computer);

	}
}
