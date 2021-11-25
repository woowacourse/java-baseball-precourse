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
		Game game = new Game(computer);
		while (state.equals(GAME_START)) {
			game.init();
			game.play();
			printRestartRequestMessage();
			state = readUserRestartRequest();
		}
	}

	private void printRestartRequestMessage() {
		System.out.println(RESTART_REQUEST_MESSAGE);
	}

	private String readUserRestartRequest() {
		String userRestartRequest = readLine();
		if (validateRestartRequest(userRestartRequest) != VALID_SUCCESS) {
			throw new IllegalArgumentException();
		}
		return userRestartRequest;
	}
}
