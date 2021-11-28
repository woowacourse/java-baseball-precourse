package baseball;

import static util.GameConstant.*;

public class BaseballGame {
    private GamePlayer gamePlayer;
    private GameComputer gameComputer;

    public BaseballGame(GamePlayer gamePlayer, GameComputer gameComputer) {
        this.gamePlayer = gamePlayer;
        this.gameComputer = gameComputer;
    }

    public void run() {
        while (gameComputer.getGameStatus().equals(ON_GOING)) {
            gamePlayer.insertAnswer();
            GameScore gameScore = gameComputer.checkAnswer(gamePlayer.getPlayerAnswer());
            gameScore.printResult();

            if (gameComputer.getGameStatus().equals(CORRECT)) {
                System.out.println(THREE_STRIKE);
                gameComputer.checkRestartOrStop(gamePlayer.insertRestartOrStop());
            }
        }
    }
}
