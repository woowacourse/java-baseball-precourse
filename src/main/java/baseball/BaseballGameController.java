package baseball;

import camp.nextstep.edu.missionutils.Console;

public class BaseballGameController {
	private static final String DECIDING_RESTART_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
	private final Enemy enemy;
	private final Player player;
	private final BaseballGameModel baseballGameModel;
	private final HintSentenceGenerator hintSentenceGenerator;

	private int[] enemyNum;
	private int[] playerNum;
	private int strikeCount;
	private int ballCount;

	public BaseballGameController() {
		initializeNums();
		enemy = new Enemy();
		player = new Player();
		baseballGameModel = BaseballGameModel.getBaseballGameModel();
		hintSentenceGenerator = HintSentenceGenerator.getHintSentenceGenerator();
	}

	private void initializeNums() {
		enemyNum = new int[3];
		playerNum = new int[3];
	}

	public void startGame() {
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
		if (strikeCount == 3) {
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
		if (charRestartValue == '1') {
			return true;
		} else if (charRestartValue == '2') {
			return false;
		} else {
			throw new IllegalArgumentException();
		}
	}
}
