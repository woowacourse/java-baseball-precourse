package baseball.controller;

import baseball.domain.DeterminationPitching;
import baseball.utils.Computer;
import baseball.utils.Game;
import baseball.utils.User;
import baseball.view.GameDisplay;

import java.util.Map;

public class BaseballGame {

    public void startGame() {
        progressGame();
    }

    private void progressGame() {
        String answer = Computer.makeAnswerNumber();

        GameDisplay.printInputMessage();

        String guessNumber = User.inputGuessNumber();
        User.validateGuessNumber(guessNumber);

        while (!Game.checkCorrect(answer, guessNumber)) {
            final Map<String, Integer> strikeBallCount = Game.countStrikeBall(answer, guessNumber);

            int strikeCount = strikeBallCount.get(String.valueOf(DeterminationPitching.STRIKE));
            int ballCount = strikeBallCount.get(String.valueOf(DeterminationPitching.BALL));

            String hitMessage = Game.writeHintMessage(strikeCount, ballCount);
            GameDisplay.printHintMessage(hitMessage);

            GameDisplay.printInputMessage();
            guessNumber = User.inputGuessNumber();
            User.validateGuessNumber(guessNumber);
        }

        GameDisplay.printCorrectAnswerMessage();
        GameDisplay.printRestartOrNotMessage();

        if (Game.decideRestartGame()) {
            progressGame();
        }

    }

}
