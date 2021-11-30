package baseball;

public class Application {

    private final static int START = 1;
    private final static int END = 2;

    public static void main(String[] args) {

        Game game = new Game();
        int status = START;

        while (status != END) {

            int isRestart = game.run();

            if (isRestart == END) {
                status = END;
            }
        }

    }
}
