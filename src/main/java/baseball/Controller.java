package baseball;

import static baseball.Valid.*;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class Controller {
	private static final String RESTART_REQUEST_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

	public Controller() {
	}

	public void start() {
		String state = GAME_START;
		Computer computer = new Computer();
		while (state.equals(GAME_START)) {
			computer.init();
			Game game = new Game(computer);
			game.play();
			printRestartRequestMessage();
			String userInputMessage = readLine();
			if (validateRestartMessage(userInputMessage)) {
				state = userInputMessage;
			}
		}
	}

	private void printRestartRequestMessage() {
		System.out.println(RESTART_REQUEST_MESSAGE);
	}
}
