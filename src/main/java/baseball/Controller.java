package baseball;

import static baseball.Valid.*;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class Controller {
	public Controller() {
	}

	public void start() {
		Computer computer = new Computer();
		String state = GAME_START;

		while (state.equals(GAME_START)) {
			computer.init();
			Game game = new Game(computer);
			game.play();
			printSuccessMessage();
			String userInputMessage = readLine();
			if (validateRestartMessage(userInputMessage)) {
				state = userInputMessage;
			}
		}
	}

	private void printSuccessMessage() {
		String successMessage = "3개의 숫자를 모두 맞히셨습니다! 게임 종료\n"
			+ "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
		System.out.println(successMessage);
	}
}
