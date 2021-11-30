package baseball;

public class BaseballGame {
	private static final String BASEBALL_GAME_INPUT_MESSAGE = "숫자를 입력해주세요 : ";

	private User user;
	private Computer computer;

	protected BaseballGame() {
		this.user = new User();
		this.computer = new Computer();
	}

	protected void startGame() {
		while(true) {
			computer.generateComputerRandomNum();
			while (true) {
				System.out.println(BASEBALL_GAME_INPUT_MESSAGE);
				System.out.println(user.inputNum());
			}
		}
	}
}
