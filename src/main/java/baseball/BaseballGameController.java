package baseball;

import static util.Constants.*;

import camp.nextstep.edu.missionutils.Console;

public class BaseballGameController {
	private final Enemy enemy;
	private final Player player;
	private final BaseballGameModel baseballGameModel;
	private final HintSentenceGenerator hintSentenceGenerator;

	private int[] enemyNum;
	private int[] playerNum;

	public BaseballGameController() {
		initializeNums();
		enemy = Enemy.getEnemy();
		player = Player.getPlayer();
		baseballGameModel = BaseballGameModel.getBaseballGameModel();
		hintSentenceGenerator = HintSentenceGenerator.getHintSentenceGenerator();
	}

	private void initializeNums() {
		enemyNum = new int[GAME_NUMBER_LENGTH];
		playerNum = new int[GAME_NUMBER_LENGTH];
	}

	public void startGame() {
		int strikeCount;
		int ballCount;
		initializeNums();
		enemy.setEnemyNum(enemyNum);
		do {
			player.takePlayerNum(playerNum);
			strikeCount = baseballGameModel.getStrike(playerNum, enemyNum);
			ballCount = baseballGameModel.getBall(playerNum, enemyNum);
			printResult(strikeCount, ballCount);
		} while (!baseballGameModel.checkResult(strikeCount));
	}

	private boolean printResult(int strikeCount, int ballCount) {
		String hintSentence = hintSentenceGenerator.makeHintSentence(strikeCount, ballCount);
		System.out.println(hintSentence);
		if (strikeCount == GAME_NUMBER_LENGTH) {
			return true;
		}
		return false;
	}

	public boolean decideToRestart() {
		String stringRestartValue;
		char charRestartValue;
		System.out.println(DECIDING_RESTART_MESSAGE);
		stringRestartValue = Console.readLine();
		if (stringRestartValue.length() != 1) {
			throw new IllegalArgumentException();
		}
		charRestartValue = stringRestartValue.charAt(0);
		if (charRestartValue == GAME_RESUME) {
			return true;
		} else if (charRestartValue == GAME_OVER) {
			return false;
		} else {
			throw new IllegalArgumentException();
		}
	}
}
