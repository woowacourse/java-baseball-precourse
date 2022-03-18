package baseball;

import java.util.List;

public class GameManager {

    public GameManager() {

    }

    public boolean playGame(BaseballGame baseballGame) {
        List<Integer> answer = baseballGame.makeRandomNumber();
        Player player = new Player();

        int[] grade = baseballGame.gradeAnswer(answer, player.submitAnswer());
        while (!baseballGame.correct(grade)) {
            grade = baseballGame.gradeAnswer(answer, player.submitAnswer());
        }
        return player.askForMore();
    }
}
