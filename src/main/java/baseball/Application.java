package baseball;

public class Application {
    public static void main(String[] args) {
        Game game = new Game();

        while (true) {
            game.setComputerNumber();
            int result = game.startGame();

            if (result == 2) {
                break;
            }
        }

    }
}
