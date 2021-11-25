package baseball;

import java.util.Map;

public class BaseballGame {

    public static final String STRIKE_ENGLISH = "strike";
    public static final String BALL_ENGLISH = "ball";
    public static final String COLLECT_ANSWER_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    public static final String RESTART_OR_NOT_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public void startGame() {

            progressGame();
            printRestartOrNotMessage();

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
        String guessNumber = user.inputPlayerNumber();

        while (user.checkAnswer(answer, guessNumber)) {
            final Map<String, Integer> strikeBallCount = user.countStrikeBallNumber(answer, guessNumber);

            int strikeCount = strikeBallCount.get(STRIKE_ENGLISH);
            int ballCount = strikeBallCount.get(BALL_ENGLISH);

            String hitMessage = user.writeHintMessage(strikeCount, ballCount);
            user.printHintMessage(hitMessage);

            user.printInputMessage();
            guessNumber = user.inputPlayerNumber();
        }

        printCorrectAnswer();
    }

}
