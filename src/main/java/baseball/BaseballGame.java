package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.Map;

public class BaseballGame {

    public static final String STRIKE_ENGLISH = "strike";
    public static final String BALL_ENGLISH = "ball";
    public static final String COLLECT_ANSWER_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    public static final String RESTART_OR_NOT_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    public static final String GAME_RESTART_NUMBER = "1";

    public void startGame() {

        do {
            progressGame();
            printRestartOrNotMessage();
        } while (decideRestartGame());

    }

    public String inputRestartOrNotNumber() {
        return Console.readLine();
    }

    private boolean decideRestartGame() {
        boolean decide = false;

        String restartOrNotNumber = inputRestartOrNotNumber();

        if (restartOrNotNumber.equals(GAME_RESTART_NUMBER)) {
            decide = true;
        }

        return decide;
    }

    private void printRestartOrNotMessage() {
        System.out.println(RESTART_OR_NOT_MESSAGE);
    }

    private void printCorrectAnswer() {
        System.out.println(COLLECT_ANSWER_MESSAGE);
    }

    public void progressGame() {
        User user = new User();

        String answer = user.connectEachAnswerNumbers();
        user.printInputMessage();
        String guessAnswer = user.inputPlayerNumber();

        while (!user.checkAnswer(answer, guessAnswer)) {
            final Map<String, Integer> strikeBallCount = user.countStrikeBallNumber(answer, guessAnswer);

            int strikeCount = strikeBallCount.get(STRIKE_ENGLISH);
            int ballCount = strikeBallCount.get(BALL_ENGLISH);

            String hitMessage = user.writeHintMessage(strikeCount, ballCount);
            user.printHintMessage(hitMessage);

            user.printInputMessage();
            guessAnswer = user.inputPlayerNumber();
        }

        printCorrectAnswer();
    }

}
