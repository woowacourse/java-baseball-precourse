package baseball;

public class BaseballGame {
	private static final String BASEBALL_GAME_INPUT_MESSAGE = "숫자를 입력해주세요 : ";

	private User user;
	private Computer computer;
	private Result result;

	protected BaseballGame() {
		this.user = new User();
		this.computer = new Computer();
		this.result = new Result();
	}

	protected void startGame() {
		while(true) {
			computer.generateComputerRandomNum();
			while (!result.getExit()) {
				System.out.println(BASEBALL_GAME_INPUT_MESSAGE);
				result.compareNum(computer.getComputermNum(), user.inputNum());
				result.printResult();
			}
			break;
		}
	}
}
