package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Game {
	Computer computer = new Computer();
	Referee referee = new Referee(computer.getBalls());
	User user = new User();
	boolean game = true;

	public void run() {
		while (game) {
			Output.printInputView();
			user.insertNumbers(Console.readLine());
			referee.judge(user.getBalls());
			Output.printResult(referee.getStrikeCount(), referee.getBallCount());
			if (referee.getStrikeCount() == 3) {
				setForRestarting();
			}
			referee.clearScore();
		}
	}

	public void setForRestarting() {
		Output.printFinishView();
		game = decideWhetherRestart();
		if (game) {
			computer.createNewNumbers();
			referee.setBalls(computer.getBalls());
		}
	}

	public Boolean decideWhetherRestart() {
		Output.printRequestRestartOrFinish();
		int input = Integer.parseInt(Console.readLine());
		return input == 1;
	}
}
