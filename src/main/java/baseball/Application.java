package baseball;

import baseball.model.Game;

public class Application {

    public static void main(String[] args) {
        Game game;

        do {
            game = new Game();
            playGame(game);
            game.readCommand();
        } while (game.isReplay());
    }

    private static void playGame(Game game) {
        do {
            game.play();
        } while (game.isOngoing());
    }
}
