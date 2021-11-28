package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.Map;

public class BaseballGame {

    public static final String RESTART_SIGNAL = "1";
    public static final String NEW_LINE = "\n";

    public void startGame() {

        do {
            progressGame();
            printRestartOrNotMessage();
        } while (decideRestartGame());

    }

    public void progressGame() {
        User user = new User();

        String answer = user.connectEachAnswerNumbers();
        user.printInputMessage();

        String guessAnswer = user.inputPlayerNumber();

        while (!user.checkAnswer(answer, guessAnswer)) {
            final Map<String, Integer> strikeBallCount = user.countStrikeBallNumber(answer, guessAnswer);

            int strikeCount = strikeBallCount.get(String.valueOf(DeterminationPitching.STRIKE_ENGLISH));
            int ballCount = strikeBallCount.get(String.valueOf(DeterminationPitching.BALL_ENGLISH));

            String hitMessage = user.writeHintMessage(strikeCount, ballCount);
            user.printHintMessage(hitMessage);

            user.printInputMessage();
            guessAnswer = user.inputPlayerNumber();
        }

        printCorrectAnswerMessage();
    }

    public String inputRestartOrNotNumber() {
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
        System.out.println(Messages.RESTART_OR_NOT_MESSAGE);
    }

    private void printCorrectAnswerMessage() {
        System.out.println(Messages.THREE_STRIKE_MESSAGE + NEW_LINE + Messages.COLLECT_ANSWER_MESSAGE);
    }

}
