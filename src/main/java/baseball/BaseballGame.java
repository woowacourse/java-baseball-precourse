package baseball;

import java.util.Map;

public class BaseballGame {

    public static final String STRIKE_ENGLISH = "strike";
    public static final String BALL_ENGLISH = "ball";

    public void startGame() {
        progressGame();
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

            user.printInputMessage();
            guessNumber = user.inputPlayerNumber();
        }
    }

}
