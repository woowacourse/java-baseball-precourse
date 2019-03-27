package baseball;

public class App {
    public static void main(String[] args) {
        GameManager gameManager = GameManager.getInstance();
        while (gameManager.isContinueGame()) {
            gameManager.initGame();
        }
    }
}
