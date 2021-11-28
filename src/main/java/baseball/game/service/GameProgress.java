package baseball.game.service;

import static baseball.game.message.GuideMessage.*;
import static baseball.game.service.NumberCalculation.*;
import static baseball.game.service.NumberValidation.*;

import camp.nextstep.edu.missionutils.Console;

public class GameProgress {

	public static boolean startGame(int[] answerArr) {
		boolean notSolved = true;
		while (notSolved) {
			String inputString = enterNumber();
			String message = calculateNumber(answerArr, Integer.parseInt(inputString));
			System.out.print(message);
			if (message.equals(WIN_GAME_MESSAGE)) {
				return askRestartOrEnd();
			}
		}
		return false;
	}

	public static String enterNumber() {
		System.out.print(ENTER_NUM_MESSAGE);
		String inputString = Console.readLine();
		validateThreeDigitNumber(inputString);
		return inputString;
	}

	public static String calculateNumber(int[] answerArr, int inputNumber) {
		return checkInputNumber(answerArr, inputNumber);
	}

	public static boolean askRestartOrEnd() {
		String inputString = Console.readLine();
		validateSingleDigitNumber(inputString);
		if (inputString.equals("1")) {
			return true;
		}
		return false;
	}

}
