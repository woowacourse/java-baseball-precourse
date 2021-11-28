package baseball;

public class Application {
    public static void main(String[] args) {
        boolean program = false;

        while (!program) {
            BaseballGame game = new BaseballGame();
            program = game.start();
        }
    }
}
