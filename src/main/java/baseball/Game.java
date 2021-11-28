package baseball;

import static baseball.Constant.*;

import camp.nextstep.edu.missionutils.Console;

public class Game {
	private final Computer computer = new Computer();
	private final Referee referee = new Referee(computer.getBalls());
	private final User user = new User();
	private boolean status = true;

	public void run() {
		while (status) {
			Output.printInputView();
			user.insertNumbers(Console.readLine());
			referee.judge(user.getBalls());
			Output.printResult(referee.getStrikeCount(), referee.getBallCount());
			if (referee.getStrikeCount() == MAX_STRIKE_COUNT) {
				setForRestarting();
			}
			referee.clearScore();
		}
	}

	public void setForRestarting() {
		Output.printFinishView();
		status = decideWhetherRestart();
		if (status) {
			computer.createNewNumbers();
			referee.setBalls(computer.getBalls());
		}
	}

	public Boolean decideWhetherRestart() {
		Output.printRequestRestartOrFinish();
		int input = Integer.parseInt(Console.readLine());
		validateInputWhetherRestart(input);
		return input == INPUT_RESTART;
	}

	public void validateInputWhetherRestart(int input) {
		if (input == INPUT_RESTART || input == INPUT_FISH) {
			return;
		}
		throw new IllegalArgumentException();
	}
}
