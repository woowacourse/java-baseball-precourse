package baseball.game;

import java.util.ArrayList;
import java.util.List;

import baseball.utils.PlayerInput;
import baseball.utils.RandomNumbers;
import camp.nextstep.edu.missionutils.Console;

public class BaseBallGame {
	private static final int NUM_OF_DIGIT = 3;

	private static List<Integer> randomNumbers;
	private static List<Integer> playerNumbers;

	private static PlayerInput playerInput;
	private static BaseBallReferee baseBallReferee;

	public static void init() {
		randomNumbers = RandomNumbers.getRandomNumbers();
		playerInput = new PlayerInput(NUM_OF_DIGIT);
		baseBallReferee = new BaseBallReferee(NUM_OF_DIGIT);
	}

	public static void playGame(){
		playerNumbers = playerInput.getInput();
	}












}
