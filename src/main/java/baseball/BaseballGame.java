package baseball;

import java.util.Map;

public class BaseballGame {

    public void startGame() {
        progressGame();
    }

    public void progressGame() {
        User user = new User();

        String answer = user.connectEachAnswerNumbers();
        user.printInputMessage();
        String guessNumber = user.inputPlayerNumber();

        while (user.checkAnswer(answer, guessNumber)) {


            user.printInputMessage();
            guessNumber = user.inputPlayerNumber();
        }
    }

}
