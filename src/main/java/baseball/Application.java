package baseball;

import baseball.game.Game;

public class Application {
    public static void main(String[] args) {
        Game newGame = new Game();
        newGame.start();
    }
}
