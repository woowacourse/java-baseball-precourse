package baseball;

import logic.BaseballGameJudge;
import logic.GameResultObject;
import utill.RandomNumberGenerator;
import view.InputValidation;
import view.OutputDisplay;

import java.util.List;

public class GameController {
    private boolean isEnd = false;

    public String play() {
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        InputValidation inputValidation = new InputValidation();
        BaseballGameJudge baseballGameJudge = new BaseballGameJudge();

        List<Integer> randomNumbers = randomNumberGenerator.generateRandomNumber();

        while (!isEnd) {
            List<Integer> userNumbers = inputValidation.inputNumberFromUser();
            GameResultObject gameResultObject = baseballGameJudge.judgeGameResult(randomNumbers, userNumbers);
            isThreeStrike(gameResultObject);
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
