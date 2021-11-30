package baseball;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Game {

	public static void play() {
		Computer computer = new Computer();

		boolean running = true;
		do {
			System.out.print(Const.INPUT_MESSAGE);
			User user = new User();
			user.readInputNumber();

			Hint hint = new Hint(computer.getAnswerNumber(), user.getInputNumber());
			hint.printHintMessage();

			if (hint.isAllStrike())
				running = false;

		} while (running);
	}

	public static boolean askNewGameOrExit() {
		System.out.println(Const.NEW_GAME_OR_EXIT);
		String userSelect = Console.readLine();

		if (Const.SELECT_NEW_GAME.equals(userSelect))
			return true;

		if (Const.SELECT_EXIT.equals(userSelect))
			return false;

		throw new IllegalArgumentException();
	}
}
