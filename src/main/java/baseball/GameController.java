package baseball;

import java.util.List;

import baseball.logic.BaseballGameJudge;
import baseball.logic.GameResultObject;
import baseball.utill.RandomNumberGenerator;
import baseball.view.InputValidation;
import baseball.view.OutputDisplay;

public class GameController {
	private boolean isEnd = false;

	public String play() {
		RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
		InputValidation inputValidation = new InputValidation();
		BaseballGameJudge baseballGameJudge = new BaseballGameJudge();

		List<Integer> randomNumbers = randomNumberGenerator.generateRandomNumber();

		while (!isEnd) {
			List<Integer> userNumbers = inputValidation.inputNumberFromUser();
			isThreeStrike(baseballGameJudge.judgeGameResult(randomNumbers, userNumbers));
		}

		return inputValidation.inputRestartFromUser();
	}

	private void isThreeStrike(GameResultObject gameResultObject) {
		OutputDisplay outputDisplay = new OutputDisplay();
		isEnd = gameResultObject.getIsEnd();

		if (isEnd) {
			outputDisplay.displayEndMsg();
			return;
		}
		outputDisplay.displayResult(gameResultObject);
	}
}
