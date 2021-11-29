package baseball;

import java.util.Map;

import baseball.domain.DeterminationPitching;
import baseball.view.Input;
import baseball.view.Output;
import camp.nextstep.edu.missionutils.Console;

public class BaseballGame {

    private static final String RESTART_SIGNAL = "1";

    protected void startGame() {
        progressGame();
    }

    private void progressGame() {
        User user = new User();
        String answer = user.makeAnswerNumber();
        System.out.println("answer:" + answer);

        Output output = new Output();
        output.printInputMessage();

        Input input = new Input();
        String guessNumber = input.inputGuessNumber();
        user.validateGuessNumber(guessNumber);

        while (!user.checkCorrect(answer, guessNumber)) {
            final Map<String, Integer> strikeBallCount = user.countStrikeBall(answer, guessNumber);

            int strikeCount = strikeBallCount.get(String.valueOf(DeterminationPitching.STRIKE));
            int ballCount = strikeBallCount.get(String.valueOf(DeterminationPitching.BALL));

            String hitMessage = user.writeHintMessage(strikeCount, ballCount);
            output.printHintMessage(hitMessage);

            output.printInputMessage();
            guessNumber = input.inputGuessNumber();
            user.validateGuessNumber(guessNumber);
        }

        output.printCorrectAnswerMessage();
        output.printRestartOrNotMessage();

        if (decideRestartGame()) {
            progressGame();
        }

    }

    private String inputRestartOrNotNumber() {
        return Console.readLine();
    }

    private boolean decideRestartGame() {
        boolean decide = false;

        String restartOrNotNumber = inputRestartOrNotNumber();

        if (restartOrNotNumber.equals(RESTART_SIGNAL)) {
            decide = true;
        }

        return decide;
    }

}
