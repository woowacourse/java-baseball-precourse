package baseball.controller;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import baseball.constants.Constant;
import baseball.constants.Message;
import baseball.domain.Computer;
import baseball.domain.Player;
import camp.nextstep.edu.missionutils.Console;


public class GameHandler {
	private static GameHandler instance = new GameHandler();
	private Player player;
	private Computer computer;

	private GameHandler() {
	}

	public static GameHandler getInstance() {
		if (instance == null) {
			return new GameHandler();
		}

		return instance;
	}

	public void run() {
		int game = Constant.START;

		while (game != Constant.PROGRAM_EXIT) {
			game = start();
		}
	}

	private int start() {
		int mode = init();
		while (mode == Constant.KEEP_GOING) {
			mode = playing();
		}

		return restart();
	}

	private int init() {
		player = Player.getInstance();
		computer = Computer.getInstance();
		return Constant.KEEP_GOING;
	}

	private int restart() {
		System.out.println(Message.GAME_END);
		System.out.println(Message.GAME_RESTART);
		String input = Console.readLine();

		if (input.equals("1")) {
			return Constant.RESTART;
		} else if (input.equals("2")) {
			return Constant.PROGRAM_EXIT;
		}

		throw new IllegalArgumentException();
	}

	private boolean isAnswer(Map<String, Integer> hint) {
		return hint.get(Constant.STRIKE) == 3;
	}

	private int playing() {
		String playerInput = getPlayerInput();
		if (!checkValidInput(playerInput)) {
			throw new IllegalArgumentException();
		}
		player.playerInput(playerInput);
		Map<String, Integer> hint = computer.generateHint(player.submitTryNumber());
		showHint(hint);
		if (isAnswer(hint)) {
			return Constant.GAME_EXIT;
		}

		return Constant.KEEP_GOING;
	}

	private String getPlayerInput() {
		System.out.print(Message.INPUT);
		return Console.readLine();
	}

	private void showHint(Map<String, Integer> hint) {
		int ball = hint.get(Constant.BALL);
		int strike = hint.get(Constant.STRIKE);
		if (ball + strike == 0) {
			System.out.println(Message.NOTHING);
		} else if (ball == 0 && strike != 0) {
			System.out.println(strike + Message.STRIKE);
		} else if (ball != 0 && strike == 0) {
			System.out.println(ball + Message.BALL);
		} else if (ball != 0 && strike != 0) {
			System.out.println(ball + Message.BALL + strike + Message.STRIKE);
		}
	}

	private boolean checkValidInput(String playerInput) {
		if (playerInput.length() == 3) {
			return !checkDuplicated(playerInput) && checkIsNumbers(playerInput);
		}

		return false;
	}

	private boolean checkIsNumbers(String playerInput) {
		for (String input : playerInput.split("")) {
			if (!(48 < input.charAt(0) && input.charAt(0) < 58)) {
				return false;
			}
		}
		return true;
	}

	private boolean checkDuplicated(String playerInput) {
		Set<Character> set = new HashSet<>();
		for (String input : playerInput.split("")) {
			if (!set.add(input.charAt(0))) {
				return true;
			}
		}
		return false;
	}
}
