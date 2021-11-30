package baseball.service;

import baseball.model.Game;
import baseball.model.Hint;
import baseball.model.Player;
import baseball.util.GamePlayType;

public class GameService {
    private final Game game;

    public GameService() {
        game = new Game();
    }

    public void createComputerAnswer() {
        game.getComputer().createAnswer();
    }

    public boolean checkWhetherToPlay() {
        return game.getPlayer().getGamePlayType() != GamePlayType.GAME_OVER;
    }

    public void selectGamePlayType(int answer) {
        Player player = game.getPlayer();

        if (answer == GamePlayType.GAME_REPLAY.getValue()) {
            player.updateGamePlayType(GamePlayType.GAME_REPLAY);
        } else if (answer == GamePlayType.GAME_OVER.getValue()) {
            player.updateGamePlayType(GamePlayType.GAME_OVER);
        } else {
            throw new IllegalArgumentException();
        }
    }

    public void guessAnswer(int[] answer) {
        game.getPlayer().updateAnswer(answer);
    }

    public Hint getHintForAnswer() {
        Hint hint = game.getHint();
        int[] computerAnswer = game.getComputer().getAnswer();
        int[] playerAnswer = game.getPlayer().getAnswer();

        hint.compareAnswer(computerAnswer, playerAnswer);

        return hint;
    }
}
