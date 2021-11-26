package baseball.game;

import java.util.ArrayList;
import java.util.List;

import baseball.messages.GameMessage;
import baseball.utils.PlayerInput;
import baseball.utils.RandomNumbers;
import camp.nextstep.edu.missionutils.Console;

public class BaseBallGame {
	private static final int NUM_OF_DIGIT = 3;
	private static final String GAME_CONTINUE = "1";
	private static final String GAME_FINISH = "2";

	private static List<Integer> randomNumbers;
	private static List<Integer> playerNumbers;

	private static PlayerInput playerInput;
	private static BaseBallReferee baseBallReferee;

	public static void init() {
		randomNumbers = RandomNumbers.getRandomNumbers();
		playerInput = new PlayerInput(NUM_OF_DIGIT);
		baseBallReferee = new BaseBallReferee(NUM_OF_DIGIT);
	}

	public static boolean playGame(){
		int strikeCount;
		int ballCount;
		do {
			System.out.print(GameMessage.INPUT_MESSAGE);
			playerNumbers = playerInput.getInput();
			strikeCount = baseBallReferee.getStrikeCount(randomNumbers, playerNumbers);
			ballCount = baseBallReferee.getBallCount(randomNumbers, playerNumbers);
		} while(resultOfGame(strikeCount, ballCount));

		String decisionOfPlayer = playerInput.getIsContinue();
		if(decisionOfPlayer.equals(GAME_FINISH)){
			return false;
		}

		return true;
	}

	private static boolean resultOfGame(int strikeCount, int ballCount) {

		return false;
	}












}
