package baseball;

import java.util.Map;

import camp.nextstep.edu.missionutils.Console;

public class BaseballGame {

    private static final String RESTART_SIGNAL = "1";
    private static final String NEW_LINE = "\n";

    protected void startGame() {
        progressGame();
    }

    private void progressGame() {
        User user = new User();
        String answer = user.makeAnswerNumber();
        System.out.println("answer:" + answer);

        user.printInputMessage();
        String guessNumber = user.inputGuessNumber();
        user.validateGuessNumber(guessNumber);

        while (!user.checkCorrect(answer, guessNumber)) {
            final Map<String, Integer> strikeBallCount = user.countStrikeBall(answer, guessNumber);

            int strikeCount = strikeBallCount.get(String.valueOf(DeterminationPitching.STRIKE));
            int ballCount = strikeBallCount.get(String.valueOf(DeterminationPitching.BALL));

            String hitMessage = user.writeHintMessage(strikeCount, ballCount);
            user.printHintMessage(hitMessage);

            user.printInputMessage();
            guessNumber = user.inputGuessNumber();
            user.validateGuessNumber(guessNumber);
        }

        printCorrectAnswerMessage();
        printRestartOrNotMessage();

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

    private void printRestartOrNotMessage() {
        System.out.println(Messages.RESTART_OR_NOT_MESSAGE.printMessages());
    }

    private void printCorrectAnswerMessage() {
        System.out.println(Messages.THREE_STRIKE_MESSAGE.printMessages() + NEW_LINE + Messages.COLLECT_ANSWER_MESSAGE.printMessages());
    }

}
