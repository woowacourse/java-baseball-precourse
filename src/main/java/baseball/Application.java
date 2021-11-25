package baseball;

public class Application {
    public static void main(String[] args) {
        Game game = new Game();
        game.init();

        while (true) {
            boolean isFinish = game.play();
            if (!isFinish) {
                continue;
            }

            game.printEndMessage();
            boolean isContinue = game.askRestart();
            if (!isContinue) {
                break;
            }

            game.init();
        }
    }
}
