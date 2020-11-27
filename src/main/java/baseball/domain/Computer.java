package baseball.domain;

import baseball.model.GameResult;
import utils.BaseballDigitsGenerator;

import java.util.List;

public class Computer {

    private List<Integer> targetDigits;

    public Computer() {
        init();
    }

    private void init() {
        this.targetDigits = BaseballDigitsGenerator.generateRandomDigitsList();
    }

    public void setTargetDigits(List<Integer> targetDigits) {
        this.targetDigits = targetDigits;
    }

    public String guessTargetDigits(List<Integer> guessDigits) {
        GameResult gameResult = new GameResult();

        for (int i = 0; i < BaseballDigitsGenerator.BASEBALL_LEN; i++) {
            int guessDigit = guessDigits.get(i);
            int targetDigit = targetDigits.get(i);

            if (targetDigit == guessDigit) {
                gameResult.countStrike();
            }

            if (targetDigit != guessDigit && targetDigits.contains(guessDigit)) {
                gameResult.countBall();
            }
        }
        return gameResult.getResult();
    }
}
