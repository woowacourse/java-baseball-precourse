package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Game {
	Computer computer = new Computer();
	BallRepository computerBalls = computer.getBalls();
	Referee referee = new Referee(computerBalls);
	boolean game = true;

	public void run() {
		while (game) {
			System.out.print("숫자를 입력해주세요 : ");
			String input = Console.readLine();
			User user = new User(input);
			BallRepository userBalls = user.getBalls();
			referee.judge(userBalls.getBalls());
		}
	}
}
