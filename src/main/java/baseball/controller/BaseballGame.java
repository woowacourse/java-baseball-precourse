package baseball.controller;

import baseball.model.BallCount;
import baseball.model.Numbers;
import baseball.view.InputView;

public class BaseballGame {
    private final Numbers answer;

    private BaseballGame(Numbers answer) {
        this.answer = answer;
    }

    public static BaseballGame createNewGame(Numbers answer) {
        return new BaseballGame(answer);
    }

    public void play() {
        Numbers userNumbers = getNumbersFromUser();
        BallCount ballCount = answer.calculateBallCountWith(userNumbers);
    }

    private Numbers getNumbersFromUser() {
        try {
            return Numbers.valueOf(InputView.getNumbers());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getNumbersFromUser();
        }
    }
}
