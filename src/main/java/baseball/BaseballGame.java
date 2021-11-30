package baseball;

public class BaseballGame {
	private static final String BASEBALL_GAME_INPUT_MESSAGE = "숫자를 입력해주세요 : ";
	private static final String BASEBALL_GAME_RESTART_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
	private static final int RESTART = 1;
	private static final int EXIT = 2;

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
				result.compareNum(computer.getComputerNum(), user.inputNum());
				result.printResult();
			}
			System.out.println(BASEBALL_GAME_RESTART_MESSAGE);
			if (!checkRestartGame()) {
				break;
			} else {
				result.init();
			}
		}
	}

	private boolean checkRestartGame() {
		int userChoice = user.inputChoice();
		if (userChoice == RESTART) {
			return true;
		} else if (userChoice == EXIT) {
			return false;
		} else {
			return false;
		}
	}
}
