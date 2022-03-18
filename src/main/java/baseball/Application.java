package baseball;

public class Application {
    public static void main(String[] args) {
        GameManager gm = new GameManager();
        while (true) {
            if (!gm.playGame(new BaseballGame())) {
                System.exit(0);
            }
        }
    }
}
