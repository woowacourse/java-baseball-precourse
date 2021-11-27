package baseball;

public class Application {
    private static final String START = "1";

    public static void main(String[] args) {
        String playContinue = START;

        while (playContinue.equals(START)) {
            GameController controller = new GameController();
            playContinue = controller.play();
        }
    }
}
