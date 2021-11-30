package baseball;

import java.util.Map;

import baseball.domain.DeterminationPitching;
import baseball.utils.Computer;
import baseball.utils.Game;
import baseball.utils.User;
import baseball.view.GameDisplay;

public class BaseballGame {

    public static void startGame() {
        progressGame();
    }

    private static void progressGame() {
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

        String restartOrNotNumber = User.inputRestartOrNotNumber();
        Game.validateRestartNumber(restartOrNotNumber);

        if (Game.decideRestartGame(restartOrNotNumber)) {
            progressGame();
        }

    }

}
