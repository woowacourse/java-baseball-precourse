import view.BaseBallGame;

public class BaseBallController {

    public static void main(String[] args) {
        BaseBallGame baseBallGame = BaseBallGame.init();

        while (baseBallGame.runnable()) {
            baseBallGame.updateGame(baseBallGame.pitch());
        }
    }
}
