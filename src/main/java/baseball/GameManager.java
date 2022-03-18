package baseball;

import java.util.List;

public class GameManager {

    private Player player;

    public GameManager() {
        player = new Player();
    }

    public void playGame(BaseballGame baseballGame) {
        List<Integer> playerAnswer = player.submitAnswer();

        List<Integer> answer = baseballGame.makeRandomNumber();
        int[] grade = baseballGame.gradeAnswer(answer, playerAnswer);

        while (!baseballGame.correct(grade)) {
            playerAnswer = player.submitAnswer();
            grade = baseballGame.gradeAnswer(answer, playerAnswer);
        }

        while (player.askForMore()) {
            playGame(new BaseballGame());
        }
    }
}
