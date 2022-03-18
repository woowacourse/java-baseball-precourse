package baseball;

import java.util.List;

public class GameManager {

    public GameManager() {

    }

    public boolean playGame(BaseballGame baseballGame) {
        Player player = new Player();
        List<Integer> playerAnswer = player.submitAnswer();

        List<Integer> answer = baseballGame.makeRandomNumber();
        int[] grade = baseballGame.gradeAnswer(answer, playerAnswer);

        while (!baseballGame.correct(grade)) {
            playerAnswer = player.submitAnswer();
            grade = baseballGame.gradeAnswer(answer, playerAnswer);
        }

        return player.askForMore();
    }
}
