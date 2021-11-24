package baseball;

public class GameManager {
	private Console console;
	private BaseballNumberGenerator generator;
	private BaseballNumberReferee referee;
	private JudgeResultFormatter formatter;
	private String answerNumber;
	private boolean isGameFinished;

	public GameManager(Console console, BaseballNumberGenerator generator, BaseballNumberReferee referee, JudgeResultFormatter formatter) {
		this.console = console;
		this.generator = generator;
		this.referee = referee;
		this.formatter = formatter;
	}

	public void startGame() {
		answerNumber = generator.generate();
		isGameFinished = false;
		console.print("숫자를 입력하세요 : ");
	}

	public void handleGuessNumber(String guessNumber) {
		JudgeResult result = referee.judge(guessNumber, answerNumber);

		console.println(formatter.format(result));

		if(result.isStrikeOut()) {
			console.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
			console.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
			isGameFinished = true;
			return;
		}

		console.print("숫자를 입력하세요 : ");
	}

	public boolean isGameFinished() {
		return isGameFinished;
	}

	public void handleOptionNumber(String optionNumber) {
		if(optionNumber.equals("1")) {
			startGame();
		}
	}
}
