package baseball;

import static util.GameConstant.*;

public class BaseballGame {
    private GamePlayer gamePlayer;
    private GameProvider gameProvider;

    public BaseballGame(GamePlayer gamePlayer, GameProvider gameProvider) {
        this.gamePlayer = gamePlayer;
        this.gameProvider = gameProvider;
    }

    public void run() {
        while (gameProvider.getGameStatus().equals(ON_GOING)) {
            gamePlayer.insertAnswer();
            GameScore gameScore = gameProvider.checkAnswer(gamePlayer.getPlayerAnswer());
            gameScore.printResult();

            if (gameProvider.getGameStatus().equals(CORRECT)) {
                System.out.println(THREE_STRIKE);
                System.out.println(ASK_RESTART_OR_STOP);
                gameProvider.askRestartOrStop();
            }
        }
    }
}
