package baseball;

public class GameManager {
	private Console console;
	private BaseballNumberGenerator generator;
	private BaseballNumberReferee referee;
	private JudgeResultFormatter formatter;
	private String answerNumber;

	public GameManager(Console console, BaseballNumberGenerator generator, BaseballNumberReferee referee, JudgeResultFormatter formatter) {
		this.console = console;
		this.generator = generator;
		this.referee = referee;
		this.formatter = formatter;
	}

	public void startGame() {
		answerNumber = generator.generate();
		console.print("숫자를 입력하세요 : ");
	}

	public void handleGuessNumber(String guessNumber) {
		JudgeResult result = referee.judge(guessNumber, answerNumber);
		console.println(formatter.format(result));

		if(!result.isStrikeOut()) {
			console.print("숫자를 입력하세요 : ");
		}
	}

	public boolean isGameFinished() {
		return false;
	}
}
