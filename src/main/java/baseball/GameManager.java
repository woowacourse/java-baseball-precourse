package baseball;

import java.util.List;

public class GameManager {

    public GameManager() {

    }

    public boolean playGame(BaseballGame baseballGame) {
        List<Integer> answer = baseballGame.makeRandomNumber();
        Player player = new Player();
        while (!baseballGame.collect()) {
            baseballGame.gradeAnswer(player.submitAnswer());
        }
        return player.askForMore();
    }
}
