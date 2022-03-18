package baseball;

public class Application {
    public static void main(String[] args) {
        GameManager gm = new GameManager();
        gm.playGame(new BaseballGame());
    }
}
