package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Game {
	Computer computer = new Computer();
	BallRepository computerBalls = computer.getBalls();
	Referee referee = new Referee(computerBalls);
	boolean game = true;

	public Boolean decideWhetherRestart() {
		System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
		int input = Integer.parseInt(Console.readLine());
		return input == 1;
	}

	public void run() {
		while (game) {
			System.out.print("숫자를 입력해주세요 : ");
			String input = Console.readLine();
			User user = new User(input);
			BallRepository userBalls = user.getBalls();
			referee.judge(userBalls.getBalls());
			Output.printResult(referee.getStrikeCount(), referee.getBallCount());
			if (referee.getStrikeCount() == 3) {
				setForRestarting();
			}
			referee.clear();
		}
	}

	public void setForRestarting() {
		System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
		game = decideWhetherRestart();
		if (game) {
			computer = new Computer();
			computerBalls = computer.getBalls();
			referee = new Referee(computerBalls);
		}
	}
}
