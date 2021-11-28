package baseball.game;

import java.util.ArrayList;
import java.util.List;

import baseball.messages.GameMessage;
import baseball.messages.PrintResult;
import baseball.utils.PlayerInput;
import baseball.utils.RandomNumbers;
import camp.nextstep.edu.missionutils.Console;

public class BaseBallGame {
	private static final int NUM_OF_DIGIT = 3;
	private static final String GAME_FINISH = "2";
	private static final int END_STRIKE = 3;
	private static final int ZERO = 0;

	private static List<Integer> randomNumbers;
	private static List<Integer> playerNumbers;

	private static PlayerInput playerInput;
	private static BaseBallReferee baseBallReferee;
	private static PrintResult printResult;

	public static void init() {
		randomNumbers = RandomNumbers.getRandomNumbers();
		playerInput = new PlayerInput(NUM_OF_DIGIT);
		baseBallReferee = new BaseBallReferee(NUM_OF_DIGIT);
		printResult = new PrintResult();
	}

	public static boolean playGame() {
		int strikeCount = 0;
		int ballCount = 0;
		do {
			System.out.print(GameMessage.INPUT_MESSAGE);
			playerNumbers = playerInput.getInput();
			strikeCount = baseBallReferee.getStrikeCount(randomNumbers, playerNumbers);
			ballCount = baseBallReferee.getBallCount(randomNumbers, playerNumbers);
		} while (resultOfGame(strikeCount, ballCount));

		String decisionOfPlayer = playerInput.getIsContinue();
		if (decisionOfPlayer.equals(GAME_FINISH)) {
			return false;
		}

		return true;
	}

	private static boolean resultOfGame(int strikeCount, int ballCount) {
		if (strikeCount == END_STRIKE) {
			printResult.printEndGame();
			return false;
		}
		if (strikeCount == ZERO && ballCount == ZERO) {
			printResult.printNothing();
			return true;
		}
		if (strikeCount == ZERO) {
			printResult.printBall(ballCount);
			return true;
		}
		if (ballCount == ZERO) {
			printResult.printStrike(strikeCount);
			return true;
		}

		printResult.printBallAndStrike(strikeCount, ballCount);
		return true;
	}

}
